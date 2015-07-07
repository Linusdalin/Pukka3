package backoffice.pages;

import backoffice.errorHandling.BackOfficeException;
import backoffice.style.HtmlBlock;

import javax.servlet.http.HttpServletRequest;

/************************************************************************'
 *
 *              Interface for a generic page to be rendered
 *
 */

public interface PageInterface {


    HtmlBlock toHtml(HttpServletRequest request) throws BackOfficeException;
    HtmlBlock renderDataScripts();
    String getName();
}
