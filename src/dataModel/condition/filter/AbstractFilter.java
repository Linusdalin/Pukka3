package dataModel.condition.filter;

import com.google.appengine.api.datastore.Query;
import dataModel.databaseLayer.DBKeyInterface;

/**************************************************************************'
 *
 *          Base functionality for all filters
 *
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

