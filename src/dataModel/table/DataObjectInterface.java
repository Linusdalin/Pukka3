package dataModel.table;

import backoffice.errorHandling.BackOfficeException;
import dataModel.column.ColumnStructureInterface;
import dataModel.databaseLayer.DBKeyInterface;

/**
 * Created with IntelliJ IDEA.
 * User: Linus
 * Date: 2015-04-22
 * Time: 18:47
 * To change this template use File | Settings | File Templates.
 */
public interface DataObjectInterface {


    public DBKeyInterface store() throws BackOfficeException;


    public ColumnStructureInterface[] getStructure();

    String getTableName();
}
