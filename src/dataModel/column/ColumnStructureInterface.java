package dataModel.column;

/*******************************************************************'''''
 *
 *              Common interface for all columns
 */


public interface ColumnStructureInterface {


    public String getTitle();

    public DisplayFormat getFormat();

    public ColumnType getType();

    public ColumnStructureInterface setIsNameColumn();

    public boolean isNameColumn();

    String getName();

    Object getDefaultValue();
}
