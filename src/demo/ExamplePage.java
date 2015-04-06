package demo;

import backoffice.common.Location;
import backoffice.form.FormInterface;
import backoffice.pages.GenericPage;
import backoffice.pages.PageInterface;
import style.pageComponents.PageHeader;

import javax.servlet.http.HttpServletRequest;

/**
 *
 *          404 page
 */

public class ExamplePage extends GenericPage implements PageInterface {

    public ExamplePage(){

        setName("Example");
        setTitle("Examples");

    }


    /*********************************************************************
     *
     *      Some example components
     *
     * @param request
     * @return
     */

    public String render(HttpServletRequest request){

        StringBuffer html = new StringBuffer();

        html.append(new PageHeader("Example Page").render());

        FormInterface exampleForm = new ExampleForm(location);
        exampleForm.populateValues(request);
        html.append(exampleForm.renderForm());

        return html.toString();

    }

    @Override
    public String renderDataScripts(){

        return  "            <script src=\"adminCommon/pukka.js\"></script>\n";

    }


}
