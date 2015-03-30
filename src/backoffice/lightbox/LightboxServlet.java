package backoffice.lightbox;

import backoffice.services.PukkaServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/****************************************************************************
 *
 *              Servlet to serve a generic page in the backOffice.
 *
 *              This is used for all pages with the navigation menu
 *
 */

public class LightBoxServlet extends PukkaServlet {

    /*************************************************************************''
     *
     *              Get page for light box content
     *
     *              The lightbox has standard content injected with the
     *              title and content from the lightbox
     *
     *              The lightbox is identified by the mandatory parameter
     *              "&lightBox=<name>" passed by the call
     *
     *
     * @param req           - request
     * @param resp          - response
     * @throws java.io.IOException
     */


    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws IOException {

        logRequest(req);

        if(!validateSession(req, resp))
            return;

        System.out.println("In Lightbox servlet");

        String lightBoxName = req.getParameter(GenericLightBox.PARAMETER_NAME);
        String content = "<p> The page "+ lightBoxName+"does not exist!</p>";           // Default message when not found
        String title = "<h3> Not found </h3>";                                          // Default message when not found
        if(lightBoxName != null){

            LightboxInterface lightBox = backOffice.getLightBoxByName(lightBoxName);
            if(lightBox != null){

                content = lightBox.renderContent(req);
                title = lightBox.getTitle(req);
            }
        }

        StringBuffer html = new StringBuffer();

        html.append(
                "<div class=\"modal-dialog\">\"\n" +
                "    <div class=\"modal-content\">\n" +
                "        <div class=\"modal-header\">\n" +
                "            <a class=\"close\" data-dismiss=\"modal\">&times;</a>\n" +
                "            <h3>"+ title +"</h3>\n" +
                "        </div>\n" +
                "        <div class=\"modal-body\">\n" +

                content +

                "        </div>\n" +
                "        <div class=\"modal-footer\">\n" +
                "            <a class=\"btn btn-primary\" onclick=\"$('.modal-body > form').submit();\">Save Changes</a>\n" +
                "            <a class=\"btn\" data-dismiss=\"modal\">Close</a>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>\n");



        resp.getWriter().print(html.toString());

        /*
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        resp.setHeader("Access-Control-Max-Age", "" + (24 * 60 * 60));
        resp.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        resp.setHeader("Access-Control-Allow-Headers", "content-type");

        */

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        resp.flushBuffer();

    }


}
