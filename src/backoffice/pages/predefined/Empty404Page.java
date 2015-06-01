package backoffice.pages.predefined;

import backoffice.pages.GenericPage;
import backoffice.pages.PageInterface;
import backoffice.style.pageComponents.PageHeader;

import javax.servlet.http.HttpServletRequest;

/**
 *
 *          404 page
 */

public class Empty404Page extends GenericPage implements PageInterface {

    public Empty404Page(){

        setName("404");
        setTitle("Missing");

    }


    public String render(HttpServletRequest request){

        return  new PageHeader("404 - page missing").render();

    }


}
