package demo;

import backoffice.BackofficeInterface;
import backoffice.GenericBackoffice;
import backoffice.acs.ACSInterface;
import backoffice.acs.GoogleACS;
import backoffice.menu.*;
import backoffice.pages.PageInterface;

/**
 *          Backoffice example for rendering and testing all back office components
 *
 *
 *          //TODO:
 *
 *        *    - Load page dynamically
 *        *    - set a welcome page that will be loaded upon start, configured in the BO and used in the logo/title
 *        *   - create message component
 *        *   - create alert component
 *        *   - create task component
 *        *   - implement container section and page section
 *        *   - create menu from section tree
 *        *   - Create an icon class (with rendering) and Assign icons to menu sections
 *        *   - access welcome page from brand title
 *           - Add login and session
 *
 *
 *
 *           - Dynamic page tabs, send tabId in URL
 *
 *           - Add logging
 *           - Add custom exception
 *
 *
 *           - Add tables with dynamic data loading
 *           - Add filter for tables
 *           - Add accordion
 *           - Add lists
 *
 *           - Add forms with components
 *           - Table edit form, (add, edit, delete)
 *
 *           - merge data tables with backoffice
 *
 *           - Add chart support
 *           - Add databox (from dashboard)
 *
 *           - dynamic loading of table content
 *           - Complete all icons
 *
 *           - implement message component
 *           - implement alert component
 *           - implement task component
 *
 *           - Access rights to individual pages
 *           - Register account
 *           - Generic Brand support
 *           - Display Brand
 *           - Form validation
 *           - Pivot table
 *           - Implement search

 */

public class DemoBO extends GenericBackoffice implements BackofficeInterface {

    public static final PageInterface DemoPage = new DemoPage();

    // Create a nav-bar with the optional functionality

    private static final NavBar Navbar = new NavBar()
            .useMessages()
            .useNotifications()
            .useTasks()
    ;
    // Create a menu

    private static final Menu menu = new Menu(

            new SectionInterface[] {

                    new SectionPage("Home", Icon.arrowsH, DemoPage),

                    new SectionContainer("Test", Icon.arrowsV, new SectionInterface[] {

                            new SectionSub("Other", DemoPage),
                            new SectionSub("Other2", DemoPage),

                    }),

            }

    ).withSearch().withNavbar(Navbar);

    private static final ACSInterface acs = new GoogleACS();

    public DemoBO(){


        setWelcomePage(DemoPage);
        setMenu(menu);
        setTitle("Pukka 3 Demo");
        addPage(DemoPage);
        setAcs(acs);


    }


}
