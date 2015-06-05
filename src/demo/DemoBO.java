package demo;

import backoffice.acs.ACSUser;
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
import dataModel.table.DataTableInterface;

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
 *        *   - Wells and panels (as standard components in the backoffice)
 *
 *        *   - Add accordion
 *           - Add tables
 *                   *   - add table from demo
 *                      - render table and accordion at render time with request parameter passing (store component interface in panel)
 *                      - render table content statically with page
 *                      - add delete and edit buttons to table
 *                      - add init script for table
 *                      - verify tables in accordion
 *
 *
 *           - Implement form framework
 *                      * - Add forms with basic components
 *                      * - form submit
 *                      * - prefill form
 *                      - post ajax json
 *                      - checkbox, radiobutton and dropdown
 *                      - date-picker
 *
 *
 *           - New data tables with backOffice
 *                      * - Basic Structure
 *                      * - Basic columns
 *                      *- DBKeyInterface
 *                      * - DataTableInterface
 *                      * - New simpler model
 *                      * - Implement store
 *                      * - Implement delete
 *                      * - populate values
 *                      * - Port conditions
 *                      * - Implement Load Object
 *                      * - Implement Load list
 *                      * - Replace symbolic references
 *                      * - Implement update
 *                  - Get allXforY() method (generate methods for all)
 *                  - Get value list with type (generate method)
 *                  - Complete columns with timestamp, different string lengths
 *                  - Implement Iterator
 *
 *           - New data generation
 *                      * - generate files
 *                      * - replace files
 *
 *           - Table edit form, (add, edit, delete)
 *           - Add filter for tables (one filter value and pass this as parameter)
 *           - Add lists with actions
 *           - Add group by list
 *           - Create 2 appropriate Pukka3 artifacts (appStore and MySQL)
 *
 *
 *
 *           =====  Replace itClarifies Backoffice ===
 *
 *           - Complete all icons
 *           - Unit test coverage sweep
 *           - Method documentation sweep
 *           - t o d o sweep. Fix critical and backlog others
 *           - Class diagram documentation
 *           - Create simple manual
 *                  - create tables/objects
 *                  - back office components
 *                  - Data access and conditions
 *
 *            ==== Pukka 0.9 prototyping model release =====
 *
 *           - Add ACSUser table (plus connect to Google SSO)
 *
 *           - Advanced Table
 *                  - dynamic loading of table content
 *                  - reverse lookup for tables
 *                  - implement range filter for tables
 *                  - Checkbox multi-selection for table- and list actions
 *                  - add generic table styling and row styling depending on a column value (highlight filter)
 *
 *           - Automatic generation of a servlet framework given parameters and config
 *
 *           - SQL tables
 *                  - Database implementation
 *
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
 *
 *           - Generic Brand support
 *           - Display Brand
 *
 *           - Add option for AJAX-loaded panels and connect action to the panel to switch

 *
 *           - implement event (automatically generate a service, queuing request and a handling callback)
 *
 *           - Advanced form
 *              - Form validation
 *              - Dynamic form fields
 *              - Two column and side by side styling
 *
 *
 *           - Expand-all for accordion
 *
 *
 *           - Implement separate login page and a real local ACS impl (incl password management)
 *           - implement message component
 *           - implement alert component
 *           - implement task component
 *           - Implement search
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

    public static final DataTableInterface Table1 = new DemoItemTable();
    public static final DataTableInterface Table2 = new DemoItem2Table();



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

    private static final ACSUser[] AllowedUsers = new ACSUser[] {
            new ACSUser("linus", "linus.dalin@itclarifies.com"),
    };


    private static final ACSInterface acs = new GoogleACS(AllowedUsers);

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

        // Add tables

        addTable(Table1);
        addTable(Table2);


        setAcs(acs);


    }


}
