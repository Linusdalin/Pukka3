package backoffice.common;

import backoffice.common.BackofficeInterface;
import demo.DemoBO;
import slotAmerica.SlotAmericaBO;

/**************************************************************
 *
 *          TODO: Figure out how this should be used to support JAR include
 *
 */

public class BackofficeFactory {

    public static BackofficeInterface getBackoffice(){

        //return new DemoBO();
        return new SlotAmericaBO();
    }
}
