package demo;

import backoffice.BackofficeInterface;
import backoffice.GenericBackoffice;
import backoffice.acs.ACSInterface;
import backoffice.acs.GoogleACS;
import backoffice.menu.*;
import backoffice.pages.EmptyPage;
import backoffice.pages.ExampleLightboxPage;
import backoffice.pages.ExamplePage;
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
 *        *   - Add ACS and Google SSO
 *
 *
 *           - implement lightbox component
 *           - Static and dynamic page tabs, send tabId in URL
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
 *           - Add ACSUser table (plus connect to Google SSO)
 *
 *           - Add forms with components
 *           - merge data tables with backOffice
 *           - Table edit form, (add, edit, delete)
 *
 *
 *           - Add chart support
 *           - Add and standardize data box (from dashboard)
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
 *           - Implement separate login page and a real local ACS impl (incl password management)
 *
 *           - implement event (automatically generate a service, queuing request and a handling callback)
 *
 *           - reverse lookup and table filter for tables
 *
 *           - implement email sending
 *           - landing page for external service (no menu)
 *           - implement external service create account
 *           - implement password reminder
 *           - task scheduler
 *
 *
 *           - implement Facebook SSO

 */

public class DemoBO extends GenericBackoffice implements BackofficeInterface {

    // Define all pages in the back office

    public static final PageInterface DemoPage = new DemoPage();
    public static final PageInterface ExamplePage = new ExamplePage();
    public static final PageInterface ExampleLightbox = new ExampleLightboxPage();

    // Create a nav-bar with the optional functionality

    private static final NavBar Navbar = new NavBar()
            .useMessages()
            .useNotifications()
            .useTasks();

    // Create a menu

    private static final Menu menu = new Menu(

            new SectionInterface[] {

                    new SectionPage("Home", Icon.arrowsH, DemoPage),

                    new SectionContainer("Test", Icon.arrowsV, new SectionInterface[] {

                            new SectionSub("Demo", DemoPage),
                            new SectionSub("Example2", ExamplePage),

                    }),

            })
            .withSearch()
            .withNavbar(Navbar);

    // Define which access control system we shall use

    private static final ACSInterface acs = new GoogleACS();

    /***********************************************************
     *
     *          Create the backOffice with the
     *          defined configurations
     *
     */

    public DemoBO(){


        setWelcomePage(DemoPage);
        setMenu(menu);
        setTitle("Pukka 3 Demo");
        addPage(DemoPage);
        addPage(ExamplePage);
        addPage(ExampleLightbox);
        setAcs(acs);


    }


}
