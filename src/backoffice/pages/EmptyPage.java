package backoffice.pages;

import style.pageComponents.PageHeader;

import javax.servlet.http.HttpServletRequest;

/**
 *
 *          404 page
 */

public class EmptyPage extends GenericPage implements PageInterface {

    public EmptyPage(){

        setName("404");
        setTitle("Missing");

    }


    public String render(HttpServletRequest request){

        return  new PageHeader("404 - page missing").render();

    }


}
