package demo;

import backoffice.BackofficeInterface;
import backoffice.GenericBackoffice;
import backoffice.menu.Menu;
import backoffice.menu.Section;
import backoffice.pages.PageInterface;

/**
 *          Backoffice example for rendering and testing all back office components
 *
 */

public class DemoBO extends GenericBackoffice implements BackofficeInterface {

    public static final PageInterface DemoPage = new DemoPage();

    public DemoBO(){

        menu = new Menu(

                new Section[] {}

        ).withSearch();

        addPage(DemoPage);


    }


}
