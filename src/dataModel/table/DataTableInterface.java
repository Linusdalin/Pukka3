package dataModel.table;

/**
 * Created with IntelliJ IDEA.
 * User: Linus
 * Date: 2015-04-21
 * Time: 20:13
 * To change this template use File | Settings | File Templates.
 */
public interface DataTableInterface {

    public static final int FAIL_TO_GENERATE = -1;

    String getTableName();

    int populateDefaultValues();
    int populateTestValues();

    boolean create();
}
