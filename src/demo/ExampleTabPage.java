package demo;

import backoffice.pages.GenericPage;
import backoffice.pages.PageInterface;
import backoffice.style.HtmlBlock;
import backoffice.style.pageComponents.PageHeader;

import javax.servlet.http.HttpServletRequest;

/**
 *
 *          Page to demo the tabs
 */

public class ExampleTabPage extends GenericPage implements PageInterface {

    public ExampleTabPage(){

        setName("TabTest");
        setTitle("Test of tabs");

    }

    /*************************************************''
     *
     *          The page contains a heading and a tab pane
     *
     * @param request
     * @return
     */


    public HtmlBlock toHtml(HttpServletRequest request){

        HtmlBlock html = new HtmlBlock();

        String activeTab = request.getParameter("tab");

        html.append(new PageHeader("Example tabs").toHtml());

        html.append(new ExampleTabPanel().render(activeTab, request));

        return html;
    }


}
