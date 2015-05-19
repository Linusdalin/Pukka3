package slotAmerica;

import backoffice.common.Location;
import backoffice.errorHandling.BackOfficeException;
import backoffice.errorHandling.PukkaLogger;
import backoffice.form.*;
import backoffice.menu.Icon;
import backoffice.pages.PageInterface;
import backoffice.pages.grid.GridColumn;
import backoffice.pages.grid.GridRow;
import backoffice.pages.grid.Panel;
import backoffice.pages.grid.PanelType;
import backoffice.pages.template.GridPage;
import backoffice.table.TableInterface;
import style.pageComponents.PageHeader;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *          Campaign page
 */

public class PlayerListPage extends GridPage implements PageInterface {

    private static final String Name = "PlayersPage";
    private static final FormInterface searchForm = new SearchPlayerForm(new Location(Name));

    TableInterface table = new RewardTable();

    Panel tablePanel = new Panel()
            .withTop(Icon.bars, "List Campaigns")
            .withContent("...")
            .withBottom("...");

    Panel formPanel1 = new Panel(PanelType.DEFAULT)
            .withTop(Icon.pencil, "Search Player");



    public PlayerListPage(){


        super(Name, "Search Players");

        try{

            GridRow firstRow = new GridRow(2)
                    .addColumn(new GridColumn(8)

                            .addPanel(tablePanel)
                    )
                    .addColumn(new GridColumn(4)

                            .addPanel(formPanel1)
                    );

            setPageHeader(new PageHeader("Player Support"));
            addRow(firstRow);

        } catch (BackOfficeException e) {

            PukkaLogger.log(e);
        }




    }

    /*************************************************''
     *
     *          The page contains a heading and a tab pane
     *
     * @param request
     * @return
     */


    public String render(HttpServletRequest request){

        try{

            searchForm.populateValues(request);
            formPanel1.withContent(searchForm.renderForm());

            return super.render(request);

        } catch (BackOfficeException e) {

            PukkaLogger.log( e );
        }

        return "Error rendering page";

    }
}

    class SearchPlayerForm extends Form implements FormInterface {

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
            //setAjaxSubmit("http://localhost:3003/createReward", Action.RELOAD);

        }


        public CallbackMessage submitCallBack( HttpServletRequest request){

            return(new CallbackMessage(CallbackMessage.CallbackAction.WARNING, "TODO: No action for form " + name +" implemented."));
        }


    }

