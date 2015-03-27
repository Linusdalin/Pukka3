package backoffice.lightbox;

import backoffice.common.LinkType;

import javax.servlet.http.HttpServletRequest;


/**************************************************************************
 *
 *          abstract class with generic light box functionality
 *
 *          All lightboxes should extend this class
 *
 *          //TODO: All lightboxes share the same anchor div. Does this really work with multiple lightboxes on the same page?
 */

abstract public class GenericLightBox {

    protected final static String PARAMETER_NAME = "lightBox";        // parameter calling
    private final String name;                                        // The name for lookup
    private final String title;                                       // The title to display

    protected GenericLightBox(String name, String title){

        this.name = name;
        this.title = title;
    }

    /**************************************************************************
     *
     *          Render the hidden anchor functionality for the
     *
     * @return
     */

    public String renderAnchor(){

        StringBuffer html = new StringBuffer();

        html.append("                            <!-- Modal -->\n");
        html.append("                            <div class=\"modal fade\" id=\"pukkaModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\" ></div>\n");
        html.append("                            <!-- /.modal -->\n");


        return html.toString();
    }

    /***************************************************************************''
     *
     *          There are two main types of links to generate. An anchor link or a button.
     *
     *          Both use the anchor text
     *
     *
     * @param type              - type of link
     * @param anchorText        - text to display
     * @return
     */


    public String renderLink(LinkType type, String anchorText){

        switch (type) {


            case BUTTON:
                return  "<button class=\"btn btn-primary btn-lg\" data-toggle=\"modal\" id=\"modal1\" data-target=\"#pukkaModal\" href=\"/LightBox?"+ PARAMETER_NAME+"="+name+"\">"+anchorText+"</button>";

            case LINK:
                return "<a href=\"/LightBox?"+PARAMETER_NAME+"="+ name+"\" data-toggle=\"modal\" data-target=\"#pukkaModal\">"+ anchorText+"</a>";
        }

        //TODO: Throw exception

        return "<!-- error rendering link for lightbox -->";
    }


    /*********************************************************
     *
     *      get the name
     *
     * @return
     */


    public String getName() {
        return name;
    }


    public String getTitle(HttpServletRequest request) {
        return title;
    }


}
