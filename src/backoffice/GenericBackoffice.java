package backoffice;

import backoffice.acs.ACSInterface;
import backoffice.acs.OpenDoorACS;
import backoffice.menu.Menu;
import backoffice.menu.NavBar;
import backoffice.pages.EmptyPage;
import backoffice.pages.PageInterface;

import java.util.ArrayList;
import java.util.List;

/**********************************************************************''''
 *
 *
 *          General BackOffice functionality.
 *
 *          All backOffice implementations extends this interface
 *
 *
 */

abstract public class GenericBackoffice {

    private Menu menu;
    private String title = "Default Title";
    private List<PageInterface> pages = new ArrayList<PageInterface>();
    private PageInterface homePage;
    private ACSInterface acs;


    public GenericBackoffice(){

        //Standard components for all systems
        pages.add(new EmptyPage());
        acs = new OpenDoorACS();


    }

    protected void setMenu(Menu menu) {

        this.menu = menu;
    }



    public Menu getMenu() {

        return menu;

    }

    public PageInterface getPageByName(String pageName) {

        if(pageName == null)
            return getPageByName("404");

        for (PageInterface page : pages) {
             if(page.getName().equals(pageName))
                 return page;
        }

        return getPageByName("404");


    }

    protected void addPage(PageInterface page) {

        pages.add(page);

    }

    public void setTitle(String title){

        this.title = title;
    }


    public String getSystemTitle() {
        return title;
    }

    protected void setWelcomePage(PageInterface page) {

        this.homePage = page;
    }

    public PageInterface getWelcomePage() {

        return homePage;
    }

    public NavBar getNavbar() {

        return menu.getNavBar();
    }


    public ACSInterface getAcs() {
        return acs;
    }

    public void setAcs(ACSInterface acs) {
        this.acs = acs;
    }
}
