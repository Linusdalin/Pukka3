package demo;

import backoffice.pages.GenericPage;
import backoffice.pages.PageInterface;
import demo.ExampleTabPanel;
import style.pageComponents.PageHeader;

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


    public String render(HttpServletRequest request){

        StringBuffer html = new StringBuffer();
        html.append(new PageHeader("Example tabs").render());

        html.append(new ExampleTabPanel().render(0, request));

        return html.toString();
    }


}
