package demo;

import backoffice.errorHandling.BackOfficeException;
import backoffice.errorHandling.PukkaLogger;
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


    private String m_name;
    private int m_ordinal;

    public DemoItem2(ConditionInterface condition){


        try {

            init(DemoItem2Table._STRUCTURE, DemoItem2Table._TABLE);
            Object[] values = super.loadElement( condition );

            populate(values);

        } catch (BackOfficeException e) {

            PukkaLogger.log( e );
        }
    }

    public DemoItem2(Object[] values){

        init(DemoItem2Table._STRUCTURE, DemoItem2Table._TABLE);
        populate(values);
    }


    private void populate(Object[] values){

        this.__key = (DBKeyInterface)values[0];

        this.m_name = (String)values[1];
        this.m_ordinal = (Integer)values[2];

    }



    public DemoItem2(String name, int ordinal){

        init(DemoItem2Table._STRUCTURE, DemoItem2Table._TABLE);
        this.m_name = name;
        this.m_ordinal = ordinal;
    }

    public void replaceAbstractReference() throws BackOfficeException{

        // No reference in table
    }



    public DBKeyInterface store() throws BackOfficeException{

        return super.storeElement(m_name, m_ordinal);
    }

    public void load(ConditionInterface condition) throws BackOfficeException{

        Object[] values = super.loadElement( condition );

        this.m_name = (String)values[1];
        this.m_ordinal = (Integer)values[2];

    }

    public boolean update() throws BackOfficeException{

        return super.updateElement(m_name, m_ordinal);
    }


    public String getName() {
        return m_name;
    }

    public void setName(String name) {
        this.m_name = name;
    }


    public int getOrdinal() {
        return m_ordinal;
    }

    public void setOrdinal(int ordinal) {
        this.m_ordinal = ordinal;
    }
}
