package backoffice.errorHandling;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;


/*************************************************************************
 *
 *          Simple log wrapper.
 *
 *          // TODO: Implement Log4J here
 *          // TODO: Reimplement fatal error email
 */

public class PukkaLogger {

    private static LogLevel filterLevel = LogLevel.INFO;

    /********************************************************************
     *
     *          Change the filter level
     *
     *
     * @param lvl
     */

    public static void setLogLevel(LogLevel lvl){

        filterLevel = lvl;
    }


    public static void log(LogLevel level, String message){

        log(level, message, null);

    }

    private static void log(LogLevel level, String message, String info){

        if(level.getOrdinal() >= filterLevel.getOrdinal()){

            System.out.println(level + ": " + message);
            if(info != null)
                System.out.println(info);

        }

        // Send a notification for fatal errors

        if(level == LogLevel.FATAL){

            //FatalErrorMail notification = new FatalErrorMail(message, info);
            //notification.sendTo("Linus", "linusdalin@gmail.com");

        }

    }


    public static void log(BackOfficeException e){

        String info = getMessage( e );

        log(LogLevel.FATAL, e.message, info);
    }

    public static void swallow(BackOfficeException e){

        String info = getMessage( e );

        log(LogLevel.INFO, e.message, info);
    }

    public static void log(Exception e){

        log(e, "");
    }


    public static void log(Exception e, String additionalInfo){

        String info = getMessage( e );

        log(LogLevel.FATAL, "Exception Stacktrace:", info + "(" + additionalInfo + ")");


    }

    public static String getMessage(Exception e){

        Writer writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        e.printStackTrace(printWriter);
        return writer.toString();


    }



}
