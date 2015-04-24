package demo;

import backoffice.errorHandling.BackOfficeException;
import dataModel.condition.ConditionInterface;
import dataModel.databaseLayer.DBKeyInterface;
import dataModel.table.DataObject;
import dataModel.table.DataObjectInterface;

/**
 *
 * Created with IntelliJ IDEA.
 * User: Linus
 * Date: 2015-04-21
 * Time: 21:01
 * To change this template use File | Settings | File Templates.
 */
public class DemoItem2 extends DataObject implements DataObjectInterface {


    private String name;
    private int ordinal;

    public DemoItem2(ConditionInterface condition){

        init(DemoItem2Table._DATA, DemoItem2Table._TABLE);
        //TODO: Not implemented
    }


    public DemoItem2(String name, int ordinal){

        init(DemoItem2Table._DATA, DemoItem2Table._TABLE);
        this.name = name;
        this.ordinal = ordinal;
    }


    public DBKeyInterface store() throws BackOfficeException{

        return super.store(name, ordinal);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(int ordinal) {
        this.ordinal = ordinal;
    }
}
