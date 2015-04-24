package dataModel.column;

/**
 *
 *          String value column
 *
 */

public class StringColumn extends DataColumn implements ColumnStructureInterface {

    public StringColumn(String name, DisplayFormat format){

        super(name, format, ColumnType.String);
        isStringValue = true;


    }

}

