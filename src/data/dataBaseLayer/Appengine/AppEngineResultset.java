package data.dataBaseLayer.Appengine;

import backoffice.errorHandling.BackOfficeException;
import backoffice.errorHandling.LogLevel;
import backoffice.errorHandling.PukkaLogger;
import com.google.appengine.api.datastore.DatastoreNeedIndexException;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.KeyFactory;
import data.dataBaseLayer.DBResultSetInterface;
import dataModel.column.ColumnStructureInterface;
import dataModel.databaseLayer.DBKeyInterface;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: Linus
 * Date: 2015-04-25
 * Time: 19:53
 * To change this template use File | Settings | File Templates.
 */
public class AppEngineResultSet implements DBResultSetInterface {

    Iterator i;
    Iterable<Entity> entities;
    private String tableName;
    private boolean useReferences;

    private static final String  Default_stringValue = "-empty-";
    private static final int     Default_intValue = 0;
    private static final String  Default_dateValue = "1901-01-01 00:00:00";



    public AppEngineResultSet(Iterable<Entity> entities, String tableName, boolean useReferences) {

        this.entities = entities;
        this.tableName = tableName;
        this.useReferences = useReferences;
        i = entities.iterator();
    }

    public Object[] getNext(ColumnStructureInterface[] structure) throws BackOfficeException {

        try{


            if (i.hasNext()){

                Entity entity = (Entity)i.next();

                Object[] data = parseEntity(tableName, entity, structure, useReferences);
                data[0] = new AppEngineKey(entity.getKey());

                return data;
            }
            else
                return null;

        }catch(DatastoreNeedIndexException e){

            PukkaLogger.log(LogLevel.FATAL, "Index missing in table " + tableName + ": " + e.getMessage());
            throw new BackOfficeException(BackOfficeException.Type.GENERIC, "Internal Database Error");

        }

    }

    public boolean hasNext() {

        return i.hasNext();
    }


    protected Object[] parseEntity(String tableName, Entity entity, ColumnStructureInterface[] columns, boolean useReferences) throws BackOfficeException {

        Object[] columnData = new Object[columns.length + 1];   // Add space for the kay;

        int index = 1;

        for(ColumnStructureInterface column : columns){

            Object property = entity.getProperty(column.getName());

            if(property == null){

                property = defaultColumnValue(column);
                useReferences = false;
            }

            //PukkaLogger.log(PukkaLogger.Level.INFO, "Property: " + property + " of type " + column.getType().name() + " for column " + column.getName());

            try{

                switch(column.getType()){

                     case String:

                         columnData[index++] = decodeFromDB((String) property);
                         break;

                     case Reference:

                         DBKeyInterface key;

                             try{

                                 if(useReferences){

                                     columnData[index++] = new AppEngineKey(KeyFactory.stringToKey((String) property));

                                 }else{

                                     //Abstract key represented as a string
                                     columnData[index++] = (String) property;

                                 }

                             }catch(IllegalArgumentException e){

                                 PukkaLogger.log(LogLevel.FATAL, " Error: Not a key \"" + (String) property + "\" in column " + column.getName() + " of table " + tableName);
                                 throw new BackOfficeException(BackOfficeException.Type.GENERIC, "Error: Not a key \"" + (String)property + "\" in column " + column.getName() + " of table " + tableName);
                             }

                         break;

                     case Int:

                            columnData[index++] = ((Long)property).intValue();
                         break;


                     default:
                         throw new BackOfficeException(BackOfficeException.Type.GENERIC, "Unknown Column type " + column.getType());
                 }

            }catch(ClassCastException e){


                throw new BackOfficeException(BackOfficeException.Type.GENERIC, "Error for column " + column.getName() + " " + e.getMessage());

            }
        }

        return columnData;
    }

    private Object defaultColumnValue(ColumnStructureInterface column) {

        Object value = column.getDefaultValue();

        if(value == null){

            switch (column.getType()) {


                case String:

                    return Default_stringValue;

                case Int:

                    return Default_intValue;

                case Reference:

                    break;
            }

        }

        return value;

    }


    /********************************************************************
     *
     *          String escaping
     *          This is done for all strings that are read FROM the database
     *
     * @param data - string to escape
     * @return
     *
     *          //TODO: Optimize this with a loop
     */

    public static String decodeFromDB(String data){

        if(data == null)
                return null;

        data = data.replace("&#39;", "'");
        data = data.replace("\\n", "\n");
        data = data.replace("&#34;", "\"");
        return data;
    }

    /********************************************************************
     *
     *          String escaping
     *          This is done for all strings that are written TO the database
     *
     * @param data - string to escape
     * @return

     *          //TODO: Optimize this with a loop

     */

    public static String encodeToDB(String data){

        if(data == null)
                return null;

        data = data.replace("\n", "\\n");
        data = data.replace("\"", "&#34;");
        data = data.replace("'", "&#39;");


        return data;
    }



}
