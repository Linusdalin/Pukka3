package backoffice.menu;

/**
 *
 *       BackOffice menu
 *
 */

public class Menu {

    private SectionInterface[] sections;
    private boolean includeSearch = false;
    private NavBar navBar = null;

    public Menu( SectionInterface[] sections ){

        this.sections = sections;
    }

    public Menu withSearch(){

        includeSearch = true;
        return this;
    }


    public String render(){

        return(

                "            <div class=\"navbar-default sidebar\" role=\"navigation\">\n" +
                "                <div class=\"sidebar-nav navbar-collapse\">\n" +
                "                    <ul class=\"nav\" id=\"side-menu\">\n" +

                new SearchComponent().render() +
                "                        <li>\n" +
                "                            <a href=\"index.html\"><i class=\"fa fa-dashboard fa-fw\"></i> Home</a>\n" +
                "                        </li>\n" +
                "                        <li>\n" +
                "                            <a href=\"#\"><i class=\"fa fa-bar-chart-o fa-fw\"></i> Charts<span class=\"fa arrow\"></span></a>\n" +
                "                            <ul class=\"nav nav-second-level\">\n" +
                "                                <li>\n" +
                "                                    <a href=\"flot.html\">Flot Charts</a>\n" +
                "                                </li>\n" +
                "                                <li>\n" +
                "                                    <a href=\"morris.html\">Morris.js Charts</a>\n" +
                "                                </li>\n" +
                "                            </ul>\n" +
                "                            <!-- /.nav-second-level -->\n" +
                "                        </li>\n" +
                "                        <li>\n" +
                "                            <a href=\"tables.html\"><i class=\"fa fa-table fa-fw\"></i> Tables</a>\n" +
                "                        </li>\n" +
                "                        <li>\n" +
                "                            <a href=\"forms.html\"><i class=\"fa fa-edit fa-fw\"></i> Forms</a>\n" +
                "                        </li>\n" +
                "                        <li>\n" +
                "                            <a href=\"#\"><i class=\"fa fa-wrench fa-fw\"></i> UI Elements<span class=\"fa arrow\"></span></a>\n" +
                "                            <ul class=\"nav nav-second-level\">\n" +
                "                                <li>\n" +
                "                                    <a href=\"panels-wells.html\">Panels and Wells</a>\n" +
                "                                </li>\n" +
                "                                <li>\n" +
                "                                    <a href=\"buttons.html\">Buttons</a>\n" +
                "                                </li>\n" +
                "                                <li>\n" +
                "                                    <a href=\"notifications.html\">Notifications</a>\n" +
                "                                </li>\n" +
                "                                <li>\n" +
                "                                    <a href=\"typography.html\">Typography</a>\n" +
                "                                </li>\n" +
                "                                <li>\n" +
                "                                    <a href=\"icons.html\"> Icons</a>\n" +
                "                                </li>\n" +
                "                                <li>\n" +
                "                                    <a href=\"grid.html\">Grid</a>\n" +
                "                                </li>\n" +
                "                            </ul>\n" +
                "                            <!-- /.nav-second-level -->\n" +
                "                        </li>\n" +
                "                        <li>\n" +
                "                            <a href=\"#\"><i class=\"fa fa-sitemap fa-fw\"></i> Multi-Level Dropdown<span class=\"fa arrow\"></span></a>\n" +
                "                            <ul class=\"nav nav-second-level\">\n" +
                "                                <li>\n" +
                "                                    <a href=\"#\">Second Level Item</a>\n" +
                "                                </li>\n" +
                "                                <li>\n" +
                "                                    <a href=\"#\">Second Level Item</a>\n" +
                "                                </li>\n" +
                "                                <li>\n" +
                "                                    <a href=\"#\">Third Level <span class=\"fa arrow\"></span></a>\n" +
                "                                    <ul class=\"nav nav-third-level\">\n" +
                "                                        <li>\n" +
                "                                            <a href=\"#\">Third Level Item</a>\n" +
                "                                        </li>\n" +
                "                                        <li>\n" +
                "                                            <a href=\"#\">Third Level Item</a>\n" +
                "                                        </li>\n" +
                "                                        <li>\n" +
                "                                            <a href=\"#\">Third Level Item</a>\n" +
                "                                        </li>\n" +
                "                                        <li>\n" +
                "                                            <a href=\"#\">Third Level Item</a>\n" +
                "                                        </li>\n" +
                "                                    </ul>\n" +
                "                                    <!-- /.nav-third-level -->\n" +
                "                                </li>\n" +
                "                            </ul>\n" +
                "                            <!-- /.nav-second-level -->\n" +
                "                        </li>\n" +
                "                        <li>\n" +
                "                            <a href=\"#\"><i class=\"fa fa-files-o fa-fw\"></i> Sample Pages<span class=\"fa arrow\"></span></a>\n" +
                "                            <ul class=\"nav nav-second-level\">\n" +
                "                                <li>\n" +
                "                                    <a href=\"blank.html\">Blank Page</a>\n" +
                "                                </li>\n" +
                "                                <li>\n" +
                "                                    <a href=\"login.html\">Login Page</a>\n" +
                "                                </li>\n" +
                "                            </ul>\n" +
                "                            <!-- /.nav-second-level -->\n" +
                "                        </li>\n" +
                "                    </ul>\n" +
                "                </div>\n" +
                "                <!-- /.sidebar-collapse -->\n" +
                "            </div>\n"


                );


    }

    public Menu withNavbar(NavBar navbar) {

        this.navBar = navbar;
        return this;
    }

    public NavBar getNavBar() {
        return navBar;
    }
}
