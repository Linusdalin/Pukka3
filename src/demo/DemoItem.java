package demo;

import backoffice.errorHandling.BackOfficeException;
import backoffice.errorHandling.PukkaLogger;
import data.dataBaseLayer.DataBaseAbstractionFactory;
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

    // Generated Data object values

    private String m_name;
    private DBKeyInterface m_ref;
    private int m_ordinal;


    public DemoItem(ConditionInterface condition){


        try {

            init(DemoItemTable._STRUCTURE, DemoItemTable._TABLE);
            Object[] values = super.loadElement( condition );

            populate(values);

        } catch (BackOfficeException e) {

            PukkaLogger.log( e );
        }
    }

    public DemoItem(Object[] values){

        init(DemoItemTable._STRUCTURE, DemoItemTable._TABLE);
        populate(values);
    }


    private void populate(Object[] values){

        this.__key = (DBKeyInterface)values[0];

        this.m_name = (String)values[1];
        this.m_ref = new DataBaseAbstractionFactory().createKey(values[2]);
        this.m_ordinal = (Integer)values[3];

    }

    public DemoItem(String name, DBKeyInterface ref, int ordinal){

        init(DemoItemTable._STRUCTURE, DemoItemTable._TABLE);
        this.m_name = name;
        this.m_ref = ref;
        this.m_ordinal = ordinal;
    }

    public void replaceAbstractReference() throws BackOfficeException{

        this.m_ref = lookup(DemoItemTable._STRUCTURE, 1, this.m_ref.toString());

    }

    public DBKeyInterface store() throws BackOfficeException{

        return super.storeElement(m_name, m_ref, m_ordinal);
    }


    public boolean update() throws BackOfficeException{

        return super.updateElement(m_name, m_ref, m_ordinal);
    }

    // Access methods for the private variables

    public String getName() {
        return m_name;
    }

    public void setName(String name) {
        this.m_name = name;
    }

    public DBKeyInterface getRef() {
        return m_ref;
    }

    public void setRef(DBKeyInterface ref) {
        this.m_ref = ref;
    }

    public int getOrdinal() {
        return m_ordinal;
    }

    public void setOrdinal(int m_ordinal) {
        this.m_ordinal = m_ordinal;
    }
}
