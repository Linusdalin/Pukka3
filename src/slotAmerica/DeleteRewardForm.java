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

public class DeleteRewardForm extends Form implements FormInterface {

    List<FormFieldInterface> fields = new ArrayList<FormFieldInterface>();


    public DeleteRewardForm(Location location){

        super("DeleteForm", location);


        fields.add(new TextField("rewardId")
                            .withLabel("Id")
                            .withPlaceholder("000-000-000")
                            .withHelpText("Campaign id"));


        fields.add(new Button("submit")
                            .withValue("Delete!"));



        setElements(fields);
        setMethodGET();
        setAjaxSubmit("http://localhost:3003/deleteReward", Form.Action.RELOAD);

    }


    public CallbackMessage submitCallBack( HttpServletRequest request){

        return(new CallbackMessage(CallbackMessage.CallbackAction.WARNING, "TODO: No action for form example implemented."));
    }


}
