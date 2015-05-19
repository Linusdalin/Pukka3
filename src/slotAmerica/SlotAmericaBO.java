package slotAmerica;

import backoffice.acs.ACSInterface;
import backoffice.acs.GoogleACS;
import backoffice.common.BackofficeInterface;
import backoffice.common.GenericBackoffice;
import backoffice.common.Location;
import backoffice.form.FormInterface;
import backoffice.menu.*;
import backoffice.pages.PageInterface;
import demo.*;

/**
 *
 *
 *          //TODO:
 *

 */

public class SlotAmericaBO extends GenericBackoffice implements BackofficeInterface {

    // Define all pages in the back office

    public static final PageInterface RewardPage = new CampaignsPage();
    public static final PageInterface AboutRewardsPage = new AboutRewardsPage();
    public static final PageInterface PlayerListPage = new PlayerListPage();

    public static final FormInterface TestForm = new ExampleForm(new Location(RewardPage.getName()));
    public static final FormInterface SearchPlayerForm = new SearchPlayerForm(new Location(RewardPage.getName()));


    // Create a nav-bar with the optional functionality

    private static final NavBar Navbar = new NavBar()
            .useMessages()
            .useNotifications()
            .useTasks()
             ;

    // Create a menu

    private static final Menu menu = new Menu(

            new SectionInterface[] {


                    new SectionContainer("Rewards", Icon.usd, new SectionInterface[] {

                            new SectionSub("About", AboutRewardsPage),
                            new SectionSub("Campaigns", RewardPage),

                    }),

                    new SectionContainer("Support", Icon.question, new SectionInterface[] {

                            new SectionSub("Player", PlayerListPage),

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

    public SlotAmericaBO(){


        setWelcomePage(AboutRewardsPage);
        setMenu(menu);
        setTitle("WinterStone Games CRM");

        addPage(AboutRewardsPage);
        addPage(RewardPage);
        addPage(PlayerListPage);

        addForm(TestForm);
        addForm(SearchPlayerForm);

        // Add tables


        setAcs(acs);


    }


}
