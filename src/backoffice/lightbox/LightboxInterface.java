package backoffice.lightbox;

import backoffice.common.LinkType;
import backoffice.style.HtmlBlock;

import javax.servlet.http.HttpServletRequest;

/*****************************************************************************
 *
 *      Interface for all lightBoxes
 *
 *      The methods are implemented in the GenericLightBox class but the content should be overridden
 *
 *      This is an example implementation:


     public class ExampleModal extends GenericLightBox implements LightBoxInterface {

         public DynamicModal(){

             super("thename", "a Title");
         }


         @Override
         public String renderContent(HttpServletRequest request){

             return "<p>This is the content</p>";

         }

     }

 *
 *          //TODO: Make a simple static modal
 */

public interface LightboxInterface {


    // Render the hidden anchor div
    // This is standard implementation.

    HtmlBlock renderAnchor();


    // Render the link (button or hyperlink)
    // This is standard implementation.

    HtmlBlock renderLink(LinkType type, String anchorText);


    // Light box content
    // This method should be overridden in all light boxes

    HtmlBlock renderContent(HttpServletRequest request);


    // Get the name
    // This is standard implementation.

    String getName();


    // Get the title
    // The standard implementation is the title field, but this may often be overridden

    String getTitle(HttpServletRequest req);
}
