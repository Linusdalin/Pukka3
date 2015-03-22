package backoffice.menu;

import backoffice.pages.PageInterface;

/*****************************************************************************
 *
 *          A section page is a section that has a page associated
 */

public class SectionPage implements SectionInterface{

    String name;
    PageInterface page = null;

    public SectionPage(String name, PageInterface page){

        this.name = name;
        this.page = page;
    }

    public String render(){

        return " ...";
    }

}
