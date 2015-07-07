package slotAmerica;

import backoffice.errorHandling.LogLevel;
import backoffice.errorHandling.PukkaLogger;
import data.dataBaseLayer.DataBaseAbstractionFactory;
import data.dataBaseLayer.EnvironmentAbstractionInterface;

/*******************************************************'
 *
 *          Static handler for the server access.
 *
 *
 *
 *
 */
public class ServerManager {

    /**************************************************************
     *
     *      Get the correct URL from the server depending on the role of the system (dev or live)
     *
     * @return
     */

    public static String getServerURL(){

        DataBaseAbstractionFactory dbFactory = new DataBaseAbstractionFactory();
        EnvironmentAbstractionInterface env = dbFactory.getEnvironment();

        switch (env.getRole()) {

            case LIVE:

                return "https://app.slot-america.com";

            case DEV:
                return "https://test.slot-america.com";
            default:
                PukkaLogger.log(LogLevel.ERROR, "Not implemented server for env " + env.getRole() + " using dev...");
                return "https://test.slot-america.com";
        }

    }
}
