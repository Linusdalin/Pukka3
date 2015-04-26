package dataModel.column;

import dataModel.table.DataTableInterface;

/**
 * Created with IntelliJ IDEA.
 * User: Linus
 * Date: 2015-04-21
 * Time: 20:27
 * To change this template use File | Settings | File Templates.
 */
public class TableReference {

    private final String tableName;
    private final String column;

    public TableReference(String tableName, String column) {

        //To change body of created methods use File | Settings | File Templates.
        this.tableName = tableName;
        this.column = column;
    }

    public String getTableName() {
        return tableName;
    }

    public String getColumn() {
        return column;
    }
}
