package data.dataBaseLayer;

import data.dataBaseLayer.Appengine.AppengineDatastore;
import dataModel.databaseLayer.AbstractKey;
import dataModel.databaseLayer.DBKeyInterface;

/**************************************************************
 *
 *
 */

public class DataBaseAbstractionFactory {

    private static DatabaseAbstractionInterface database = new AppengineDatastore();

    public DatabaseAbstractionInterface getDatabase(){

        return database;
    }

    public DBKeyInterface createKey(Object data){

        DBKeyInterface key;

        try{

            key = database.createKey(data);

        }catch(Exception e){

            key = new AbstractKey((String)data);
        }
        return key;
    }
}
