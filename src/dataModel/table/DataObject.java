package dataModel.table;

import backoffice.common.BackofficeFactory;
import backoffice.common.BackofficeInterface;
import backoffice.errorHandling.BackOfficeException;
import data.dataBaseLayer.DBResultSetInterface;
import data.dataBaseLayer.DataBaseAbstractionFactory;
import data.dataBaseLayer.DatabaseAbstractionInterface;
import dataModel.column.ColumnStructureInterface;
import dataModel.column.ReferenceColumn;
import dataModel.condition.ConditionInterface;
import dataModel.condition.SelectAll;
import dataModel.condition.filter.ColumnFilter;
import dataModel.databaseLayer.DBKeyInterface;

/********************************************************
 *
 *
 *          Generic
 *
 */

abstract public class DataObject implements DataObjectInterface{

    // Database implementation
    private DatabaseAbstractionInterface database;
    private ColumnStructureInterface[] structure;
    private String tableName;
    private boolean exists = false;

    protected DBKeyInterface __key = null;


    protected void init(ColumnStructureInterface[] structure, String tableName){

        this.structure = structure;
        this.tableName = tableName;
        database = new DataBaseAbstractionFactory().getDatabase();

    }

    protected Object[] loadElement(ConditionInterface condition) throws BackOfficeException{


            DBResultSetInterface rs = database.load(tableName, condition, true);
            Object[] result = rs.getNext(structure);

            if(result == null){
                exists = false;
            }
            else{

                exists = true;
                __key = (DBKeyInterface)result[0];
            }



        return result;

    }

    protected DBKeyInterface lookup(ColumnStructureInterface[] structure, int i, String field) throws BackOfficeException{

        BackofficeInterface backOffice = BackofficeFactory.getBackoffice();

        String otherTableName = ((ReferenceColumn) structure[i]).getTableReference().getTableName();

        DataTableInterface otherTable = backOffice.getTableByName(otherTableName);

        DataObjectInterface object = otherTable.getItem(new SelectAll().addFilter(new ColumnFilter(structure[i].getName(), field)));

        return object.getKey();
    }


    /******************************************************************''
     *
     *          The generic store function, taking a variable number of arguments
     *          and adds the current data object structure to allow the database
     *          to parse the data accordingly
     *
     *
     * @param data     - values
     * @return
     * @throws BackOfficeException
     */




    protected DBKeyInterface storeElement(Object... data) throws BackOfficeException{

        return database.store(this, data);
    }

    protected boolean updateElement(Object... data) throws BackOfficeException{

        return database.update(this, data);
    }

    public ColumnStructureInterface[] getStructure() {
        return structure;
    }

    public String getTableName() {
        return tableName;
    }

    public boolean exists(){

        return exists;
    }

    public DBKeyInterface getKey(){

        return __key;
    }

}
