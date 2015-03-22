package backoffice.pages;

import javax.servlet.http.HttpServletRequest;

/************************************************************************'
 *
 *              Interface for a generic page to be rendered
 *
 */

public interface PageInterface {


    String render(HttpServletRequest request);
    String renderDataScripts();
    String getName();
}
