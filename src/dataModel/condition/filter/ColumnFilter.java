package dataModel.condition.filter;

import com.google.appengine.api.datastore.Query;

/**
 * Created with IntelliJ IDEA.
 * User: Linus
 * Date: 2015-04-24
 * Time: 19:45
 * To change this template use File | Settings | File Templates.
 */

public class ColumnFilter extends AbstractFilter implements FilterInterface {


    //TODO: Create a column filter with an operator


    public ColumnFilter(String column, Object value){

        this.column = column;
        this.value = value;

    }

}