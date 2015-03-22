package style;

/**
 * Created with IntelliJ IDEA.
 * User: Linus
 * Date: 2015-03-21
 * Time: 20:56
 * To change this template use File | Settings | File Templates.
 */

public class Html {



    /********************************************************************
     *
     *      Adding a parameter should be either "&param=value" or
     *
     *      "?param=value" (if the first)
     *
     * @param url
     * @param parameterName
     * @param value
     * @return
     */

    public static String addParameter(String url, String parameterName, String value){

        String res="";
        if(url.contains("?"))
            res+="&";
        else
            res+="?";

        res+=parameterName + "=" + value;

        return res;
    }



    /************************************************************
     *
     *          Creates a generic dropdown
     *
     *
     * @param name            - the name of the component/parameter
     * @param options         - the display labels
     * @param selected         - label that should be preselected
     * @return                  - html dropdown
     *
     *
     *      Example:
     *
     *
            <select>
               <option value="volvo">Volvo</option>
               <option value="saab">Saab</option>
               <option value="mercedes">Mercedes</option>
               <option value="audi" selected >Audi</option>
            </select>
     */

    public static String dropDown(String name, String[] options, String selected ){

        return dropDown(name, options, selected, "", "");
    }

    public static String dropDown(String name, String[] options, String selected, String attributes, String id ){

        StringBuffer dropDown = new StringBuffer();

        dropDown.append("<select id=\""+ id +"\" name=\""+ name +"\" "+ attributes +">\n");

        //for(int i = 0; i< options.length; i++){
        for(String option : options){



            dropDown.append("<option value = \""+option+"\" "+( option.equals(selected) ? "selected" : "")+">"+ option+"</option>\n");

        }

        dropDown.append("</select>\n");

        return dropDown.toString();
    }




    public static String heading(int i, String s){

        return "<h"+ i +">" + s + "</h"+i+">";
    }

    public static String paragraph(String s){

        return "<p>" + s + "</p>";
    }

    public static String bold(String s){

        return "<b>" + s + "</b>";
    }

    public static String italics(String s){

        return "<i>" + s + "</i>";
    }

    public static String link(String url, String linkText) {
        return "<a href=\""+url+"\">"+linkText+"</a>";
    }


    /*
            <title>itclarifies web Service documentation and Test</title>
        <link rel="stylesheet" type="text/css" href="../../doc/docstyle.css" title="Style">

     */

    public static String title(String s){

        return "<title>" + s + "</title>";
    }

    public static String cssStyle(String file){

        return "<link rel=\"stylesheet\" type=\"text/css\" href=\""+ file+"\" title=\"Style\">";
    }

    public static String listItem(String s){
        return "<li>" + s + "</li>";
    }

    public static String option(String option, String key, boolean selected, String text) {

        return("<option name=\""+ option +"\" value=\""+ key + "\"" + (selected ? " selected" : "") +  ">" + text + "</option>\n");

    }

    public static String option(String option, String key, boolean selected) {
        return option(option, key, selected, option);
    }

    public static String newLine() {
        return "<br/>\n";
    }


    public static String button(String label, String action){

        return("<input type=\"button\" value=\""+ label +"\" onClick=\""+ action+"\">");

    }


}
