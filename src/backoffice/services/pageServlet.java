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

/**
 *
 *              Servlet to serve a generic page
 *
 */

public class pageServlet extends HttpServlet {

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
                "            <ul class=\"nav navbar-top-links navbar-right\">\n" +
                "                <li class=\"dropdown\">\n" +
                "                    <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">\n" +
                "                        <i class=\"fa fa-envelope fa-fw\"></i>  <i class=\"fa fa-caret-down\"></i>\n" +
                "                    </a>\n" +
                "                    <ul class=\"dropdown-menu dropdown-messages\">\n" +
                "                        <li>\n" +
                "                            <a href=\"#\">\n" +
                "                                <div>\n" +
                "                                    <strong>John Smith</strong>\n" +
                "                                    <span class=\"pull-right text-muted\">\n" +
                "                                        <em>Yesterday</em>\n" +
                "                                    </span>\n" +
                "                                </div>\n" +
                "                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>\n" +
                "                            </a>\n" +
                "                        </li>\n" +
                "                        <li class=\"divider\"></li>\n" +
                "                        <li>\n" +
                "                            <a href=\"#\">\n" +
                "                                <div>\n" +
                "                                    <strong>John Smith</strong>\n" +
                "                                    <span class=\"pull-right text-muted\">\n" +
                "                                        <em>Yesterday</em>\n" +
                "                                    </span>\n" +
                "                                </div>\n" +
                "                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>\n" +
                "                            </a>\n" +
                "                        </li>\n" +
                "                        <li class=\"divider\"></li>\n" +
                "                        <li>\n" +
                "                            <a href=\"#\">\n" +
                "                                <div>\n" +
                "                                    <strong>John Smith</strong>\n" +
                "                                    <span class=\"pull-right text-muted\">\n" +
                "                                        <em>Yesterday</em>\n" +
                "                                    </span>\n" +
                "                                </div>\n" +
                "                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>\n" +
                "                            </a>\n" +
                "                        </li>\n" +
                "                        <li class=\"divider\"></li>\n" +
                "                        <li>\n" +
                "                            <a class=\"text-center\" href=\"#\">\n" +
                "                                <strong>Read All Messages</strong>\n" +
                "                                <i class=\"fa fa-angle-right\"></i>\n" +
                "                            </a>\n" +
                "                        </li>\n" +
                "                    </ul>\n" +
                "                    <!-- /.dropdown-messages -->\n" +
                "                </li>\n" +
                "                <!-- /.dropdown -->\n" +
                "                <li class=\"dropdown\">\n" +
                "                    <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">\n" +
                "                        <i class=\"fa fa-tasks fa-fw\"></i>  <i class=\"fa fa-caret-down\"></i>\n" +
                "                    </a>\n" +
                "                    <ul class=\"dropdown-menu dropdown-tasks\">\n" +
                "                        <li>\n" +
                "                            <a href=\"#\">\n" +
                "                                <div>\n" +
                "                                    <p>\n" +
                "                                        <strong>Task 1</strong>\n" +
                "                                        <span class=\"pull-right text-muted\">40% Complete</span>\n" +
                "                                    </p>\n" +
                "                                    <div class=\"progress progress-striped active\">\n" +
                "                                        <div class=\"progress-bar progress-bar-success\" role=\"progressbar\" aria-valuenow=\"40\" aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width: 40%\">\n" +
                "                                            <span class=\"sr-only\">40% Complete (success)</span>\n" +
                "                                        </div>\n" +
                "                                    </div>\n" +
                "                                </div>\n" +
                "                            </a>\n" +
                "                        </li>\n" +
                "                        <li class=\"divider\"></li>\n" +
                "                        <li>\n" +
                "                            <a href=\"#\">\n" +
                "                                <div>\n" +
                "                                    <p>\n" +
                "                                        <strong>Task 2</strong>\n" +
                "                                        <span class=\"pull-right text-muted\">20% Complete</span>\n" +
                "                                    </p>\n" +
                "                                    <div class=\"progress progress-striped active\">\n" +
                "                                        <div class=\"progress-bar progress-bar-info\" role=\"progressbar\" aria-valuenow=\"20\" aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width: 20%\">\n" +
                "                                            <span class=\"sr-only\">20% Complete</span>\n" +
                "                                        </div>\n" +
                "                                    </div>\n" +
                "                                </div>\n" +
                "                            </a>\n" +
                "                        </li>\n" +
                "                        <li class=\"divider\"></li>\n" +
                "                        <li>\n" +
                "                            <a href=\"#\">\n" +
                "                                <div>\n" +
                "                                    <p>\n" +
                "                                        <strong>Task 3</strong>\n" +
                "                                        <span class=\"pull-right text-muted\">60% Complete</span>\n" +
                "                                    </p>\n" +
                "                                    <div class=\"progress progress-striped active\">\n" +
                "                                        <div class=\"progress-bar progress-bar-warning\" role=\"progressbar\" aria-valuenow=\"60\" aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width: 60%\">\n" +
                "                                            <span class=\"sr-only\">60% Complete (warning)</span>\n" +
                "                                        </div>\n" +
                "                                    </div>\n" +
                "                                </div>\n" +
                "                            </a>\n" +
                "                        </li>\n" +
                "                        <li class=\"divider\"></li>\n" +
                "                        <li>\n" +
                "                            <a href=\"#\">\n" +
                "                                <div>\n" +
                "                                    <p>\n" +
                "                                        <strong>Task 4</strong>\n" +
                "                                        <span class=\"pull-right text-muted\">80% Complete</span>\n" +
                "                                    </p>\n" +
                "                                    <div class=\"progress progress-striped active\">\n" +
                "                                        <div class=\"progress-bar progress-bar-danger\" role=\"progressbar\" aria-valuenow=\"80\" aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width: 80%\">\n" +
                "                                            <span class=\"sr-only\">80% Complete (danger)</span>\n" +
                "                                        </div>\n" +
                "                                    </div>\n" +
                "                                </div>\n" +
                "                            </a>\n" +
                "                        </li>\n" +
                "                        <li class=\"divider\"></li>\n" +
                "                        <li>\n" +
                "                            <a class=\"text-center\" href=\"#\">\n" +
                "                                <strong>See All Tasks</strong>\n" +
                "                                <i class=\"fa fa-angle-right\"></i>\n" +
                "                            </a>\n" +
                "                        </li>\n" +
                "                    </ul>\n" +
                "                    <!-- /.dropdown-tasks -->\n" +
                "                </li>\n" +
                "                <!-- /.dropdown -->\n" +
                "                <li class=\"dropdown\">\n" +
                "                    <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">\n" +
                "                        <i class=\"fa fa-bell fa-fw\"></i>  <i class=\"fa fa-caret-down\"></i>\n" +
                "                    </a>\n" +
                "                    <ul class=\"dropdown-menu dropdown-alerts\">\n" +
                "                        <li>\n" +
                "                            <a href=\"#\">\n" +
                "                                <div>\n" +
                "                                    <i class=\"fa fa-comment fa-fw\"></i> New Comment\n" +
                "                                    <span class=\"pull-right text-muted small\">4 minutes ago</span>\n" +
                "                                </div>\n" +
                "                            </a>\n" +
                "                        </li>\n" +
                "                        <li class=\"divider\"></li>\n" +
                "                        <li>\n" +
                "                            <a href=\"#\">\n" +
                "                                <div>\n" +
                "                                    <i class=\"fa fa-twitter fa-fw\"></i> 3 New Followers\n" +
                "                                    <span class=\"pull-right text-muted small\">12 minutes ago</span>\n" +
                "                                </div>\n" +
                "                            </a>\n" +
                "                        </li>\n" +
                "                        <li class=\"divider\"></li>\n" +
                "                        <li>\n" +
                "                            <a href=\"#\">\n" +
                "                                <div>\n" +
                "                                    <i class=\"fa fa-envelope fa-fw\"></i> Message Sent\n" +
                "                                    <span class=\"pull-right text-muted small\">4 minutes ago</span>\n" +
                "                                </div>\n" +
                "                            </a>\n" +
                "                        </li>\n" +
                "                        <li class=\"divider\"></li>\n" +
                "                        <li>\n" +
                "                            <a href=\"#\">\n" +
                "                                <div>\n" +
                "                                    <i class=\"fa fa-tasks fa-fw\"></i> New Task\n" +
                "                                    <span class=\"pull-right text-muted small\">4 minutes ago</span>\n" +
                "                                </div>\n" +
                "                            </a>\n" +
                "                        </li>\n" +
                "                        <li class=\"divider\"></li>\n" +
                "                        <li>\n" +
                "                            <a href=\"#\">\n" +
                "                                <div>\n" +
                "                                    <i class=\"fa fa-upload fa-fw\"></i> Server Rebooted\n" +
                "                                    <span class=\"pull-right text-muted small\">4 minutes ago</span>\n" +
                "                                </div>\n" +
                "                            </a>\n" +
                "                        </li>\n" +
                "                        <li class=\"divider\"></li>\n" +
                "                        <li>\n" +
                "                            <a class=\"text-center\" href=\"#\">\n" +
                "                                <strong>See All Alerts</strong>\n" +
                "                                <i class=\"fa fa-angle-right\"></i>\n" +
                "                            </a>\n" +
                "                        </li>\n" +
                "                    </ul>\n" +
                "                    <!-- /.dropdown-alerts -->\n" +
                "                </li>\n" +
                "                <!-- /.dropdown -->\n" +
                "                <li class=\"dropdown\">\n" +
                "                    <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">\n" +
                "                        <i class=\"fa fa-user fa-fw\"></i>  <i class=\"fa fa-caret-down\"></i>\n" +
                "                    </a>\n" +
                "                    <ul class=\"dropdown-menu dropdown-user\">\n" +
                "                        <li><a href=\"#\"><i class=\"fa fa-user fa-fw\"></i> User Profile</a>\n" +
                "                        </li>\n" +
                "                        <li><a href=\"#\"><i class=\"fa fa-gear fa-fw\"></i> Settings</a>\n" +
                "                        </li>\n" +
                "                        <li class=\"divider\"></li>\n" +
                "                        <li><a href=\"login.html\"><i class=\"fa fa-sign-out fa-fw\"></i> Logout</a>\n" +
                "                        </li>\n" +
                "                    </ul>\n" +
                "                    <!-- /.dropdown-user -->\n" +
                "                </li>\n" +
                "                <!-- /.dropdown -->\n" +
                "            </ul>\n" +
                "            <!-- /.navbar-top-links -->\n" +
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
        resp.flushBuffer();

    }
}
