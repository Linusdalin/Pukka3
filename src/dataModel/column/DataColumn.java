package dataModel.column;


import backoffice.errorHandling.BackOfficeException;

/**
 *          DataColumn is the representation of a data object in the database.
 *
 *          To create a data object in the system, we declare the data object
 *          with fields extending a data column
 */

abstract class DataColumn implements ColumnStructureInterface {

    protected String title;
    DisplayFormat format;
    protected ColumnType type;
    boolean isStringValue;
    boolean isNameColumn;

    DataColumn() throws BackOfficeException {

        throw new BackOfficeException( BackOfficeException.Type.NOT_IMPLEMENTED, "This should not happen");
    }


    public DataColumn(String title, DisplayFormat format, ColumnType type) {

        this.title = title;
        this.format = format;
        this.type = type;
    }

    public String getTitle(){

        return title;
    }


    public DisplayFormat getFormat(){

        return format;
    }




    public ColumnStructureInterface setIsNameColumn(){

        isNameColumn = true;
        return this;
    }

    public boolean isNameColumn(){

        return isNameColumn;
    }


    public ColumnType getType() {
        return type;
    }

    public String getName() {
        return title;
    }



}
