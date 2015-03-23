package backoffice.menu;

import backoffice.BackofficeInterface;
import backoffice.modules.messages.MessageManager;
import backoffice.modules.notifications.NotificationManager;
import backoffice.modules.tasks.TaskManager;

/**
 *
 * Created with IntelliJ IDEA.
 * User: Linus
 * Date: 2015-03-22
 * Time: 14:13
 * To change this template use File | Settings | File Templates.
 */
public class NavBar {

    // Optional functionality

    private NotificationManager notationManager = null;
    private MessageManager messagemanager = null;
    private TaskManager taskmanager = null;

    public NavBar() {

    }


    /************************************************************
     *
     *          Render the NavBar (the icons in the top right corner)
     *
     * @param backOffice       - active backoffice
     * @param thisURL          - page URL (for logout redirect
     * @return                 - html
     */

    public String render(BackofficeInterface backOffice, String thisURL){

        StringBuffer topBar = new StringBuffer();

        topBar.append(
                "            <ul class=\"nav navbar-top-links navbar-right\">\n");

        if(messagemanager != null)
            topBar.append(messagemanager.render());

        if(taskmanager != null)
            topBar.append(taskmanager.render());

        if(notationManager != null)
            topBar.append(notationManager.render());

        // Create the logout URL from the ACS system

        String logoutURL = backOffice.getAcs().getLogoutRedirectURL(thisURL);


        topBar.append(
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
                "                        <li><a href=\""+ logoutURL+"\"><i class=\"fa fa-sign-out fa-fw\"></i> Logout</a>\n" +
                "                        </li>\n" +
                "                    </ul>\n" +
                "                    <!-- /.dropdown-user -->\n" +
                "                </li>\n" +
                "                <!-- /.dropdown -->\n");

        topBar.append(
                "            </ul>\n" +
                "            <!-- /.navbar-top-links -->\n");

        return topBar.toString();
    }

    public NavBar useNotifications() {

        this.notationManager = new NotificationManager();
        return this;
    }

    public NavBar useMessages() {

        this.messagemanager = new MessageManager();
        return this;
    }

    public NavBar useTasks() {

        this.taskmanager = new TaskManager();
        return this;
    }


}
