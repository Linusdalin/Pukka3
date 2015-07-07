package backoffice.pages.template;

import backoffice.pages.GenericPage;
import backoffice.pages.PageInterface;
import backoffice.style.HtmlBlock;
import backoffice.style.pageComponents.PageHeader;

import javax.servlet.http.HttpServletRequest;

/**
 *
 *          404 page
 */

public class TabPage extends GenericPage implements PageInterface {

    public TabPage(){

        setName("404");
        setTitle("Missing");

    }


    public HtmlBlock toHtml(HttpServletRequest request){

        return  new PageHeader("404 - page missing").toHtml();

    }


}
