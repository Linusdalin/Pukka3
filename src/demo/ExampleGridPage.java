package demo;

import backoffice.errorHandling.BackOfficeException;
import backoffice.errorHandling.PukkaLogger;
import backoffice.form.FormInterface;
import backoffice.menu.Icon;
import backoffice.pages.grid.*;
import backoffice.pages.PageInterface;
import backoffice.pages.template.GridPage;
import backoffice.style.HtmlBlock;
import backoffice.table.SQLTable;
import backoffice.table.Table;
import backoffice.style.Html;
import backoffice.style.pageComponents.PageHeader;

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

    PanelInterface formPanel = new Panel(PanelType.SUCCESS, Icon.pencil)
            .withTop("Demo form");

    PanelInterface otherPanel = new Panel(PanelType.DEFAULT, Icon.filter)
            .withTop("Output").withBottom("...");

    PanelInterface dummyPanel = new Panel()
            .withTop(Icon.book, "Lorem Ipsum")
            .withContent(new HtmlBlock("Dolor sit amet"))
            .withStyle(PanelType.INFO);

    Table dummyTable = new SQLTable();

    Accordion accordion = new Accordion()
            .addSection(dummyPanel)
            .addSection(dummyPanel);

    PanelInterface accordionPanel = new Panel()
            .withTop(Icon.bars, "Accordion")
            .withContent(accordion)
            .withBottom("...");

    PanelInterface tablePanel = new Panel()
            .withTop(Icon.bars, "Table Example")
            .withContent(dummyTable)
            .withBottom("...");

    public ExampleGridPage(){

        super("Example", "Grid Example");

        try{

            GridRow firstRow = new GridRow(2)
                    .addColumn(new GridColumn(8)

                            .addPanel(formPanel)
                            .addPanel(tablePanel)
                    )
                    .addColumn(new GridColumn(4)

                            .addPanel(otherPanel)
                            .addPanel(accordionPanel)
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
     * @param request        - the request parameters
     * @return               - html
     */

    @Override
    public HtmlBlock toHtml(HttpServletRequest request){

        try {

            FormInterface exampleForm = new ExampleForm(location);
            exampleForm.populateValues(request);
            formPanel.withContent(exampleForm.renderForm());

            // Example of how to modify the page content:

            if(request.getParameter("text1") == null){

                otherPanel.withContent(new HtmlBlock(Html.paragraph("Output area")));
                otherPanel.withStyle(PanelType.DEFAULT);
            }
            else if(request.getParameter("text1").equals("")){

                otherPanel.withContent(new HtmlBlock(Html.paragraph("No parameter value")));
                otherPanel.withStyle(PanelType.ERROR);
            }
            else{

                    otherPanel.withContent(new HtmlBlock(Html.paragraph("The parameter value is: \"" + request.getParameter("text1") + "\"")));
                    otherPanel.withStyle(PanelType.SUCCESS);

            }


            return super.toHtml(request);

        } catch (BackOfficeException e) {

            PukkaLogger.log( e );
        }

        return new HtmlBlock(Html.paragraph("Error rendering page"));



    }

    //TODO: Recursively go through all components and render the scripts that components require

    @Override
    public HtmlBlock renderDataScripts(){

        return  new HtmlBlock("            <script src=\"adminCommon/pukka.js\"></script>\n" +
                "    <!-- Page-Level Demo Scripts - Tables - Use for reference -->\n" +
                        "    <script>\n" +
                        "    $(document).ready(function() {\n" +
                        "        $('#dataTables-example').DataTable({\n" +
                        "                responsive: true\n" +
                        "        });\n" +
                        "    });\n" +
                        "    </script>\n" +
                "\n\n");

    }


}
