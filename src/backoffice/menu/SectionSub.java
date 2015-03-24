package backoffice.menu;

import backoffice.pages.PageInterface;

/*****************************************************************************
 *
 *          A leaf sub section
 */

public class SectionSub extends GenericSection implements SectionInterface{

    String name;
    PageInterface page = null;

    /*******************************************************'
     *
     *          Create a new Section
     *
     * @param name      - Name to be displayed in the menu
     * @param page      - The page to link to
     */


    public SectionSub(String name, PageInterface page){

        this.name = name;
        this.page = page;

    }

    public String render(int level){

        if(level < 2)
            System.out.println("Subsection used on level " + level);

        return  "                             <li>" +
                "                               <a href=\"/page?page="+page.getName()+"\"> "+name+"</a>\n" +
                "                             </li>\n";

    }

}
