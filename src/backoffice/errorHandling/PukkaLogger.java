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


    /*********************************************************************
     *
     *          main logging method
     *
     *          The info parameter is used when there is an exception to log with
     *
     *              - message which is a manual message
     *              - and a stacktrace
     *
     *
     * @param level
     * @param message
     */


    public static void log(LogLevel level, String message){

        log(level, message, null);

    }

    private static void log(LogLevel level, String message, String stackInfo){

        if(level.getOrdinal() >= filterLevel.getOrdinal()){

            System.out.println(level + ": " + message);
            if(stackInfo != null)
                System.out.println(stackInfo);

        }

        // Send a notification for fatal errors

        if(level == LogLevel.FATAL){

            //FatalErrorMail notification = new FatalErrorMail(message, info);
            //notification.sendTo("Linus", "linusdalin@gmail.com");

        }

    }

    /*********************************************************************
     *
     *          Logging or swallowing an exception
     *
     *
     * @param e        - the exception
     */


    public static void log(BackOfficeException e){

        String info = getStackInfo(e);

        log(LogLevel.FATAL, e.message, info);
    }

    public static void swallow(BackOfficeException e){

        String info = getStackInfo(e);

        log(LogLevel.INFO, e.message, info);
    }

    public static void log(Exception e){

        log(e, "");
    }


    public static void log(Exception e, String additionalInfo){

        String info = getStackInfo(e);

        log(LogLevel.FATAL, additionalInfo, info);


    }

    /**********************************************************
     *
     *          Extracting the stacktrace to the log
     *
     * @param e       - the exception
     * @return        - stack trace as a string
     */

    public static String getStackInfo(Exception e){

        Writer writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        e.printStackTrace(printWriter);
        return writer.toString();


    }



}
