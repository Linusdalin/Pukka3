package dataModel.column;

/**
 *
 *          Int value column
 *
 */

public class IntColumn extends DataColumn implements ColumnStructureInterface {

    public IntColumn(String name, DisplayFormat format){

        super(name, format, ColumnType.Int);
        isStringValue = false;

    }
}

