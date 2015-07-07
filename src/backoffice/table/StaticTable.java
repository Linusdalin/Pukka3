package backoffice.table;

import backoffice.errorHandling.BackOfficeException;
import backoffice.errorHandling.PukkaLogger;
import backoffice.style.HtmlBlock;

import java.util.ArrayList;
import java.util.List;

/***************************************************************************'''
 *
 *
 *          Backoffice table component based on a ragular <td> data
 *
 *
 */
public class StaticTable extends Table implements TableInterface {

    private String name;
    private String[] columnNames;
    private int[] columnIds;

    private List<String[]> rows = new ArrayList<String[]>();

    /*****************************************************************'
     *
     *              Define the table completely data independent
     *
     *
     * @param name              - Table name. Should be unique for all tables on this page
     * @param columnNames       - array of all column names
     * @param columnIds         - array of the ids of the values that are used fro the column
     */


    public StaticTable(String name, String[] columnNames, int[] columnIds){

        this.name = name;
        this.columnNames = columnNames;
        this.columnIds = columnIds;

    }


    public void addRow(String[] values){

        rows.add(values);

    }



    public HtmlBlock toHtml() throws BackOfficeException{

        HtmlBlock html = new HtmlBlock();

        html.append(
                        "               <div class=\"dataTable_wrapper\">\n" +
                        "                   <table class=\"table table-striped table-bordered table-hover\" id=\""+ name +"\">\n" +
                        "                       <thead>\n" +
                        "                           <tr>\n");
        for (String columnName : columnNames) {

            html.append("                               <th>" + columnName + "</th>\n");
        }


        html.append(    "                                       </tr>\n" +
                        "                                    </thead>\n" +
                        "                                    <tbody>\n");

        for (String[] row : rows) {

            html.append(toTableRow(row));
        }


        html.append(    "                                    </tbody>\n" +
                        "                                </table>\n" +
                        "                            </div>" +
                        "    <!-- Page-Level Demo Scripts - Tables - Use for reference -->\n" +
                        "    <script>\n" +
                        "    $(document).ready(function() {\n" +
                        "        $('#"+name+"').DataTable({\n" +
                        "                responsive: true\n" +
                        "        });\n" +
                        "    });\n" +
                        "    </script>\n"
        );


        return html;
    }


    /******************************************************************'
     *
     *              Create a table row by using the values defined by the columns array
     *
     *
     * @param values        - all values
     * @return              - html table
     */


    public HtmlBlock toTableRow(String[] values) throws BackOfficeException{

        HtmlBlock html = new HtmlBlock();
        html.append("      <tr class=\"odd gradeX\">\n");



        for (int colNo : columnIds) {

            if(colNo < 0 ||  colNo > values.length)
                throw new BackOfficeException(BackOfficeException.Type.CONFIGURATION, "Column " + colNo + " is not valid for the table row. Only " + values.length + " values.");

            html.append("         <td class=\"center\">"+values[colNo] + "</td>\n");
        }

        html.append("      </tr>\n");
        return html;
    }



}
