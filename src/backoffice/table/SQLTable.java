package backoffice.table;

import backoffice.errorHandling.BackOfficeException;
import backoffice.style.Html;
import backoffice.style.HtmlBlock;

/**********************************************************'
 * Created with IntelliJ IDEA.
 * User: Linus
 * Date: 2015-06-22
 * Time: 18:19
 * To change this template use File | Settings | File Templates.
 */

public class SQLTable extends Table implements TableInterface {

        // Render the table
    public HtmlBlock toHtml() throws BackOfficeException{

        return new HtmlBlock(Html.paragraph("not implemented"));
    }

    // Callback functionality  for getting the content as JSON passed to the AJAX request
    public String getJSON() throws BackOfficeException{

        return "not implemetned";
    }

}
