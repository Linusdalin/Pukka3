package data.dataBaseLayer;

import backoffice.errorHandling.BackOfficeException;
import dataModel.column.ColumnStructureInterface;

/**
 * Created with IntelliJ IDEA.
 * User: Linus
 * Date: 2015-04-25
 * Time: 19:53
 * To change this template use File | Settings | File Templates.
 */

public interface DBResultSetInterface {

    public Object[] getNext(ColumnStructureInterface[] structure) throws BackOfficeException;

    boolean hasNext();
}
