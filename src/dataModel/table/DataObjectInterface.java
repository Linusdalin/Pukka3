package dataModel.table;

import backoffice.errorHandling.BackOfficeException;
import dataModel.column.ColumnStructureInterface;
import dataModel.databaseLayer.DBKeyInterface;

/****************************************************************************'
 *
 *          Interface for all data objects
 *
 */


public interface DataObjectInterface {

    DBKeyInterface store() throws BackOfficeException;
    boolean update() throws BackOfficeException;


    ColumnStructureInterface[] getStructure();
    public void replaceAbstractReference() throws BackOfficeException;


    String getTableName();

    DBKeyInterface getKey();

    boolean exists();
}
