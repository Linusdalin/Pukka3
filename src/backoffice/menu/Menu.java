package backoffice.menu;

import backoffice.style.HtmlBlock;

/**
 *
 *       BackOffice Menu
 *
 */

public class Menu {

    private SectionInterface[] sections;
    private SearchComponent searchComponent = null;
    private NavBar navBar = null;

    public Menu( SectionInterface[] sections ){

        this.sections = sections;
    }

    public Menu withSearch(){

        searchComponent = new SearchComponent();
        return this;
    }

    /***************************************************************************'
     *
     *          Render menu section
     *          (adding optional search)
     *
     *
     * @return
     */

    public HtmlBlock render(){

        HtmlBlock menu = new HtmlBlock();

        menu.append(    "            <div class=\"navbar-default sidebar\" role=\"navigation\">\n" +
                        "                <div class=\"sidebar-nav navbar-collapse\">\n" +
                        "                    <ul class=\"nav\" id=\"side-menu\">\n");

        // Add optional search component

        if(searchComponent != null){

            menu.append(searchComponent.render());
        }
        else{
            menu.append("<!-- No search configured ->");
        }

        // Recursively render the sections in the tree. Starting at level 1

        for (SectionInterface section : sections) {

            menu.append(section.render( 1 ));

        }

        menu.append(
                "                    </ul>\n" +
                "                </div>\n" +
                "                <!-- /.sidebar-collapse -->\n" +
                "            </div>\n"

        );

        return menu;
    }

    public String renderNew(){

        return(

                "            <div class=\"navbar-default sidebar\" role=\"navigation\">\n" +
                "                <div class=\"sidebar-nav navbar-collapse\">\n" +
                "                    <ul class=\"nav\" id=\"side-menu\">\n" +

                new SearchComponent().render() +
                "                        <li>\n" +
                "                            <a href=\"index.html\"><i class=\"fa fa-dashboard fa-fw\"></i> Home</a>\n" +
                "                        </li>\n" +
                "                        <li>\n" +
                "                            <a href=\"#\"><i class=\"fa fa-bar-chart-o fa-fw\"></i> Home2<span class=\"fa arrow\"></span></a>\n" +
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
