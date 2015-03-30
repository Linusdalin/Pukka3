package backoffice.pages;

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

    public Tab(String name, String title, PageInterface page){

        this.name = name;
        this.title = title;
        this.page = page;
    }

    public String renderTabTitle(boolean isActive) {
        return "                                <li "+(isActive ? "class=\"active\"": "" ) + "><a href=\"#"+name+"\" data-toggle=\"tab\">"+title+"</a>\n";

    }

    public String renderTab(boolean isActive, HttpServletRequest request){

        return          "                                <div class=\"tab-pane "+(isActive ? "in active " : "" ) + "fade\" id=\""+name+"\">\n" +

                            page.render(request) +
                            page.renderDataScripts() +
                        "                                </div>\n";

    }

}
