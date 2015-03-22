package backoffice.services;

import backoffice.BackofficeFactory;
import backoffice.BackofficeInterface;
import backoffice.pages.PageInterface;
import style.Html;
import style.pageComponents.BrandTitle;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/****************************************************************************
 *
 *              Servlet to serve a generic page in the backOffice.
 *
 *              This is used for all pages with the navigation menu
 *
 */

public class pageServlet extends HttpServlet {

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

        BackofficeInterface backoffice = BackofficeFactory.getBackoffice();

        String pageName = req.getParameter("page");

        PageInterface page = backoffice.getPageByName(pageName);

        StringBuffer html = new StringBuffer();



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

                Html.title( backoffice.getSystemTitle() ) +

                "    <!-- Bootstrap Core CSS -->\n" +
                "    <link href=\"adminCommon/bower_components/bootstrap/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n" +
                "\n" +
                "    <!-- MetisMenu CSS -->\n" +
                "    <link href=\"adminCommon/bower_components/metisMenu/dist/metisMenu.min.css\" rel=\"stylesheet\">\n" +
                "\n" +
                "    <!-- Timeline CSS -->\n" +
                "    <link href=\"adminCommon/dist/css/timeline.css\" rel=\"stylesheet\">\n" +
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
                "\n" +
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
                new BrandTitle(backoffice).render() +
                "            </div>\n" +
                "            <!-- /.navbar-header -->\n" +
                "\n" +
                backoffice.getNavbar().render() +
                "\n" +

                backoffice.getMenu().render() +

                "\n" +
                "            <!-- /.navbar-static-side -->\n" +
                "        </nav>\n"+
                "        <div id=\"page-wrapper\">\n" +


                page.render(req) +



                "\n" +
                "        </div>\n" +
                "        <!-- /#page-wrapper -->\n" +
                "    </div>\n" +
                "    <!-- /#wrapper -->\n" +
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
}
