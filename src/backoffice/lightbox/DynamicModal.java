package backoffice.lightbox;

import javax.servlet.http.HttpServletRequest;

/*************************************************************************
 *
 *              Basic Modal Lightbox component using the built in modal
 *
 *              The lightbox should be added to the page and must be registered
 *              in the backoffice to be able to dynamically recall the content in the servlet
 */
public class DynamicModal extends GenericLightBox implements LightBoxInterface {


    private static final String name = "DynamicModal";            // Used to recall the content in the servlet
    private static final String title = "Example Modal";

    public DynamicModal(){

        super(name, title);
    }



    public String renderContent(HttpServletRequest request){

        return "<p>This is the content</p>";

    }


}
