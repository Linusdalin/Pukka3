package backoffice.pages.tab;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *          A tab panel is a set of page contents that are quickly switched between
 */
public class TabPanel implements TabPanelInterface {

    private List<Tab> tabList = new ArrayList<Tab>();
    private String title = null;

    public TabPanel(){

    }


    protected void addTab(Tab tab){

        tabList.add( tab );
    }

    public TabPanelInterface withTitle(String title){

        this.title = title;
        return this;
    }

    /********************************************************************
     *
     *          Render the tab panel. This includes:
     *
     *           - render the title
     *           - Render the content
     *
     *
     * @param activeTab     - active tab to highlight
     * @param request       The request parameter to be passed on to teh page content
     * @return
     */



    public String render(String activeTab, HttpServletRequest request){

        StringBuffer html = new StringBuffer();
        System.out.println("Active tab = " + activeTab);


        html.append("                    <div class=\"panel panel-default\">\n");

        if(title != null){

            html.append(    "                        <div class=\"panel-heading\">\n" +
                            "                            Basic Tabs\n" +
                            "                        </div>\n");

        }

        html.append(
                "                        <!-- /.panel-heading -->\n" +
                "                        <div class=\"panel-body\">\n" +
                "                            <!-- Nav tabs -->\n" +
                "                            <ul class=\"nav nav-tabs\">\n");

        int tabNo = 0;
        for (Tab tab : tabList) {

            html.append(tab.renderTabTitle(tab.isActive(activeTab)));
            tabNo++;
        }

        html.append("                            </ul>\n\n");

        html.append("                            <!-- Tab panes -->\n" +
                    "                            <div class=\"tab-content\">\n");

        tabNo = 0;
        for (Tab tab : tabList) {

            html.append(tab.renderTab(tab.isActive(activeTab), request));
            tabNo++;
        }


        html.append(
                "                            </div>\n" +
                "                        </div>\n" +
                "                        <!-- /.panel-body -->\n" +
                "                    </div>\n" +
                "                    <!-- /.panel -->\n");


        return html.toString();
    }
}
