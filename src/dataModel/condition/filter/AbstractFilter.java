package dataModel.condition.filter;

import com.google.appengine.api.datastore.Query;
import dataModel.databaseLayer.DBKeyInterface;

/**
 * Created with IntelliJ IDEA.
 * User: Linus
 * Date: 2015-04-24
 * Time: 19:46
 * To change this template use File | Settings | File Templates.
 *
 *      TODO: Operator is not implemented
 *
 */
abstract public class AbstractFilter {

    protected String column;
    protected Object value;

    public String getColumn(){ return column;}
    public Object getValue() {

        if(value instanceof DBKeyInterface)
            return ((DBKeyInterface) value).toString();

        // Special case for the appengine implementation. We are representing booleans as strings in the database

        if(value instanceof Boolean)
            return "" + value;

        return value;

    }

}

