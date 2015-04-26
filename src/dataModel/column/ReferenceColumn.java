package dataModel.column;

/**
 *
 *          Reference value column
 *
 */

public class ReferenceColumn extends DataColumn implements ColumnStructureInterface {

    TableReference reference;

    public static final String defaultValue = "- empty -";

    public Object getDefaultValue() {
        return defaultValue;
    }


    public ReferenceColumn(String name, DisplayFormat format, TableReference reference){

        super(name, format, ColumnType.Reference);
        isStringValue = false;
        this.reference = reference;

    }

    public TableReference getTableReference(){

        return reference;
    }


}
