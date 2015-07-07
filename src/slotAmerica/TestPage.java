package slotAmerica;

import backoffice.common.Location;
import backoffice.form.FormInterface;
import backoffice.pages.GenericPage;
import backoffice.pages.PageInterface;
import backoffice.style.HtmlBlock;
import backoffice.style.pageComponents.PageHeader;

import javax.servlet.http.HttpServletRequest;

/**
 *
 *          Page to demo the tabs
 */

public class TestPage extends GenericPage implements PageInterface {

    private static final String Name = "FormPage";
    private static final FormInterface form = new TestForm(new Location(Name));

    public TestPage(){

        setName(Name);
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

        html.append(new PageHeader("Form 1").toHtml());
        html.append(form.renderForm());
        html.append(form.getTargetDiv());

        return html;
    }


}
