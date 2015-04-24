package demo;

import backoffice.errorHandling.BackOfficeException;
import dataModel.condition.ConditionInterface;
import dataModel.databaseLayer.DBKeyInterface;
import dataModel.table.DataObject;
import dataModel.table.DataObjectInterface;

/*********************************************************************''
 *
 *
 *          //TODO: This should be auto generated
 *
 */


public class DemoItem extends DataObject implements DataObjectInterface {

    private static final String TableName = "DemoItem";

    private String name;
    private DBKeyInterface ref;
    private int ordinal;

    public DemoItem(ConditionInterface condition){

        init(DemoItemTable._DATA, DemoItemTable._TABLE);

        //TODO: Not implemented
    }


    public DemoItem(String name, DBKeyInterface ref, int ordinal){

        init(DemoItemTable._DATA, DemoItemTable._TABLE);
        this.name = name;
        this.ref = ref;
        this.ordinal = ordinal;
    }


    public DBKeyInterface store() throws BackOfficeException{

        return super.store(name, ref, ordinal);
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DBKeyInterface getRef() {
        return ref;
    }

    public void setRef(DBKeyInterface ref) {
        this.ref = ref;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(int ordinal) {
        this.ordinal = ordinal;
    }
}
