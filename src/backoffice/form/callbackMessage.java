package backoffice.form;

import backoffice.common.AlertBox;
import backoffice.common.AlertType;

/**
 *          The result from a callback message. This will typically be
 *          presented to the user after completing
 *
 *
 *              action: Defines what to do with the payload message
 *              message: text outcome from the callback
 *
 */
public class CallbackMessage {

    private final CallbackAction action;
    private final String message;


    public enum CallbackAction {COMPLETE_ACTION, ERROR, WARNING, NO_ACTION, INFO}

    public CallbackMessage(CallbackAction action, String message){

        this.action = action;
        this.message = message;
    }


    public CallbackAction getAction() {
        return action;
    }

    public String getMessage() {
        return message;
    }

    public String toString(){

        return "callbackAction(" + action.name() + ": \"" + message + "\")";
    }


    public AlertBox toAlertBox() {

        AlertType type = getTypeForAction(action);
        return new AlertBox(type, message);

    }

    private AlertType getTypeForAction(CallbackAction action) {

        switch (action) {

            case ERROR:
                return AlertType.INFO;
            case WARNING:
                return AlertType.WARNING;
            case COMPLETE_ACTION:
                return AlertType.SUCCESS;
            case NO_ACTION:
                return AlertType.INFO;
            case INFO:
                return AlertType.INFO;
            default:
                return AlertType.INFO;
        }
    }


}
