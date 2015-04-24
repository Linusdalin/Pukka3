package dataModel.table;

import backoffice.errorHandling.BackOfficeException;
import backoffice.errorHandling.LogLevel;
import backoffice.errorHandling.PukkaLogger;
import data.dataBaseLayer.DatabaseAbstractionFactory;
import data.dataBaseLayer.DatabaseAbstractionInterface;
import dataModel.column.ColumnStructureInterface;
import dataModel.databaseLayer.DBKeyInterface;

/************************************************************************
 *
 *                  Base functionality for all tables
 *
 */


abstract public class DataTable implements DataTableInterface {

    private DatabaseAbstractionInterface _database;
    private DataObjectInterface[] _defaultValues;
    private String _title;
    private String _name;
    private DataObjectInterface[] _testValues;


    protected void init(ColumnStructureInterface[] data, String table, String title, String description, DataObjectInterface[] defaultValues, DataObjectInterface[] testValues) {

        _database = new DatabaseAbstractionFactory().getDatabase();

        this._title = title;
        this._defaultValues = defaultValues;
        this._testValues = testValues;

        this._name = table;
    }


    /*****************************************************************
     *
     *      Remove all values and create a new table.
     *
     * @throws BackOfficeException
     */

    public boolean create() {

        return _database.createTable(this);

    }

    public String getTableName(){

        return _title;
    }

    public int populateDefaultValues(){

        return populate(_defaultValues);
    }

    public int populate(DataObjectInterface[] _defaultValues){

        try {

            for (DataObjectInterface defaultValue : this._defaultValues) {

                DBKeyInterface key =  defaultValue.store();
                if(key == null){

                    PukkaLogger.log(LogLevel.FATAL, " Error storing value in database for table " + getTableName());
                    return FAIL_TO_GENERATE;
                }
            }

        } catch (BackOfficeException e) {

            PukkaLogger.log( e );
            return FAIL_TO_GENERATE;
        }


        return this._defaultValues.length;
    }

    public int populateTestValues(){

        return populate(_testValues);
    }


}
