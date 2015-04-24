package dataModel.table;

import backoffice.errorHandling.BackOfficeException;
import data.dataBaseLayer.DatabaseAbstractionFactory;
import data.dataBaseLayer.DatabaseAbstractionInterface;
import dataModel.column.ColumnStructureInterface;
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

    protected void init(ColumnStructureInterface[] structure, String tableName){

        this.structure = structure;
        this.tableName = tableName;
        database = new DatabaseAbstractionFactory().getDatabase();

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



    protected DBKeyInterface store(Object... data) throws BackOfficeException{

        return database.store(this, data);
    }


    public ColumnStructureInterface[] getStructure() {
        return structure;
    }

    public String getTableName() {
        return tableName;
    }
}
