package backoffice.services;

import backoffice.errorHandling.BackOfficeException;
import backoffice.errorHandling.PukkaLogger;
import backoffice.form.callbackMessage;
import backoffice.form.FormInterface;
import backoffice.pages.PageInterface;
import backoffice.style.Html;
import backoffice.style.HtmlBlock;
import backoffice.style.pageComponents.BrandTitle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/****************************************************************************
 *
 *              Servlet to serve a generic page in the backOffice.
 *
 *              This is used for all pages with the navigation menu
 *
 *
 *              There are two methods supported:
 *
 *               - Get, will just get the pagte
 *               - Post will execute a callback (depending on the form or list parameter) and then return the page (with a message)
 *
 */

public class pageServlet extends PukkaServlet {

    /*************************************************************************''
     *
     *              Get page
     *
     *
     * @param req           - request
     * @param resp          - response
     * @throws IOException
     */


    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws IOException {

        logRequest(req);

        if(!validateSession(req, resp))
            return;


        String pageName = req.getParameter("page");
        PageInterface page = backOffice.getPageByName(pageName);

        String html = getPage(page, req, null);




        resp.getWriter().print(html.toString());
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        resp.setHeader("Access-Control-Max-Age", "" + (24 * 60 * 60));
        resp.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        resp.setHeader("Access-Control-Allow-Headers", "content-type");

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        resp.flushBuffer();

    }


    public void doPost(HttpServletRequest req, HttpServletResponse resp)throws IOException {

        logRequest(req);

        if(!validateSession(req, resp))
            return;


        String pageName = req.getParameter("page");

        PageInterface page;

        page = backOffice.getPageByName(pageName);

        String action = req.getParameter("action");

        callbackMessage message = null;

        if(action != null){

            if(action.equals("submit")){

                // Handle actions on page here
                System.out.println("Action Not implemented!");
                String formName = req.getParameter("form");
                FormInterface form = backOffice.getFormByName(formName);

                if(form == null){
                    message = new callbackMessage(callbackMessage.CallbackAction.ERROR, "Form " + formName + " does not exist" );
                }
                else
                    message = form.submitCallBack(req);

                // Now test redirect from the submit callback
                if(message.getAction() == callbackMessage.CallbackAction.REDIRECT){

                    resp.sendRedirect(message.getMessage());
                    return;

                }


            }



        }

        String html = getPage(page, req, message);

        resp.getWriter().print(html);
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        resp.setHeader("Access-Control-Max-Age", "" + (24 * 60 * 60));
        resp.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        resp.setHeader("Access-Control-Allow-Headers", "content-type");

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        resp.flushBuffer();

    }


    private String getPage(PageInterface page, HttpServletRequest req, callbackMessage message) {

        String thisURL = req.getRequestURI();
        HtmlBlock html = new HtmlBlock();

        if(message != null)
            System.out.println("Callback Message: " + message.toString());

        html.append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "\n" +
                "<head>\n" +
                "\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "    <meta name=\"description\" content=\"\">\n" +
                "    <meta name=\"author\" content=\"\">\n" +

                Html.title( backOffice.getSystemTitle() ) + "\n\n" +

                "    <!-- Bootstrap Core CSS -->\n" +
                "    <link href=\"adminCommon/bower_components/bootstrap/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n" +
                "\n" +
                "    <!-- MetisMenu CSS -->\n" +
                "    <link href=\"adminCommon/bower_components/metisMenu/dist/metisMenu.min.css\" rel=\"stylesheet\">\n" +
                "\n" +
                "    <!-- Timeline CSS -->\n" +
                "    <link href=\"adminCommon/dist/css/timeline.css\" rel=\"stylesheet\">\n" +
                "\n" +
                "    <!-- DataTables CSS -->\n" +
                "    <link href=\"adminCommon/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css\" rel=\"stylesheet\">\n" +
                "\n" +
                "    <!-- DataTables Responsive CSS -->\n" +
                "    <link href=\"adminCommon/bower_components/datatables-responsive/css/dataTables.responsive.css\" rel=\"stylesheet\">" +
                "\n" +
                "    <!-- Custom CSS -->\n" +
                "    <link href=\"adminCommon/dist/css/sb-admin-2.css\" rel=\"stylesheet\">\n" +
                "\n" +
                "    <!-- Morris Charts CSS -->\n" +
                "    <link href=\"adminCommon/bower_components/morrisjs/morris.css\" rel=\"stylesheet\">\n" +
                "\n" +
                "    <!-- Custom Fonts -->\n" +
                "    <link href=\"adminCommon/bower_components/font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\n" +
                "\n" +
                "    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->\n" +
                "    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\n" +
                "    <!--[if lt IE 9]>\n" +
                "        <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\n" +
                "        <script src=\"https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js\"></script>\n" +
                "    <![endif]-->\n" +
                "\n");

