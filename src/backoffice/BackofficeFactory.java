package backoffice;

import demo.DemoBO;

/**
 * Created with IntelliJ IDEA.
 * User: Linus
 * Date: 2015-03-21
 * Time: 22:13
 * To change this template use File | Settings | File Templates.
 */
public class BackofficeFactory {

    public static BackofficeInterface getBackoffice(){

        return new DemoBO();
    }
}
