package backoffice;

import backoffice.menu.Menu;
import backoffice.pages.PageInterface;

/**
 * Created with IntelliJ IDEA.
 * User: Linus
 * Date: 2015-03-21
 * Time: 22:11
 * To change this template use File | Settings | File Templates.
 */
public interface BackofficeInterface {

    Menu getMenu();

    PageInterface getPageByName(String pageName);
}
