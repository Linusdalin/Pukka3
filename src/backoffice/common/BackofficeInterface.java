package backoffice.common;

import backoffice.acs.ACSInterface;
import backoffice.form.FormInterface;
import backoffice.lightbox.LightboxInterface;
import backoffice.menu.Menu;
import backoffice.menu.NavBar;
import backoffice.pages.PageInterface;

/******************************************************************
 *
 *          Common functionality for a backOffice
 */

public interface BackofficeInterface {

    public ACSInterface getAcs();
    public void setAcs(ACSInterface acs);



    Menu getMenu();

    PageInterface getPageByName(String pageName);
    FormInterface getFormByName(String formName);
    LightboxInterface getLightBoxByName(String name);

    String getSystemTitle();
    PageInterface getWelcomePage();

    NavBar getNavbar();

}
