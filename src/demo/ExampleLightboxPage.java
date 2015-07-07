package demo;

import backoffice.common.LinkType;
import backoffice.lightbox.DynamicModal;
import backoffice.lightbox.LightboxInterface;
import backoffice.pages.GenericPage;
import backoffice.pages.PageInterface;
import backoffice.style.Html;
import backoffice.style.HtmlBlock;

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


    public HtmlBlock toHtml(HttpServletRequest request){

        return  new HtmlBlock(Html.paragraph("<p>This is the dynamic modal lightbox")+ example.renderLink(LinkType.BUTTON, "click me!") + example.renderAnchor());

    }


}
