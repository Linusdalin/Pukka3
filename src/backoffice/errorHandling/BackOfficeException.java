package backoffice.errorHandling;

/**
 *      Exception for the usage of the Pukka back office
 *
 *      The intention is to provide more detailed information on the error
 *      situation when something goes wrong
 */

public class BackOfficeException extends Exception {

    private final Type type;
    public final String message;

    public enum Type {

        NOT_IMPLEMENTED,                // Call of not implemented method
        GENERIC,                // Generic error
        CONFIGURATION,          // Expected configuration is missing
    }

    public BackOfficeException(String message){

        this(Type.GENERIC, message);
    }


    public BackOfficeException(Type type, String message){

        this.type = type;
        this.message = message;
    }
}
