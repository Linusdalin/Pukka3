package data.dataBaseLayer;

import backoffice.errorHandling.BackOfficeException;
import dataModel.column.ColumnStructureInterface;
import dataModel.databaseLayer.DBKeyInterface;
import dataModel.table.DataObjectInterface;
import dataModel.table.DataTable;

/**************************************************************'
 *
 *          Common interface for all database implementations
 */


public interface DatabaseAbstractionInterface {

    // Create a key from an abstract key object (e.g. string or int)
    DBKeyInterface createKey(Object data);


    // Create the table in the database
    boolean createTable(DataTable dataTable);

    // Store an object
    DBKeyInterface store(DataObjectInterface object, Object[] par) throws BackOfficeException;



}
