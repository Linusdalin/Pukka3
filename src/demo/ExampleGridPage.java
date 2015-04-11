package demo;

import backoffice.errorHandling.BackOfficeException;
import backoffice.errorHandling.PukkaLogger;
import backoffice.form.FormInterface;
import backoffice.menu.Icon;
import backoffice.pages.grid.GridColumn;
import backoffice.pages.grid.GridRow;
import backoffice.pages.grid.Panel;
import backoffice.pages.GenericPage;
import backoffice.pages.PageInterface;
import backoffice.pages.grid.PanelType;
import backoffice.pages.template.GridPage;
import style.Html;
import style.pageComponents.PageHeader;

import javax.servlet.http.HttpServletRequest;

/****************************************************************
 *
 *
 *              Example page on how to use the grid page
 *
 *
 */

public class ExampleGridPage extends GridPage implements PageInterface {

    // The sections that should be filled with content has to be defined
    // as class variable to be able to easily modify in the render method

    Panel formPanel = new Panel(PanelType.SUCCESS)
            .withTop(Icon.pencil, "Demo form");

    Panel otherPanel = new Panel()
            .withTop(Icon.filter, "Output").withBottom("...");


    public ExampleGridPage(){

        super("Example", "Grid Example");

        try{

            GridRow firstRow = new GridRow(2)
                    .addColumn(new GridColumn(8)

                            .addPanel(formPanel)
                    )
                    .addColumn(new GridColumn(4)

                            .addPanel(otherPanel)
                    );

            setPageHeader(new PageHeader("Example Page with 2/3 grid split"));
            addRow(firstRow);

        } catch (BackOfficeException e) {

            PukkaLogger.log( e );
        }

    }


    /*********************************************************************
     *
     *              Overriding render
     *
     *              Adding dynamic content to the page (from http request data)
     *
     * @param request
     * @return
     */

    @Override
    public String render(HttpServletRequest request){

        try {

            FormInterface exampleForm = new ExampleForm(location);
            exampleForm.populateValues(request);
            formPanel.setContent(exampleForm.renderForm());

            // Example of how to modify the page content:

            if(request.getParameter("text1") == null){

                otherPanel.setContent(Html.paragraph("Output area"));
                otherPanel.setStyle(PanelType.DEFAULT);
            }
            else if(request.getParameter("text1").equals("")){

                otherPanel.setContent(Html.paragraph("No parameter value"));
                otherPanel.setStyle(PanelType.ERROR);
            }
            else{

                    otherPanel.setContent(Html.paragraph("The parameter value is: \"" + request.getParameter("text1") + "\""));
                    otherPanel.setStyle(PanelType.SUCCESS);

            }


            return super.render(request);

        } catch (BackOfficeException e) {

            PukkaLogger.log( e );
        }

        return "Error rendering page";



    }

    @Override
    public String renderDataScripts(){

        return  "            <script src=\"adminCommon/pukka.js\"></script>\n";

    }


}
