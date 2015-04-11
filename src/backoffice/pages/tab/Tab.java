package backoffice.pages.tab;

import backoffice.errorHandling.BackOfficeException;
import backoffice.errorHandling.PukkaLogger;
import backoffice.pages.PageInterface;

import javax.servlet.http.HttpServletRequest;

/***************************************************
 *
 *              A tab is a special type of page
 *
 */


public class Tab {

    private String name;
    private String title;
    private PageInterface page;
    private boolean isDefaultTab;

    public Tab(String name, String title, PageInterface page){

        this.name = name;
        this.title = title;
        this.page = page;
    }

    public Tab setDefault(){

        this.isDefaultTab = true;
        return this;
    }


    public String renderTabTitle(boolean isActive) {
        return "                                <li "+(isActive ? "class=\"active\"": "" ) + "><a href=\"#"+name+"\" data-toggle=\"tab\">"+title+"</a>\n";

    }

    public String renderTab(boolean isActive, HttpServletRequest request){

        try {
            return          "                                <div class=\"tab-pane "+(isActive ? "in active " : "" ) + "fade\" id=\""+name+"\">\n" +

                                page.render(request) +
                                page.renderDataScripts() +
                            "                                </div>\n";
        } catch (BackOfficeException e) {
            PukkaLogger.log( e );
            return "Could not render tab";
        }

    }

    /**************************************************
     *
     *          Is this the active tab?
     *
     * @param activeTab     - name from request
     * @return
     */

    public boolean isActive(String activeTab) {

        if(activeTab == null)
            return this.isDefaultTab;

        return name.equals(activeTab);
    }
}
