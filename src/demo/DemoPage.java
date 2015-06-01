package demo;

import backoffice.pages.GenericPage;
import backoffice.pages.PageInterface;
import backoffice.style.pageComponents.PageHeader;

import javax.servlet.http.HttpServletRequest;

/***********************************************************************************
 *
 *          Example page from the Bootstrap SB 2 demo
 */

public class DemoPage extends GenericPage implements PageInterface {


    public DemoPage(){

        setName("Demo");
        setTitle("Dashboard Page");

    }


    /******************************************************************''
     *
     *          main content of the page
     *
     *
     * @return    - the demo content
     */

    public String render(HttpServletRequest request){

        return

                new PageHeader(getTitle()).render() +

                "            <!-- /.row -->\n" +
                "            <div class=\"row\">\n" +
                "                <div class=\"col-lg-3 col-md-6\">\n" +
                "                    <div class=\"panel panel-primary\">\n" +
                "                        <div class=\"panel-heading\">\n" +
                "                            <div class=\"row\">\n" +
                "                                <div class=\"col-xs-3\">\n" +
                "                                    <i class=\"fa fa-comments fa-5x\"></i>\n" +
                "                                </div>\n" +
                "                                <div class=\"col-xs-9 text-right\">\n" +
                "                                    <div class=\"huge\">26</div>\n" +
                "                                    <div>New Comments!</div>\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                        <a href=\"#\">\n" +
                "                            <div class=\"panel-footer\">\n" +
                "                                <span class=\"pull-left\">View Details</span>\n" +
                "                                <span class=\"pull-right\"><i class=\"fa fa-arrow-circle-right\"></i></span>\n" +
                "                                <div class=\"clearfix\"></div>\n" +
                "                            </div>\n" +
                "                        </a>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <div class=\"col-lg-3 col-md-6\">\n" +
                "                    <div class=\"panel panel-green\">\n" +
                "                        <div class=\"panel-heading\">\n" +
                "                            <div class=\"row\">\n" +
                "                                <div class=\"col-xs-3\">\n" +
                "                                    <i class=\"fa fa-tasks fa-5x\"></i>\n" +
                "                                </div>\n" +
                "                                <div class=\"col-xs-9 text-right\">\n" +
                "                                    <div class=\"huge\">12</div>\n" +
                "                                    <div>New Tasks!</div>\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                        <a href=\"#\">\n" +
                "                            <div class=\"panel-footer\">\n" +
                "                                <span class=\"pull-left\">View Details</span>\n" +
                "                                <span class=\"pull-right\"><i class=\"fa fa-arrow-circle-right\"></i></span>\n" +
                "                                <div class=\"clearfix\"></div>\n" +
                "                            </div>\n" +
                "                        </a>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <div class=\"col-lg-3 col-md-6\">\n" +
                "                    <div class=\"panel panel-yellow\">\n" +
                "                        <div class=\"panel-heading\">\n" +
                "                            <div class=\"row\">\n" +
                "                                <div class=\"col-xs-3\">\n" +
                "                                    <i class=\"fa fa-shopping-cart fa-5x\"></i>\n" +
                "                                </div>\n" +
                "                                <div class=\"col-xs-9 text-right\">\n" +
                "                                    <div class=\"huge\">124</div>\n" +
                "                                    <div>New Orders!</div>\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                        <a href=\"#\">\n" +
                "                            <div class=\"panel-footer\">\n" +
                "                                <span class=\"pull-left\">View Details</span>\n" +
                "                                <span class=\"pull-right\"><i class=\"fa fa-arrow-circle-right\"></i></span>\n" +
                "                                <div class=\"clearfix\"></div>\n" +
                "                            </div>\n" +
                "                        </a>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <div class=\"col-lg-3 col-md-6\">\n" +
                "                    <div class=\"panel panel-red\">\n" +
                "                        <div class=\"panel-heading\">\n" +
                "                            <div class=\"row\">\n" +
                "                                <div class=\"col-xs-3\">\n" +
                "                                    <i class=\"fa fa-support fa-5x\"></i>\n" +
                "                                </div>\n" +
                "                                <div class=\"col-xs-9 text-right\">\n" +
                "                                    <div class=\"huge\">13</div>\n" +
                "                                    <div>Support Tickets!</div>\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                        <a href=\"#\">\n" +
                "                            <div class=\"panel-footer\">\n" +
                "                                <span class=\"pull-left\">View Details</span>\n" +
                "                                <span class=\"pull-right\"><i class=\"fa fa-arrow-circle-right\"></i></span>\n" +
                "                                <div class=\"clearfix\"></div>\n" +
                "                            </div>\n" +
                "                        </a>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <!-- /.row -->\n" +
                "            <div class=\"row\">\n" +
                "                <div class=\"col-lg-8\">\n" +
                "                    <div class=\"panel panel-default\">\n" +
                "                        <div class=\"panel-heading\">\n" +
                "                            <i class=\"fa fa-bar-chart-o fa-fw\"></i> Area Chart Example\n" +
                "                            <div class=\"pull-right\">\n" +
                "                                <div class=\"btn-group\">\n" +
                "                                    <button type=\"button\" class=\"btn btn-default btn-xs dropdown-toggle\" data-toggle=\"dropdown\">\n" +
                "                                        Actions\n" +
                "                                        <span class=\"caret\"></span>\n" +
                "                                    </button>\n" +
                "                                    <ul class=\"dropdown-menu pull-right\" role=\"menu\">\n" +
                "                                        <li><a href=\"#\">Action</a>\n" +
                "                                        </li>\n" +
                "                                        <li><a href=\"#\">Another action</a>\n" +
                "                                        </li>\n" +
                "                                        <li><a href=\"#\">Something else here</a>\n" +
                "                                        </li>\n" +
                "                                        <li class=\"divider\"></li>\n" +
                "                                        <li><a href=\"#\">Separated link</a>\n" +
                "                                        </li>\n" +
                "                                    </ul>\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                        <!-- /.panel-heading -->\n" +
                "                        <div class=\"panel-body\">\n" +
                "                            <div id=\"morris-area-chart\"></div>\n" +
                "                        </div>\n" +
                "                        <!-- /.panel-body -->\n" +
                "                    </div>\n" +
                "                    <!-- /.panel -->\n" +
                "                    <div class=\"panel panel-default\">\n" +
                "                        <div class=\"panel-heading\">\n" +
                "                            <i class=\"fa fa-bar-chart-o fa-fw\"></i> Bar Chart Example\n" +
                "                            <div class=\"pull-right\">\n" +
                "                                <div class=\"btn-group\">\n" +
                "                                    <button type=\"button\" class=\"btn btn-default btn-xs dropdown-toggle\" data-toggle=\"dropdown\">\n" +
                "                                        Actions\n" +
                "                                        <span class=\"caret\"></span>\n" +
                "                                    </button>\n" +
                "                                    <ul class=\"dropdown-menu pull-right\" role=\"menu\">\n" +
                "                                        <li><a href=\"#\">Action</a>\n" +
                "                                        </li>\n" +
                "                                        <li><a href=\"#\">Another action</a>\n" +
                "                                        </li>\n" +
                "                                        <li><a href=\"#\">Something else here</a>\n" +
                "                                        </li>\n" +
                "                                        <li class=\"divider\"></li>\n" +
                "                                        <li><a href=\"#\">Separated link</a>\n" +
                "                                        </li>\n" +
                "                                    </ul>\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                        <!-- /.panel-heading -->\n" +
                "                        <div class=\"panel-body\">\n" +
                "                            <div class=\"row\">\n" +
                "                                <div class=\"col-lg-4\">\n" +
                "                                    <div class=\"table-responsive\">\n" +
                "                                        <table class=\"table table-bordered table-hover table-striped\">\n" +
                "                                            <thead>\n" +
                "                                                <tr>\n" +
                "                                                    <th>#</th>\n" +
                "                                                    <th>Date</th>\n" +
                "                                                    <th>Time</th>\n" +
                "                                                    <th>Amount</th>\n" +
                "                                                </tr>\n" +
                "                                            </thead>\n" +
                "                                            <tbody>\n" +
                "                                                <tr>\n" +
                "                                                    <td>3326</td>\n" +
                "                                                    <td>10/21/2013</td>\n" +
                "                                                    <td>3:29 PM</td>\n" +
                "                                                    <td>$321.33</td>\n" +
                "                                                </tr>\n" +
                "                                                <tr>\n" +
                "                                                    <td>3325</td>\n" +
                "                                                    <td>10/21/2013</td>\n" +
                "                                                    <td>3:20 PM</td>\n" +
                "                                                    <td>$234.34</td>\n" +
                "                                                </tr>\n" +
                "                                                <tr>\n" +
                "                                                    <td>3324</td>\n" +
                "                                                    <td>10/21/2013</td>\n" +
                "                                                    <td>3:03 PM</td>\n" +
                "                                                    <td>$724.17</td>\n" +
                "                                                </tr>\n" +
                "                                                <tr>\n" +
                "                                                    <td>3323</td>\n" +
                "                                                    <td>10/21/2013</td>\n" +
                "                                                    <td>3:00 PM</td>\n" +
                "                                                    <td>$23.71</td>\n" +
                "                                                </tr>\n" +
                "                                                <tr>\n" +
                "                                                    <td>3322</td>\n" +
                "                                                    <td>10/21/2013</td>\n" +
                "                                                    <td>2:49 PM</td>\n" +
                "                                                    <td>$8345.23</td>\n" +
                "                                                </tr>\n" +
                "                                                <tr>\n" +
                "                                                    <td>3321</td>\n" +
                "                                                    <td>10/21/2013</td>\n" +
                "                                                    <td>2:23 PM</td>\n" +
                "                                                    <td>$245.12</td>\n" +
                "                                                </tr>\n" +
                "                                                <tr>\n" +
                "                                                    <td>3320</td>\n" +
                "                                                    <td>10/21/2013</td>\n" +
                "                                                    <td>2:15 PM</td>\n" +
                "                                                    <td>$5663.54</td>\n" +
                "                                                </tr>\n" +
                "                                                <tr>\n" +
                "                                                    <td>3319</td>\n" +
                "                                                    <td>10/21/2013</td>\n" +
                "                                                    <td>2:13 PM</td>\n" +
                "                                                    <td>$943.45</td>\n" +
                "                                                </tr>\n" +
                "                                            </tbody>\n" +
                "                                        </table>\n" +
                "                                    </div>\n" +
                "                                    <!-- /.table-responsive -->\n" +
                "                                </div>\n" +
                "                                <!-- /.col-lg-4 (nested) -->\n" +
                "                                <div class=\"col-lg-8\">\n" +
                "                                    <div id=\"morris-bar-chart\"></div>\n" +
                "                                </div>\n" +
                "                                <!-- /.col-lg-8 (nested) -->\n" +
                "                            </div>\n" +
                "                            <!-- /.row -->\n" +
                "                        </div>\n" +
                "                        <!-- /.panel-body -->\n" +
                "                    </div>\n" +
                "                    <!-- /.panel -->\n" +
                "                    <div class=\"panel panel-default\">\n" +
                "                        <div class=\"panel-heading\">\n" +
                "                            <i class=\"fa fa-clock-o fa-fw\"></i> Responsive Timeline\n" +
                "                        </div>\n" +
                "                        <!-- /.panel-heading -->\n" +
                "                        <div class=\"panel-body\">\n" +
                "                            <ul class=\"timeline\">\n" +
                "                                <li>\n" +
                "                                    <div class=\"timeline-badge\"><i class=\"fa fa-check\"></i>\n" +
                "                                    </div>\n" +
                "                                    <div class=\"timeline-panel\">\n" +
                "                                        <div class=\"timeline-heading\">\n" +
                "                                            <h4 class=\"timeline-title\">Lorem ipsum dolor</h4>\n" +
                "                                            <p><small class=\"text-muted\"><i class=\"fa fa-clock-o\"></i> 11 hours ago via Twitter</small>\n" +
                "                                            </p>\n" +
                "                                        </div>\n" +
                "                                        <div class=\"timeline-body\">\n" +
                "                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Libero laboriosam dolor perspiciatis omnis exercitationem. Beatae, officia pariatur? Est cum veniam excepturi. Maiores praesentium, porro voluptas suscipit facere rem dicta, debitis.</p>\n" +
                "                                        </div>\n" +
                "                                    </div>\n" +
                "                                </li>\n" +
                "                                <li class=\"timeline-inverted\">\n" +
                "                                    <div class=\"timeline-badge warning\"><i class=\"fa fa-credit-card\"></i>\n" +
                "                                    </div>\n" +
                "                                    <div class=\"timeline-panel\">\n" +
                "                                        <div class=\"timeline-heading\">\n" +
                "                                            <h4 class=\"timeline-title\">Lorem ipsum dolor</h4>\n" +
                "                                        </div>\n" +
                "                                        <div class=\"timeline-body\">\n" +
                "                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Autem dolorem quibusdam, tenetur commodi provident cumque magni voluptatem libero, quis rerum. Fugiat esse debitis optio, tempore. Animi officiis alias, officia repellendus.</p>\n" +
                "                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Laudantium maiores odit qui est tempora eos, nostrum provident explicabo dignissimos debitis vel! Adipisci eius voluptates, ad aut recusandae minus eaque facere.</p>\n" +
                "                                        </div>\n" +
                "                                    </div>\n" +
                "                                </li>\n" +
                "                                <li>\n" +
                "                                    <div class=\"timeline-badge danger\"><i class=\"fa fa-bomb\"></i>\n" +
                "                                    </div>\n" +
                "                                    <div class=\"timeline-panel\">\n" +
                "                                        <div class=\"timeline-heading\">\n" +
                "                                            <h4 class=\"timeline-title\">Lorem ipsum dolor</h4>\n" +
                "                                        </div>\n" +
                "                                        <div class=\"timeline-body\">\n" +
                "                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Repellendus numquam facilis enim eaque, tenetur nam id qui vel velit similique nihil iure molestias aliquam, voluptatem totam quaerat, magni commodi quisquam.</p>\n" +
                "                                        </div>\n" +
                "                                    </div>\n" +
                "                                </li>\n" +
                "                                <li class=\"timeline-inverted\">\n" +
                "                                    <div class=\"timeline-panel\">\n" +
                "                                        <div class=\"timeline-heading\">\n" +
                "                                            <h4 class=\"timeline-title\">Lorem ipsum dolor</h4>\n" +
                "                                        </div>\n" +
                "                                        <div class=\"timeline-body\">\n" +
                "                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptates est quaerat asperiores sapiente, eligendi, nihil. Itaque quos, alias sapiente rerum quas odit! Aperiam officiis quidem delectus libero, omnis ut debitis!</p>\n" +
                "                                        </div>\n" +
                "                                    </div>\n" +
                "                                </li>\n" +
                "                                <li>\n" +
                "                                    <div class=\"timeline-badge info\"><i class=\"fa fa-save\"></i>\n" +
                "                                    </div>\n" +
                "                                    <div class=\"timeline-panel\">\n" +
                "                                        <div class=\"timeline-heading\">\n" +
                "                                            <h4 class=\"timeline-title\">Lorem ipsum dolor</h4>\n" +
                "                                        </div>\n" +
                "                                        <div class=\"timeline-body\">\n" +
                "                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nobis minus modi quam ipsum alias at est molestiae excepturi delectus nesciunt, quibusdam debitis amet, beatae consequuntur impedit nulla qui! Laborum, atque.</p>\n" +
                "                                            <hr>\n" +
                "                                            <div class=\"btn-group\">\n" +
                "                                                <button type=\"button\" class=\"btn btn-primary btn-sm dropdown-toggle\" data-toggle=\"dropdown\">\n" +
                "                                                    <i class=\"fa fa-gear\"></i>  <span class=\"caret\"></span>\n" +
                "                                                </button>\n" +
                "                                                <ul class=\"dropdown-menu\" role=\"menu\">\n" +
                "                                                    <li><a href=\"#\">Action</a>\n" +
                "                                                    </li>\n" +
                "                                                    <li><a href=\"#\">Another action</a>\n" +
                "                                                    </li>\n" +
                "                                                    <li><a href=\"#\">Something else here</a>\n" +
                "                                                    </li>\n" +
                "                                                    <li class=\"divider\"></li>\n" +
                "                                                    <li><a href=\"#\">Separated link</a>\n" +
                "                                                    </li>\n" +
                "                                                </ul>\n" +
                "                                            </div>\n" +
                "                                        </div>\n" +
                "                                    </div>\n" +
                "                                </li>\n" +
                "                                <li>\n" +
                "                                    <div class=\"timeline-panel\">\n" +
                "                                        <div class=\"timeline-heading\">\n" +
                "                                            <h4 class=\"timeline-title\">Lorem ipsum dolor</h4>\n" +
                "                                        </div>\n" +
                "                                        <div class=\"timeline-body\">\n" +
                "                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sequi fuga odio quibusdam. Iure expedita, incidunt unde quis nam! Quod, quisquam. Officia quam qui adipisci quas consequuntur nostrum sequi. Consequuntur, commodi.</p>\n" +
                "                                        </div>\n" +
                "                                    </div>\n" +
                "                                </li>\n" +
                "                                <li class=\"timeline-inverted\">\n" +
                "                                    <div class=\"timeline-badge success\"><i class=\"fa fa-graduation-cap\"></i>\n" +
                "                                    </div>\n" +
                "                                    <div class=\"timeline-panel\">\n" +
                "                                        <div class=\"timeline-heading\">\n" +
                "                                            <h4 class=\"timeline-title\">Lorem ipsum dolor</h4>\n" +
                "                                        </div>\n" +
                "                                        <div class=\"timeline-body\">\n" +
                "                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Deserunt obcaecati, quaerat tempore officia voluptas debitis consectetur culpa amet, accusamus dolorum fugiat, animi dicta aperiam, enim incidunt quisquam maxime neque eaque.</p>\n" +
                "                                        </div>\n" +
                "                                    </div>\n" +
                "                                </li>\n" +
                "                            </ul>\n" +
                "                        </div>\n" +
                "                        <!-- /.panel-body -->\n" +
                "                    </div>\n" +
                "                    <!-- /.panel -->\n" +
                "                </div>\n" +
                "                <!-- /.col-lg-8 -->\n" +
                "                <div class=\"col-lg-4\">\n" +
                "                    <div class=\"panel panel-default\">\n" +
                "                        <div class=\"panel-heading\">\n" +
                "                            <i class=\"fa fa-bell fa-fw\"></i> Notifications Panel\n" +
                "                        </div>\n" +
                "                        <!-- /.panel-heading -->\n" +
                "                        <div class=\"panel-body\">\n" +
                "                            <div class=\"list-group\">\n" +
                "                                <a href=\"#\" class=\"list-group-item\">\n" +
                "                                    <i class=\"fa fa-comment fa-fw\"></i> New Comment\n" +
                "                                    <span class=\"pull-right text-muted small\"><em>4 minutes ago</em>\n" +
                "                                    </span>\n" +
                "                                </a>\n" +
                "                                <a href=\"#\" class=\"list-group-item\">\n" +
                "                                    <i class=\"fa fa-twitter fa-fw\"></i> 3 New Followers\n" +
                "                                    <span class=\"pull-right text-muted small\"><em>12 minutes ago</em>\n" +
                "                                    </span>\n" +
                "                                </a>\n" +
                "                                <a href=\"#\" class=\"list-group-item\">\n" +
                "                                    <i class=\"fa fa-envelope fa-fw\"></i> Message Sent\n" +
                "                                    <span class=\"pull-right text-muted small\"><em>27 minutes ago</em>\n" +
                "                                    </span>\n" +
                "                                </a>\n" +
                "                                <a href=\"#\" class=\"list-group-item\">\n" +
                "                                    <i class=\"fa fa-tasks fa-fw\"></i> New Task\n" +
                "                                    <span class=\"pull-right text-muted small\"><em>43 minutes ago</em>\n" +
                "                                    </span>\n" +
                "                                </a>\n" +
                "                                <a href=\"#\" class=\"list-group-item\">\n" +
                "                                    <i class=\"fa fa-upload fa-fw\"></i> Server Rebooted\n" +
                "                                    <span class=\"pull-right text-muted small\"><em>11:32 AM</em>\n" +
                "                                    </span>\n" +
                "                                </a>\n" +
                "                                <a href=\"#\" class=\"list-group-item\">\n" +
                "                                    <i class=\"fa fa-bolt fa-fw\"></i> Server Crashed!\n" +
                "                                    <span class=\"pull-right text-muted small\"><em>11:13 AM</em>\n" +
                "                                    </span>\n" +
                "                                </a>\n" +
                "                                <a href=\"#\" class=\"list-group-item\">\n" +
                "                                    <i class=\"fa fa-warning fa-fw\"></i> Server Not Responding\n" +
                "                                    <span class=\"pull-right text-muted small\"><em>10:57 AM</em>\n" +
                "                                    </span>\n" +
                "                                </a>\n" +
                "                                <a href=\"#\" class=\"list-group-item\">\n" +
                "                                    <i class=\"fa fa-shopping-cart fa-fw\"></i> New Order Placed\n" +
                "                                    <span class=\"pull-right text-muted small\"><em>9:49 AM</em>\n" +
                "                                    </span>\n" +
                "                                </a>\n" +
                "                                <a href=\"#\" class=\"list-group-item\">\n" +
                "                                    <i class=\"fa fa-money fa-fw\"></i> Payment Received\n" +
                "                                    <span class=\"pull-right text-muted small\"><em>Yesterday</em>\n" +
                "                                    </span>\n" +
                "                                </a>\n" +
                "                            </div>\n" +
                "                            <!-- /.list-group -->\n" +
                "                            <a href=\"#\" class=\"btn btn-default btn-block\">View All Alerts</a>\n" +
                "                        </div>\n" +
                "                        <!-- /.panel-body -->\n" +
                "                    </div>\n" +
                "                    <!-- /.panel -->\n" +
                "                    <div class=\"panel panel-default\">\n" +
                "                        <div class=\"panel-heading\">\n" +
                "                            <i class=\"fa fa-bar-chart-o fa-fw\"></i> Donut Chart Example\n" +
                "                        </div>\n" +
                "                        <div class=\"panel-body\">\n" +
                "                            <div id=\"morris-donut-chart\"></div>\n" +
                "                            <a href=\"#\" class=\"btn btn-default btn-block\">View Details</a>\n" +
                "                        </div>\n" +
                "                        <!-- /.panel-body -->\n" +
                "                    </div>\n" +
                "                    <!-- /.panel -->\n" +
                "                    <div class=\"chat-panel panel panel-default\">\n" +
                "                        <div class=\"panel-heading\">\n" +
                "                            <i class=\"fa fa-comments fa-fw\"></i>\n" +
                "                            Chat\n" +
                "                            <div class=\"btn-group pull-right\">\n" +
                "                                <button type=\"button\" class=\"btn btn-default btn-xs dropdown-toggle\" data-toggle=\"dropdown\">\n" +
                "                                    <i class=\"fa fa-chevron-down\"></i>\n" +
                "                                </button>\n" +
                "                                <ul class=\"dropdown-menu slidedown\">\n" +
                "                                    <li>\n" +
                "                                        <a href=\"#\">\n" +
                "                                            <i class=\"fa fa-refresh fa-fw\"></i> Refresh\n" +
                "                                        </a>\n" +
                "                                    </li>\n" +
                "                                    <li>\n" +
                "                                        <a href=\"#\">\n" +
                "                                            <i class=\"fa fa-check-circle fa-fw\"></i> Available\n" +
                "                                        </a>\n" +
                "                                    </li>\n" +
                "                                    <li>\n" +
                "                                        <a href=\"#\">\n" +
                "                                            <i class=\"fa fa-times fa-fw\"></i> Busy\n" +
                "                                        </a>\n" +
                "                                    </li>\n" +
                "                                    <li>\n" +
                "                                        <a href=\"#\">\n" +
                "                                            <i class=\"fa fa-clock-o fa-fw\"></i> Away\n" +
                "                                        </a>\n" +
                "                                    </li>\n" +
                "                                    <li class=\"divider\"></li>\n" +
                "                                    <li>\n" +
                "                                        <a href=\"#\">\n" +
                "                                            <i class=\"fa fa-sign-out fa-fw\"></i> Sign Out\n" +
                "                                        </a>\n" +
                "                                    </li>\n" +
                "                                </ul>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                        <!-- /.panel-heading -->\n" +
                "                        <div class=\"panel-body\">\n" +
                "                            <ul class=\"chat\">\n" +
                "                                <li class=\"left clearfix\">\n" +
                "                                    <span class=\"chat-img pull-left\">\n" +
                "                                        <img src=\"http://placehold.it/50/55C1E7/fff\" alt=\"User Avatar\" class=\"img-circle\" />\n" +
                "                                    </span>\n" +
                "                                    <div class=\"chat-body clearfix\">\n" +
                "                                        <div class=\"header\">\n" +
                "                                            <strong class=\"primary-font\">Jack Sparrow</strong>\n" +
                "                                            <small class=\"pull-right text-muted\">\n" +
                "                                                <i class=\"fa fa-clock-o fa-fw\"></i> 12 mins ago\n" +
                "                                            </small>\n" +
                "                                        </div>\n" +
                "                                        <p>\n" +
                "                                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.\n" +
                "                                        </p>\n" +
                "                                    </div>\n" +
                "                                </li>\n" +
                "                                <li class=\"right clearfix\">\n" +
                "                                    <span class=\"chat-img pull-right\">\n" +
                "                                        <img src=\"http://placehold.it/50/FA6F57/fff\" alt=\"User Avatar\" class=\"img-circle\" />\n" +
                "                                    </span>\n" +
                "                                    <div class=\"chat-body clearfix\">\n" +
                "                                        <div class=\"header\">\n" +
                "                                            <small class=\" text-muted\">\n" +
                "                                                <i class=\"fa fa-clock-o fa-fw\"></i> 13 mins ago</small>\n" +
                "                                            <strong class=\"pull-right primary-font\">Bhaumik Patel</strong>\n" +
                "                                        </div>\n" +
                "                                        <p>\n" +
                "                                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.\n" +
                "                                        </p>\n" +
                "                                    </div>\n" +
                "                                </li>\n" +
                "                                <li class=\"left clearfix\">\n" +
                "                                    <span class=\"chat-img pull-left\">\n" +
                "                                        <img src=\"http://placehold.it/50/55C1E7/fff\" alt=\"User Avatar\" class=\"img-circle\" />\n" +
                "                                    </span>\n" +
                "                                    <div class=\"chat-body clearfix\">\n" +
                "                                        <div class=\"header\">\n" +
                "                                            <strong class=\"primary-font\">Jack Sparrow</strong>\n" +
                "                                            <small class=\"pull-right text-muted\">\n" +
                "                                                <i class=\"fa fa-clock-o fa-fw\"></i> 14 mins ago</small>\n" +
                "                                        </div>\n" +
                "                                        <p>\n" +
                "                                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.\n" +
                "                                        </p>\n" +
                "                                    </div>\n" +
                "                                </li>\n" +
                "                                <li class=\"right clearfix\">\n" +
                "                                    <span class=\"chat-img pull-right\">\n" +
                "                                        <img src=\"http://placehold.it/50/FA6F57/fff\" alt=\"User Avatar\" class=\"img-circle\" />\n" +
                "                                    </span>\n" +
                "                                    <div class=\"chat-body clearfix\">\n" +
                "                                        <div class=\"header\">\n" +
                "                                            <small class=\" text-muted\">\n" +
                "                                                <i class=\"fa fa-clock-o fa-fw\"></i> 15 mins ago</small>\n" +
                "                                            <strong class=\"pull-right primary-font\">Bhaumik Patel</strong>\n" +
                "                                        </div>\n" +
                "                                        <p>\n" +
                "                                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.\n" +
                "                                        </p>\n" +
                "                                    </div>\n" +
                "                                </li>\n" +
                "                            </ul>\n" +
                "                        </div>\n" +
                "                        <!-- /.panel-body -->\n" +
                "                        <div class=\"panel-footer\">\n" +
                "                            <div class=\"input-group\">\n" +
                "                                <input id=\"btn-input\" type=\"text\" class=\"form-control input-sm\" placeholder=\"Type your message here...\" />\n" +
                "                                <span class=\"input-group-btn\">\n" +
                "                                    <button class=\"btn btn-warning btn-sm\" id=\"btn-chat\">\n" +
                "                                        Send\n" +
                "                                    </button>\n" +
                "                                </span>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                        <!-- /.panel-footer -->\n" +
                "                    </div>\n" +
                "                    <!-- /.panel .chat-panel -->\n" +
                "                </div>\n" +
                "                <!-- /.col-lg-4 -->\n" +
                "            </div>\n" +
                "            <!-- /.row -->\n";


    }


    /**************************************************************************
     *
     *              This is data from the example. The script defines the area for displaying
     *              it so it can only be used together with the actual graphs.
     *              The goal shoulf be to load this dynamically with AJAX
     *
     *
     * @return       - Script for loading the chart components with data.
     */

    @Override
    public String renderDataScripts(){

        return  "            <script src=\"adminCommon/js/morris-data.js\"></script>\n";

    }

}
