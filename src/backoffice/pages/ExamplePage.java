package backoffice.pages;

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

        html.append(
                "                            <button class=\"btn btn-primary btn-lg\" data-toggle=\"modal\" id=\"modal1\" data-target=\"#pukkaModal\" href=\"modalTest.html\">\n" +
                "                                Launch Demo Modal\n" +
                "                            </button>\n" +
                "                            <!-- Modal -->\n" +
                "                            <div class=\"modal fade\" id=\"pukkaModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\" >\n" +

                "                            </div>\n" +
                "                            <!-- /.modal -->\n");


        html.append("<p><a href=\"modalTest.html\" data-toggle=\"modal\" data-target=\"#pukkaModal\">Modal link</a></p>");

        html.append("<p><a href=\"/Lightbox?page=exampleLightbox\" data-toggle=\"modal\" data-target=\"#pukkaModal\">Lightbox Servlet Test</a></p>");


        return html.toString();

    }

    @Override
    public String renderDataScripts(){

        return  "            <script src=\"adminCommon/pukka.js\"></script>\n";

    }


}
