package demo;

import backoffice.common.LinkType;
import backoffice.lightbox.DynamicModal;
import backoffice.lightbox.LightboxInterface;
import backoffice.pages.GenericPage;
import backoffice.pages.PageInterface;

import javax.servlet.http.HttpServletRequest;

/**
 *
 *          Example light box
 */

public class ExampleLightboxPage extends GenericPage implements PageInterface {

    private static final LightboxInterface example = new DynamicModal();

    public ExampleLightboxPage(){

        setName("exampleLightbox");
        setTitle("Example Lightbox");

    }


    public String render(HttpServletRequest request){

        return  "<p>This is the dynamic modal lightbox</p> "+ example.renderLink(LinkType.BUTTON, "click me!") + example.renderAnchor();

    }


}
