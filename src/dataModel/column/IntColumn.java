package dataModel.column;

/**
 *
 *          Int value column
 *
 */

public class IntColumn extends DataColumn implements ColumnStructureInterface {

    public static final int defaultValue = 0;

    public Object getDefaultValue() {
        return defaultValue;
    }

    public IntColumn(String name, DisplayFormat format){

        super(name, format, ColumnType.Int);
        isStringValue = false;

    }

}

