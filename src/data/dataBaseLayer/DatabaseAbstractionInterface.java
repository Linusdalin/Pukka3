package data.dataBaseLayer;

import backoffice.errorHandling.BackOfficeException;
import dataModel.column.ColumnStructureInterface;
import dataModel.condition.ConditionInterface;
import dataModel.databaseLayer.DBKeyInterface;
import dataModel.table.DataObject;
import dataModel.table.DataObjectInterface;
import dataModel.table.DataTable;
import dataModel.table.DataTableInterface;

import java.util.List;

/**************************************************************'
 *
 *          Common interface for all database implementations
 */


public interface DatabaseAbstractionInterface {

    // Create a key from an abstract key object (e.g. string or int)
    DBKeyInterface createKey(Object data);


    // Create the table in the database
    boolean createTable(DataTableInterface dataTable);

    // Store an object
    DBKeyInterface store(DataObjectInterface object, Object[] par) throws BackOfficeException;

    DBResultSetInterface load(String tableName, ConditionInterface condition, boolean b) throws BackOfficeException;


    boolean update(DataObjectInterface dataObject, Object[] par) throws BackOfficeException;
}
