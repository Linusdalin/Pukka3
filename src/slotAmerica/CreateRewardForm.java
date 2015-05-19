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

public class CreateRewardForm extends Form implements FormInterface {

    List<FormFieldInterface> fields = new ArrayList<FormFieldInterface>();


    public CreateRewardForm(Location location){

        super("CreateReward", location);

        fields.add(new DropdownField("type", new String[]{"COINS", "Discount"}, null)
                .withLabel("Type")
                //.withPlaceholder("type here")
                .withHelpText("Only Coins implemented so far. More types will be added"));

        fields.add(new IntField("value")
                            .withLabel("Value")
                            .withPlaceholder("Number to give away")
                            .withHelpText("Number to give out"));

        fields.add(new TextField("userCategories")
                            .withLabel("Categories")
                            .withPlaceholder("1, 2, 3...")
                            .withHelpText("Applicable groups"));

        fields.add(new DateField("expiry")
                            .withLabel("Expiry Date"));

        fields.add(new TextField("message")
                            .withLabel("Message")
                            .withPlaceholder("message...")
                            .withHelpText("Message presented to the end user when the reward is claimed"));


        //fields.add(new DescriptionText("categories")
        //                    .withValue("This is static text (without label)"));

        fields.add(new Button("submit")
                            .withValue("Create!"));



        setElements(fields);
        setAjaxSubmit("http://localhost:3003/createReward", Action.RELOAD);

    }


    public CallbackMessage submitCallBack( HttpServletRequest request){

        return(new CallbackMessage(CallbackMessage.CallbackAction.WARNING, "TODO: No action for form "+ name +" implemented."));
    }


}
