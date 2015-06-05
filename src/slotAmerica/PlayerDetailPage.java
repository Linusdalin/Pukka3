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
            .withContent("");


    PanelInterface tablePanel = new Panel()
            .withTop(Icon.bars, "Payment History")
            .withContent("...")
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


    public String render(HttpServletRequest request){

        try{

            String playerId = request.getParameter("player");

            setPageHeader(new PageHeader("Player -" + playerInfo.getSpan( 2 )  ));

            detailsPanel.withContent("<p>Facebook id :" + playerId + "</p> <p>Gender : "+ playerInfo.getSpan( 1 )+"</p> <p>Coins: "+ playerInfo.getSpan( 0 )+"</p>");

            // Set the player id here
            giveCoinsForm.populateValue(1, playerId);
            formPanel1.withContent(giveCoinsForm.renderForm());

            playerInfo.setURL("https://test.slot-america.com/getPlayerDetails?playerId=" + playerId);
           totalPayment.withValue(playerInfo.getSpan( 3 ));

            return super.render(request);

        } catch (BackOfficeException e) {

            PukkaLogger.log( e );
        }

        return "Error rendering page";

    }

    /***************************************************************'
     *
     *          Give comp
     *
     *
     */

    static class GiveCoinsForm extends Form implements FormInterface {

        List<FormFieldInterface> fields = new ArrayList<FormFieldInterface>();


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
            setAjaxSubmit("https://test.slot-america.com/addCoins?auth=c7849722a97707d96ceb356d2417a4bf", Action.RELOAD);

        }


        public callbackMessage submitCallBack( HttpServletRequest request){

            if(request.getParameter("player") == null)
                return(new callbackMessage(callbackMessage.CallbackAction.ERROR, "No user id given"));

            return new callbackMessage(callbackMessage.CallbackAction.WARNING, "Give coins not implemented");
        }


    }


}