        html.append(

                "\n" +
                "    <!-- jQuery -->\n" +
                "    <script src=\"adminCommon/bower_components/jquery/dist/jquery.min.js\"></script>\n" +
                "\n" +
                "    <!-- Bootstrap Core JavaScript -->\n" +
                "    <script src=\"adminCommon/bower_components/bootstrap/dist/js/bootstrap.min.js\"></script>\n" +
                "    <script src=\"adminCommon/js/bootstrap-datepicker.min.js\"></script>\n" +
                "\n" +
                "    <!-- Metis Menu Plugin JavaScript -->\n" +
                "    <script src=\"adminCommon/bower_components/metisMenu/dist/metisMenu.min.js\"></script>\n" +
                "\n" +
                "    <!-- DataTables JavaScript -->\n" +
                "    <script src=\"adminCommon/bower_components/DataTables/media/js/jquery.dataTables.min.js\"></script>\n" +
                "    <script src=\"adminCommon/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js\"></script>\n" +
                "\n" +
                "    <!-- Morris Charts JavaScript -->\n" +
                "    <script src=\"adminCommon/bower_components/raphael/raphael-min.js\"></script>\n" +
                "    <script src=\"adminCommon/bower_components/morrisjs/morris.min.js\"></script>\n" +

                "    <!-- Custom Theme JavaScript -->\n" +
                "    <script src=\"adminCommon/dist/js/sb-admin-2.js\"></script>\n");

        html.append(
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "\n" +
                "    <div id=\"wrapper\">\n" +
                "\n" +
                "        <!-- Navigation -->\n" +
                "        <nav class=\"navbar navbar-default navbar-static-top\" role=\"navigation\" style=\"margin-bottom: 0\">\n" +
                "            <div class=\"navbar-header\">\n" +
                "                <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\n" +
                "                    <span class=\"sr-only\">Toggle navigation</span>\n" +
                "                    <span class=\"icon-bar\"></span>\n" +
                "                    <span class=\"icon-bar\"></span>\n" +
                "                    <span class=\"icon-bar\"></span>\n" +
                "                </button>\n" +
                new BrandTitle(backOffice).render() +
                "            </div>\n" +
                "            <!-- /.navbar-header -->\n" +
                "\n" +
                backOffice.getNavbar().render(backOffice, thisURL) +
                "\n" +

                backOffice.getMenu().render() +

                "\n" +
                "            <!-- /.navbar-static-side -->\n" +
                "        </nav>\n"+
                "        <div id=\"page-wrapper\">\n");

        try{
            html.append( getMessageBox(message));
            html.append( page.toHtml(req));

        }catch(BackOfficeException e){

            PukkaLogger.log( e );
            html.append("Error rendering page");
        }


         html.append(
                "\n" +
                "        </div>\n" +
                "        <!-- /#page-wrapper -->\n" +
                "    </div>\n" +
                "    <!-- /#wrapper -->\n");

        /*
        html.append(

                "\n" +
                "    <!-- jQuery -->\n" +
                "    <script src=\"adminCommon/bower_components/jquery/dist/jquery.min.js\"></script>\n" +
                "\n" +
                "    <!-- Bootstrap Core JavaScript -->\n" +
                "    <script src=\"adminCommon/bower_components/bootstrap/dist/js/bootstrap.min.js\"></script>\n" +
                "\n" +
                "    <!-- Metis Menu Plugin JavaScript -->\n" +
                "    <script src=\"adminCommon/bower_components/metisMenu/dist/metisMenu.min.js\"></script>\n" +
                "\n" +
                "    <!-- DataTables JavaScript -->\n" +
                "    <script src=\"adminCommon/bower_components/DataTables/media/js/jquery.dataTables.min.js\"></script>\n" +
                "    <script src=\"adminCommon/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js\"></script>\n" +
                "\n" +
                "    <!-- Morris Charts JavaScript -->\n" +
                "    <script src=\"adminCommon/bower_components/raphael/raphael-min.js\"></script>\n" +
                "    <script src=\"adminCommon/bower_components/morrisjs/morris.min.js\"></script>\n" +

                page.renderDataScripts() +
                "\n" +
                "    <!-- Custom Theme JavaScript -->\n" +
                "    <script src=\"adminCommon/dist/js/sb-admin-2.js\"></script>\n" +
                "\n" +
                "</body>\n" +
                "\n" +
                "</html>\n");

            */
        return html.toString();
    }

    /********************************************************************************
     *
     *          If there is a message we should render it
     *
     * @param message
     * @return
     */

    private HtmlBlock getMessageBox(callbackMessage message) {

        if(message == null)
            return new HtmlBlock("");

        if(message.getAction() == callbackMessage.CallbackAction.NO_ACTION)
            return new HtmlBlock("");

        return message.toAlertBox().render();

    }


}
