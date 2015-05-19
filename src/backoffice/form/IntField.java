package backoffice.form;


/***********************************************************
 *
 *          Form integer field. To enter a number
 *
 *          //TODO: Add validation
 */

public class IntField extends GeneralTextInput implements FormFieldInterface {


    public IntField(String name){

        super(name);

    }

    /*****************************************************************
     *
     *   Returns the HTML needed to visualise this element
     *
     * @return
     */


    public String renderElement(){

        /*

        return
            "\t<label for=\""+ fieldName + "\">" + name + "</label>\n" +
            "\t<input id=\"" + fieldName + "\" name=\"" + fieldName + "\"" + displayValue +
                    " type=\"text\" size=\""+ size+"\" maxlength=\"" + maxChars + "\" />\n\n";

    */

        String displayValue;

        if(value != null  && !value.equals(""))
            displayValue = " value = \"" + value + "\"";
        else
            displayValue = " placeholder = \"" + placeholder + "\"";



    return
            "                                        <div class=\"form-group\">\n" +
            "                                            <label>"+label+"</label>\n" +
            "                                            <input class=\"form-control\" name=\""+ name+"\" "+ displayValue +">\n" +
            (helpText != null ? "                                            <p class=\"help-block\">"+helpText+"</p>\n" : "") +
            "                                        </div>\n";

    }

}
