package backoffice.menu;

import backoffice.pages.PageInterface;

/*****************************************************************************
 *
 *          A section page is a section that has a page link
 *          associated and no sub sections
 */

public class SectionPage extends GenericSection implements SectionInterface{

    String name;
    PageInterface page = null;

    /*******************************************************'
     *
     *          Create a new Section
     *
     * @param name      - Name to be displayed in the menu
     * @param icon      - icon to display
     * @param page      - The page to link to
     */

    public SectionPage(String name, Icon icon, PageInterface page){

        this.name = name;
        this.page = page;
        this.icon = icon;
    }

    /*******************************************************************
     *
     *
     *
     * @param level
     * @return
     */

    public String render(int level){

        if(level > 1)
            System.out.println("Section page only supported on level 1. " + name + " configured on level " + level);

        return "                        <li><a href=\"/page?page="+name+"\">"+ icon.render() + name+"</a></li>\n";

    }

}
