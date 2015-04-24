package data.dataBaseLayer;

import data.dataBaseLayer.Appengine.AppEngineDatastore;
import dataModel.databaseLayer.DBKeyInterface;

/**************************************************************
 *
 *
 */

public class DatabaseAbstractionFactory {

    private static DatabaseAbstractionInterface database = new AppEngineDatastore();

    public DatabaseAbstractionInterface getDatabase(){

        return database;
    }

    public DBKeyInterface createKey(Object data){

        return database.createKey(data);
    }
}
