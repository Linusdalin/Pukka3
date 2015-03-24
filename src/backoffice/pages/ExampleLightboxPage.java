package backoffice.pages;

import style.pageComponents.PageHeader;

import javax.servlet.http.HttpServletRequest;

/**
 *
 *          Example light box
 */

public class ExampleLightboxPage extends GenericPage implements PageInterface {

    public ExampleLightboxPage(){

        setName("exampleLightbox");
        setTitle("Example Lightbox");

    }


    public String render(HttpServletRequest request){

        return  "Example body...";

    }


}
