package slotAmerica;

import backoffice.common.Location;
import backoffice.errorHandling.BackOfficeException;
import backoffice.errorHandling.PukkaLogger;
import backoffice.form.FormInterface;
import backoffice.menu.Icon;
import backoffice.pages.PageInterface;
import backoffice.pages.grid.*;
import backoffice.pages.template.GridPage;
import backoffice.table.TableInterface;
import backoffice.style.pageComponents.PageHeader;

import javax.servlet.http.HttpServletRequest;

/**
 *
 *          Campaign page
 */

public class CampaignsPage extends GridPage implements PageInterface {

    private static final String Name = "CampaignPage";
    private static final FormInterface createForm = new CreateRewardForm(new Location(Name));
    private static final FormInterface deleteForm = new DeleteRewardForm(new Location(Name));
    TableInterface table = new RewardTable();

    PanelInterface tablePanel = new Panel()
            .withTop(Icon.bars, "List Campaigns")
            .withContent(table)
            .withBottom("...");

    PanelInterface formPanel1 = new Panel(PanelType.SUCCESS)

            .withTop(Icon.pencil, "Create New Campaign");

    PanelInterface formPanel2 = new Panel(PanelType.WARNING)
            .withTop(Icon.pencil, "Delete Campaign");


    public CampaignsPage(){


        super("name", "List, Create and Delete rewards");

        try{

            GridRow firstRow = new GridRow(2)
                    .addColumn(new GridColumn(8)

                            .addPanel(tablePanel)
                    )
                    .addColumn(new GridColumn(4)

                            .addPanel(formPanel1)
                            .addPanel(formPanel2)
                    );

            setPageHeader(new PageHeader("List and Create Campaigns"));
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

            createForm.populateValues(request);
            formPanel1.withContent(createForm.renderForm());
            formPanel2.withContent(deleteForm.renderForm());

            return super.render(request);

        } catch (BackOfficeException e) {

            PukkaLogger.log( e );
        }

        return "Error rendering page";

    }


    /*
    @Override
    public String renderDataScripts(){

        return  new TestForm(new Location("TestPage")).getSubmitScript();

    }
      */

}
