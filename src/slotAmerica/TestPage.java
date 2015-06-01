package slotAmerica;

import backoffice.common.Location;
import backoffice.form.FormInterface;
import backoffice.pages.GenericPage;
import backoffice.pages.PageInterface;
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


    public String render(HttpServletRequest request){

        StringBuffer html = new StringBuffer();

               html.append(new PageHeader("Form 1").render());

               html.append(form.renderForm());

               html.append(form.getTargetDiv());

               return html.toString();
    }


    /*
    @Override
    public String renderDataScripts(){

        return  new TestForm(new Location("TestPage")).getSubmitScript();

    }
      */

}
