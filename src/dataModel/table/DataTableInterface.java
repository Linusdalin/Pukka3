package dataModel.table;

import backoffice.common.BackofficeInterface;
import backoffice.errorHandling.BackOfficeException;
import data.dataBaseLayer.DBResultSetInterface;
import dataModel.condition.ConditionInterface;


/**
 * Created with IntelliJ IDEA.
 * User: Linus
 * Date: 2015-04-21
 * Time: 20:13
 * To change this template use File | Settings | File Templates.
 */
public interface DataTableInterface {

    public static final int FAIL_TO_GENERATE = -1;

    String getTableName();

    int populateDefaultValues();
    int populateTestValues();

    public void load(ConditionInterface condition);


    boolean create();
    boolean replaceSymbolicValues(BackofficeInterface backOffice);

    //DBResultSetInterface loadValues(ConditionInterface condition)throws BackOfficeException;

    DataObjectInterface getItem(ConditionInterface condition);
}
