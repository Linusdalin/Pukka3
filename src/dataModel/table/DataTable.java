package dataModel.table;

import backoffice.common.BackofficeInterface;
import backoffice.errorHandling.BackOfficeException;
import backoffice.errorHandling.LogLevel;
import backoffice.errorHandling.PukkaLogger;
import data.dataBaseLayer.DBResultSetInterface;
import data.dataBaseLayer.DataBaseAbstractionFactory;
import data.dataBaseLayer.DatabaseAbstractionInterface;
import dataModel.column.ColumnStructureInterface;
import dataModel.condition.ConditionInterface;
import dataModel.databaseLayer.DBKeyInterface;

import java.util.ArrayList;
import java.util.List;

/************************************************************************
 *
 *                  Base functionality for all tables
 *
 */


abstract public class DataTable implements DataTableInterface {


    private ColumnStructureInterface[] structure;
    private DatabaseAbstractionInterface _database;
    private DataObjectInterface[] _defaultValues;
    private String _title;
    private String _name;
    private DataObjectInterface[] _testValues;
    private boolean _isSymbolic = false;

     // Current values in the list
    protected List<DataObjectInterface> _loadedValues = new ArrayList<DataObjectInterface>();

    protected void init(ColumnStructureInterface[] structure, String table, String title, String description, DataObjectInterface[] defaultValues, DataObjectInterface[] testValues) {

        this.structure = structure;

        _database = new DataBaseAbstractionFactory().getDatabase();

        this._defaultValues = defaultValues;
        this._testValues = testValues;

        this._name = table;
        this._title = title;
    }


    /*****************************************************************
     *
     *      Remove all values and create a new table.
     *
     * @throws BackOfficeException
     */

    public boolean create() {

        _isSymbolic = true;
        return _database.createTable(this);

    }

    public DBResultSetInterface loadValues(ConditionInterface condition) throws BackOfficeException{

        return  _database.load(_name, condition, !_isSymbolic);
    }

    /*************************************************************************
     *
     *
     *           If the table has references, we have to go through it and
     *           update all symbolic values with the appropriate key.
     *
     *           All values are already loaded before the call
     *
     * @param backOffice       - the backOffice structure for dereferencing
     * @return                 - tru if everything is ok
     */

    public boolean replaceSymbolicValues(BackofficeInterface backOffice) {

        PukkaLogger.log(LogLevel.INFO, "Replacing symbolic references in table " + _name + " with " + _loadedValues.size() + " values");

        for (DataObjectInterface value : _loadedValues) {

            try {

                value.replaceAbstractReference();
                value.update();

            } catch (BackOfficeException e) {

                PukkaLogger.log( e );
                return false;
            }

        }

        return true;

    }


    public String getTableName(){

        return _name;
    }

    public String getTitle(){

        return _title;
    }


    public int populateDefaultValues(){

        System.out.println("   --- " + _defaultValues.length + " values");
        return populate(_defaultValues);
    }

    /*****************************************************
     *
     *      Populate is done with default and test values
     *
     * @param values
     * @return
     */


    public int populate(DataObjectInterface[] values){

        try {

            for (DataObjectInterface defaultValue : values) {

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

        System.out.println("   --- " + _testValues.length + " values");
        return populate(_testValues);
    }


    public List<DataObjectInterface> getValues() {

        return _loadedValues;
    }
}
