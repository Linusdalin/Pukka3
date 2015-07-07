package data.dataBaseLayer.RemoteSQL;

import backoffice.errorHandling.BackOfficeException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Linus
 * Date: 2015-06-30
 * Time: 14:44
 * To change this template use File | Settings | File Templates.
 */
public class RemoteSQLObject {


    public String toString(String[] values) {

        StringBuffer string = new StringBuffer();
        string.append("(");

        for (String value : values) {

            string.append(value + " ");
        }

        string.append(")");
        return string.toString();
    }

}
