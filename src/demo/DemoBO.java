package demo;

import backoffice.common.BackofficeInterface;
import backoffice.common.GenericBackoffice;
import backoffice.acs.ACSInterface;
import backoffice.acs.GoogleACS;
import backoffice.common.Location;
import backoffice.form.FormInterface;
import backoffice.lightbox.DynamicModal;
import backoffice.lightbox.LightboxInterface;
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
 *        *   - Add ACS and Google SSO
 *
 *        *   - light box loading from light box Servlet
 *        *   - implement light box component to render a light box link (with script
 *        *   - Static page tabs, send tabId in URL, tab name in title
 *        *   - Add error boxes
 *        *   - Add logging
 *        *   - Add custom exception
 *
 *
 *           - Implement form framework
 *                      * - Add forms with basic components
 *                      * - form submit
 *                      * - prefill form
 *                      - checkbox, radiobutton and dropdown
 *                      - date-picker
 *
 *           - Wells and panels (as standard components in the backoffice)
 *           - Add accordion
 *
 *
 *           - Add tables with dynamic data loading
 *
 *
 *           - merge data tables with backOffice
 *           - Table edit form, (add, edit, delete)
 *           - Add filter for tables (one filter value and pass this as parameter)
 *           - Add lists with actions
 *           - Add group by list
 *
 *
 *           - Complete all icons
 *           - dynamic loading of table content
 *
 *
 *           - Access rights to backoffice pages
 *
 *           =====  Replace itClarifies Backoffice ===
 *
 *           - Add ACSUser table (plus connect to Google SSO)
 *
 *           - Add chart support
 *           - Add and standardize data box (from dashboard)
 *
 *           - User account
 *              - portal user  w admin/full or read access
 *              - signup page w signup form
 *              - invite user
 *              - access rights for pages
 *
 *           - Generic Brand support
 *           - Display Brand
 *           - Form validation
 *           - Implement search
 *           - Implement separate login page and a real local ACS impl (incl password management)

 *           - implement message component
 *           - implement alert component
 *           - implement task component

 *
 *           - implement event (automatically generate a service, queuing request and a handling callback)
 *
 *           - reverse lookup and table filter for tables
 *           - Form validation
 *
 *           - Creating dynamic page tabs
 *           - implement email sending
 *           - landing page for external service (no menu)
 *           - implement external service create account
 *           - implement password reminder
 *           - task scheduler
 *
 *           - Pivot table
 *
 *           - implement Facebook SSO

 */

public class DemoBO extends GenericBackoffice implements BackofficeInterface {

    // Define all pages in the back office

    public static final PageInterface DemoPage = new DemoPage();
    public static final PageInterface ExamplePage = new ExampleGridPage();
    public static final PageInterface ExampleLightBoxPage = new ExampleLightboxPage();
    public static final PageInterface ExampleTabPage = new demo.ExampleTabPage();

    public static final FormInterface ExampleForm = new ExampleForm(new Location(ExampleLightBoxPage.getName()));

    public static final LightboxInterface ExampleLightBox = new DynamicModal();

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
                            new SectionSub("Lightbox", ExampleLightBoxPage),
                            new SectionSub("Tabs", ExampleTabPage),

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
        addPage(ExampleLightBoxPage);
        addPage(ExampleTabPage);


        addLightBox(ExampleLightBox);

        addForm(ExampleForm);


        setAcs(acs);


    }


}
