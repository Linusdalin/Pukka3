package backoffice;

import backoffice.menu.Menu;
import backoffice.pages.EmptyPage;
import backoffice.pages.PageInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Linus
 * Date: 2015-03-21
 * Time: 22:00
 * To change this template use File | Settings | File Templates.
 */

abstract public class GenericBackoffice {

    protected Menu menu;
    List<PageInterface> pages = new ArrayList<PageInterface>();

    public GenericBackoffice(){

        //Standard components for all systems
        pages.add(new EmptyPage());

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



}
