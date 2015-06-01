package backoffice.modules.dynamicVariable;

import backoffice.errorHandling.BackOfficeException;

import java.util.ArrayList;
import java.util.List;

/********************************************************************************************
 *
 *          A DynamicLoader is standardized way of loading values with JSON and replacing a
 *          placeholder in the HTML file:
 *
 *          Example:
 *
 *          JSON: {"value": 4711 }
 *
 *          DynamicLoader()
 *              .withSubstitution( "value", "placement")
 *
 *          And in the html:
 *
 *          <p>Dynamic value: <span class="placement"> This will be replaced </span></p>
 *
 *
 */
public class DynamicLoader {

    private String url = null;
    private List<Substitution> replacements = new ArrayList<Substitution>();

    /************************************************************''
     *
     *          Create a new Dynamic loader
     *
     *
     */

    public DynamicLoader(){

    }

    /***************************************************************'
     *
     *          Set the url for the request
     *
     * @param url        - the request URL
     */

    public void setURL(String url) {

        this.url = url;
    }


    /*************************************************************************
     *
     *      Add a substitution to a request.
     *      (Each request bey contain multiple data fields that should be placed on the page
     *
     * @param field                     - the JSON field name
     * @param substitutionClass         - class of span/div
     * @return                          - self
     */

    public DynamicLoader withSubstitution(String field, String substitutionClass){

        Substitution substitution = new Substitution(field, substitutionClass);
        replacements.add(substitution);
        return this;

    }

    /*****************************************************************************
     *
     *      Get the custom generated javaScript
     *
     *      This is called for all Dynamic loaders registered in a page
     *
     * @return                             - java script
     * @throws BackOfficeException
     */

    public String getScript() throws BackOfficeException{

        if(url == null)
            throw new BackOfficeException(BackOfficeException.Type.CONFIGURATION, "No URL set for dynamic loader");

        StringBuffer html = new StringBuffer();

        html.append("        <!-- load script for DynamicLoader(" + url + ") -->\n\n" +
                "<script>" +
                "$(document).ready(function(){\n\n" +
                "    // Get data and update the page\n\n" +
                "    $.get(\""+this.url+"\", function(data,status){\n" +
                "\n");

        for (Substitution replacement : replacements) {

            html.append("        $(\"#"+ replacement.substitutionClass +"\").text(data."+ replacement.jsonField+");\n");
        }



        html.append("\n" +
                "    });\n" +
                "});\n" +
                " </script>\n");

        return html.toString();
    }

    public String getSpan(int fieldNo) {

        Substitution substitution = replacements.get( fieldNo );

        return "<span id=\""+ substitution.substitutionClass+"\">$SUBSTITUTION</span>";
    }
}
