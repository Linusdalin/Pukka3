package backoffice.table;

import backoffice.errorHandling.BackOfficeException;
import backoffice.style.HtmlBlock;

/********************************************************************************''
 *
 *          Generic interface for all tables
 *
 *          Existing table implementations are:
 *
 *          - JSON table - generating a table from a regular JSON Array of JSON objects
 *          - SQL Table  - a table based on a SQL selection from one or many SQL tables
 *
 *
 */
public interface TableInterface {

    // Render the table
    public HtmlBlock toHtml() throws BackOfficeException;

    // Callback functionality  for getting the content as JSON passed to the AJAX request
    public String getJSON() throws BackOfficeException;
}
