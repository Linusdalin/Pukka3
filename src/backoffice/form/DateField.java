package backoffice.form;


/***********************************************************
 *
 *          Form date picker field. To pick (or enter a date)
 *
 *          //TODO: Enhancement: There are a lot of settings for the datepicker that can be added
 *
 */

public class DateField extends GeneralTextInput implements FormFieldInterface {

    private String format = "yyyy-mm-dd"; // default format

    public DateField(String name){

        super(name);

    }

    public DateField(String name, String format){

        super(name);
        this.format = format;

    }


    /*****************************************************************
     *
     *   Returns the HTML needed to visualise this element
     *
     * @return
     */


    public String renderElement(){

        return
        "               <script>\n" +
        "               $(document).ready(function() {\n" +

        "                   $('#"+name+"').datepicker({\n" +
        "                       format: '" +format+"',\n" +
        "                   });\n"  +
        "               });\n\n" +
        "               </script>\n\n" +
        "                              <div class=\"form-group\">\n" +
        "                                  <label>"+label+"</label>\n" +
        "                                  <input id=\""+name+"\" class=\"datepicker\" data-date-format=\"mm/dd/yyyy\">" +
        (helpText != null ? "                                  <p class=\"help-block\">"+helpText+"</p>\n" : "") +
        "                              </div>\n";

    }

}
