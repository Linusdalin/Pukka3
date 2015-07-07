package backoffice.menu;

import backoffice.style.HtmlBlock;

/**
 * Created with IntelliJ IDEA.
 * User: Linus
 * Date: 2015-03-21
 * Time: 22:47
 * To change this template use File | Settings | File Templates.
 */
public class SearchComponent {


    public HtmlBlock render(){



        return new HtmlBlock(         "                        <li class=\"sidebar-search\">\n" +
                        "                            <div class=\"input-group custom-search-form\">\n" +
                        "                                <input type=\"text\" class=\"form-control\" placeholder=\"Search...\">\n" +
                        "                                <span class=\"input-group-btn\">\n" +
                        "                                <button class=\"btn btn-default\" type=\"button\">\n" +
                        "                                    <i class=\"fa fa-search\"></i>\n" +
                        "                                </button>\n" +
                        "                            </span>\n" +
                        "                            </div>\n" +
                        "                            <!-- /input-group -->\n" +
                        "                        </li>\n");



    }
}
