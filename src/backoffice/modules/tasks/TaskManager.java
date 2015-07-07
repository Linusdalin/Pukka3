package backoffice.modules.tasks;

import backoffice.style.HtmlBlock;

/**
 *
 *          Not implemented. Rendering a default placeholder
 *
 */
public class TaskManager {


    public TaskManager(){

    }

    public HtmlBlock render(){

        return new HtmlBlock(
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
                        "                </li>\n");

    }
}
