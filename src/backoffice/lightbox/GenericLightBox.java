package backoffice.lightbox;

import backoffice.common.LinkType;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: Linus
 * Date: 2015-03-26
 * Time: 22:11
 * To change this template use File | Settings | File Templates.
 */
public class GenericLightBox {

    protected final static String PARAMETER_NAME = "lightBox";
    private final String name;

    protected GenericLightBox(String name){

        this.name = name;
    }

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
     * @param type
     * @param anchorText
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



    public String getName() {
        return name;
    }


}
