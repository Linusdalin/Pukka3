package slotAmerica;

import backoffice.common.Location;
import backoffice.errorHandling.BackOfficeException;
import backoffice.errorHandling.PukkaLogger;
import backoffice.form.*;
import backoffice.menu.Icon;
import backoffice.pages.PageInterface;
import backoffice.pages.grid.*;
import backoffice.pages.template.GridPage;
import backoffice.style.pageComponents.PageHeader;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/*****************************************************************************
 *
 *          Player search page
 */

public class PlayerSearchPage extends GridPage implements PageInterface {

    private static final String Name = "PlayerSearch";
    private static final FormInterface searchForm = new SearchPlayerForm(new Location(Name));

    // Panel to list the latest payments from the database

    PanelInterface tablePanel = new Panel()
            .withTop(Icon.bars, "Latest Payments")
            .withContent("...")
            .withBottom("");


    PanelInterface formPanel1 = new Panel(PanelType.DEFAULT)
            .withTop(Icon.pencil, "Search Player");

    /******************************************************************
     *
     *      Create the page
     *
     */

    public PlayerSearchPage(){

        super(Name, "Search Players");

        try{


            GridRow mainRow = new GridRow(2)
                    .addColumn(new GridColumn(8)

                            .addPanel(tablePanel)
                    )
                    .addColumn(new GridColumn(4)

                            .addPanel(formPanel1)
                    );

            addRow(mainRow);

        } catch (BackOfficeException e) {

            PukkaLogger.log(e);
        }

    }

    /*************************************************''
     *
     *          The page contains a heading and a tab pane
     *
     * @param request         - request for dynamically populating
     * @return                - html
     */


    public String render(HttpServletRequest request){

        try{

            setPageHeader(new PageHeader("Search Player "));

            searchForm.populateValues(request);
            formPanel1.withContent(searchForm.renderForm());

            return super.render(request);

        } catch (BackOfficeException e) {

            PukkaLogger.log( e );
        }

        return "Error rendering page";

    }


    /***************************************************************'
     *
     *          Search player
     *
     *
     */

    static class SearchPlayerForm extends Form implements FormInterface {

        List<FormFieldInterface> fields = new ArrayList<FormFieldInterface>();


        public SearchPlayerForm(Location location){

            super("SearchPlayer", location);


            fields.add(new TextField("player")
                                .withLabel("PlayerId")
                                .withPlaceholder("facebook id ")
                                );


            fields.add(new Button("submit")
                                .withValue("Search!"));



            setElements(fields);
            setTarget(SlotAmericaBO.PlayerDetailPage);
            //setAjaxSubmit("http://localhost:3003/createReward", Action.RELOAD);

        }


        public callbackMessage submitCallBack( HttpServletRequest request){

            if(request.getParameter("player") == null)
                return(new callbackMessage(callbackMessage.CallbackAction.ERROR, "No user id given"));

            return new callbackMessage(callbackMessage.CallbackAction.NO_ACTION, "");
        }


    }
}

