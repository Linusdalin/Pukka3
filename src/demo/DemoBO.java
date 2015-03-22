package demo;

import backoffice.BackofficeInterface;
import backoffice.GenericBackoffice;
import backoffice.menu.Menu;
import backoffice.menu.Section;
import backoffice.pages.PageInterface;

/**
 *          Backoffice example for rendering and testing all back office components
 *
 *
 *          //TODO:
 *
 *        *    - Load page dynamically
 *        *    - set a welcome page that will be loaded upon start, configured in the BO and used in the logo/title
 *           - implement container section and page section
 *           - create menu from section tree
 *           - access welcome page from brand title
 *           - create message component
 *           - create alert component
 *           - create task component
 *           - Page tabs
 *
 *           - Add logging
 *           - Add custom exception
 *
 *           - Add login and session
 *
 *           - Add tables with dynamic data loading
 *           - Add filter for tables
 *           - Add accordion
 *           - Add lists
 *
 *           - Add forms with components
 *           - Table edit form
 *
 *
 *
 *           - Add chart support
 *           - Add databox (from dashboard)
 *
 *           - dynamic loading of table content
 *
 *           - implement message component
 *           - implement alert component
 *           - implement task component

 */

public class DemoBO extends GenericBackoffice implements BackofficeInterface {

    public static final PageInterface DemoPage = new DemoPage();

    public DemoBO(){

        Menu menu = new Menu(

                new Section[] {}

        ).withSearch();

        setWelcomePage(DemoPage);
        setMenu(menu);
        setTitle("Pukka 3 Demo");
        addPage(DemoPage);


    }


}
