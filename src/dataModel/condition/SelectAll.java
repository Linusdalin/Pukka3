package dataModel.condition;

import backoffice.errorHandling.BackOfficeException;
import com.google.appengine.api.datastore.Key;
import dataModel.databaseLayer.DBKeyInterface;


/**
 * Created with IntelliJ IDEA.
 * User: Linus
 * Date: 2015-04-24
 * Time: 18:58
 * To change this template use File | Settings | File Templates.
 */
public class SelectAll extends Condition implements ConditionInterface{


     public SelectAll(){

     }

    public DBKeyInterface getKey() throws BackOfficeException {

        return null;
    }

    //TODO: Remove this?

    public ConditionInterface getCopy() {

        Condition newCondition = new SelectAll();
        newCondition.sorting = this.sorting;

        newCondition.filters = this.filters;

        return newCondition;

    }

}
