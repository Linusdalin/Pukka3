package backoffice.pages;

import backoffice.errorHandling.BackOfficeException;

import javax.servlet.http.HttpServletRequest;

/************************************************************************'
 *
 *              Interface for a generic page to be rendered
 *
 */

public interface PageInterface {


    String render(HttpServletRequest request) throws BackOfficeException;
    String renderDataScripts();
    String getName();
}
