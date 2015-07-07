package slotAmerica;

import backoffice.common.Location;
import backoffice.errorHandling.BackOfficeException;
import backoffice.errorHandling.PukkaLogger;
import backoffice.form.*;
import backoffice.links.InternalLink;
import backoffice.menu.Icon;
import backoffice.modules.dynamicVariable.DynamicLoader;
import backoffice.pages.PageInterface;
import backoffice.pages.grid.*;
import backoffice.pages.template.GridPage;
import backoffice.style.Html;
import backoffice.style.HtmlBlock;
import backoffice.style.pageComponents.PageHeader;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *          Player Details page page
 */

public class PlayerDetailPage extends GridPage implements PageInterface {

    private static final String Name = "PlayerDetails";

    private static final FormInterface giveCoinsForm = new GiveCoinsForm(new Location(Name));

    PanelInterface detailsPanel = new Panel()
            .withTop(Icon.bars, "Player Details")
            .withContent();


    PanelInterface tablePanel = new Panel()
            .withTop(Icon.bars, "Payment History")
            .withBottom("");


    KPIPanel totalPayment = new KPIPanel(Icon.usd)
            .withValue(-1)
            .withText("Total Spend")
            .withLink("More...", new InternalLink("http://www.aftonbladet.se"));


    PanelInterface totalSessions = new KPIPanel(Icon.calendar)
            .withValue(0)
            .withText("Sessions")
            .withStyle(PanelType.SUCCESS);

    DynamicLoader playerInfo = new DynamicLoader()
            .withSubstitution("playerDetails.balance",              "coinBalance")
            .withSubstitution("playerDetails.gender",               "playerGender")
            .withSubstitution("playerDetails.name",                 "playerName")
            .withSubstitution("playerDetails.paymentsTotal",        "paymentsTotal");

    // - first name, last name, country,  email, coin balance, registration date, last activity, total spend, payment count, total playing days, total sessions, campaign code, group classification


    PanelInterface formPanel1 = new Panel(PanelType.DEFAULT)
            .withTop(Icon.usd, "Comp");



    public PlayerDetailPage(){


        super(Name, "Search Players");

        try{

            GridRow topRow = new GridRow(1)
                    .addColumn(new GridColumn(8)
                            .addPanel(detailsPanel))
            ;

            GridRow dashboardRow = new GridRow(2)
                    .addColumn(new GridColumn(2)
                            .addPanel(totalPayment))
                    .addColumn(new GridColumn(2).addPanel(totalSessions))
            ;


            GridRow mainRow = new GridRow(2)
                    .addColumn(new GridColumn(8)

                            .addPanel(tablePanel)
                    )
                    .addColumn(new GridColumn(4)

                            .addPanel(formPanel1)
                    );

            addRow(topRow);
            addRow(dashboardRow);
            addRow(mainRow);

            addDynamicLoader(playerInfo);

        } catch (BackOfficeException e) {

            PukkaLogger.log(e);
        }

    }

    /*************************************************''
     *
     *          The page contains a heading and a tab pane
     *
     * @param request         - the request to populate values
     * @return                - the html page
     */


    public HtmlBlock toHtml(HttpServletRequest request){

        try{

            String serverURL = ServerManager.getServerURL();      // Get the server for the correct environment

            String playerId = request.getParameter("player");

            setPageHeader(new PageHeader("Player -" + playerInfo.getSpan( 2 )  ));

            detailsPanel.withContent(new HtmlBlock(Html.paragraph("Facebook id :" + playerId + "</p> <p>Gender : "+ playerInfo.getSpan( 1 )+"</p> <p>Coins: "+ playerInfo.getSpan( 0 )+"")));

            // Set the player id here
            giveCoinsForm.populateValue(1, playerId);
            formPanel1.withContent(giveCoinsForm.renderForm());

            playerInfo.setURL(serverURL + "/getPlayerDetails?playerId=" + playerId);
            totalPayment.withValue(playerInfo.getSpan( 3 ));


            // Add the payments data
            tablePanel.withContent(getPayments(playerId));

            return super.toHtml(request);

        } catch (BackOfficeException e) {

            PukkaLogger.log( e );
        }

        return new HtmlBlock("Error rendering page");

    }

    private HtmlBlock getPayments(String playerId) {

        HtmlBlock tableContent = new HtmlBlock();

        PaymentTable paymentTable = new PaymentTable("sessions.playerId = '" + playerId + "'"  , 99);

        tableContent.append(paymentTable.render());

        return tableContent;


    }

    /***************************************************************'
     *
     *          Give comp
     *
     *
     */

    static class GiveCoinsForm extends Form implements FormInterface {

        List<FormFieldInterface> fields = new ArrayList<FormFieldInterface>();
        String serverURL = ServerManager.getServerURL();      // Get the server for the correct environment


        public GiveCoinsForm(Location location){

            super("GiveCoins", location);

            fields.add(new TextField("coins")
                                .withLabel("Amount")
                                .withPlaceholder("coin amount to give away ")
                                );

            fields.add(new HiddenField("playerId")  );

            fields.add(new Button("submit")
                                .withValue("Give!"));


            setElements(fields);
            setMethodGET();
            setAjaxSubmit(serverURL + "/addCoins?auth=c7849722a97707d96ceb356d2417a4bf", Action.RELOAD);

        }


        public callbackMessage submitCallBack( HttpServletRequest request){

            if(request.getParameter("player") == null)
                return(new callbackMessage(callbackMessage.CallbackAction.ERROR, "No user id given"));

            return new callbackMessage(callbackMessage.CallbackAction.WARNING, "Give coins not implemented");
        }


    }


}