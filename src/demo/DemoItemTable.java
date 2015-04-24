package demo;

import data.dataBaseLayer.Appengine.AppEngineKey;
import dataModel.column.*;
import dataModel.databaseLayer.AbstractKey;
import dataModel.table.DataObjectInterface;
import dataModel.table.DataTable;
import dataModel.table.DataTableInterface;


/********************************************************
 *
 *    ContractAnnotation - Data Table
 *    Automatically generated file by GenerateTable.java
 *
 *
 */

public class DemoItemTable extends DataTable implements DataTableInterface {

    private static final String _TITLE = "Demo Table";
    public static final String _TABLE = "demo";
    private static final String _DESCRIPTION = "Just a test";

    public enum Columns {Name, Fragment, Ordinal }

    public static final ColumnStructureInterface[] _DATA = new ColumnStructureInterface[] {

            new StringColumn("Name",        DisplayFormat.REGULAR),
            new ReferenceColumn("Fragment", DisplayFormat.REGULAR, new TableReference(DemoItem2Table._TABLE, DemoItem2Table.Columns.Name.name())),
            new IntColumn("Ordinal",        DisplayFormat.REGULAR),
    };

    public DemoItemTable(){

        init(_DATA, _TABLE, _TITLE, _DESCRIPTION, _DefaultValues, _TestValues);
    }

    private static final DataObjectInterface[] _DefaultValues = {

            new DemoItem("default Value", new AbstractKey("demo2"), 42),
    };


    private static final  DataObjectInterface[] _TestValues = {


            new DemoItem("test Value", new AbstractKey("demo2"), 17),



    };


    /* Code below this point will not be replaced when regenerating the file*/

    /*__endAutoGenerated*/



}
