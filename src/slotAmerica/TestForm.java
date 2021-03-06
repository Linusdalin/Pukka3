package slotAmerica;

import backoffice.common.Location;
import backoffice.form.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/******************************************************************************'
 *
 *          This is a very simple form that displays the field types
 *
 */

public class TestForm extends Form implements FormInterface {

    List<FormFieldInterface> fields = new ArrayList<FormFieldInterface>();


    public TestForm(Location location){

        super("ExampleForm", location);

        fields.add(new TextField("text1")
                .withLabel("Text Field")
                .withPlaceholder("type here")
                .withHelpText("Read this!"));

        fields.add(new TextField("text2")
                            .withLabel("Text Field with value")
                            .withValue("Volvo"));

        fields.add(new DescriptionText("text3")
                            .withValue("This is static text (without label)"));

        fields.add(new Button("button1")
                            .withValue("Click Me!"));



        setElements(fields);
        setAjaxSubmit("submit.jsp");

    }


    public callbackMessage submitCallBack( HttpServletRequest request){

        return(new callbackMessage(callbackMessage.CallbackAction.WARNING, "TODO: No action for form example implemented."));
    }


}
