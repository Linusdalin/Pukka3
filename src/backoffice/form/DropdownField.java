package backoffice.form;


import backoffice.style.dropdown.Dropdown;

/***********************************************************
 *
 *          Form text field. To enter a text string
 */

public class DropdownField extends Field implements FormFieldInterface {

    Dropdown dropdown;

    public DropdownField(String name, String[] values, String selected){


        dropdown = new Dropdown(values, selected);
        dropdown.withName(name);

    }

    /*****************************************************************
     *
     *   Returns the HTML needed to visualise this element
     *
     * @return
     */


    public String renderElement(){



    return
            "                                        <div class=\"form-group\">\n" +
            "                                            <label>"+label+"</label>\n" +
            dropdown.render() +
            "                                        </div>\n";

    }

}
