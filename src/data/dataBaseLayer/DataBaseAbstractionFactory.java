package data.dataBaseLayer;

import data.dataBaseLayer.Appengine.AppEngineEnvironment;
import data.dataBaseLayer.Appengine.AppengineDatastore;
import data.dataBaseLayer.SQLData.SQLDatastore;
import data.dataBaseLayer.SQLData.SQLEnvironment;
import dataModel.databaseLayer.AbstractKey;
import dataModel.databaseLayer.DBKeyInterface;

/**************************************************************
 *
 *
 *          The abstraction factory privides two interfaces:
 *
 *           - DatabaseAbstractionInterface to provide access to the database
 *           - EnvironmentAbstractionInterface to access environment specific functionality
 *
 */

public class DataBaseAbstractionFactory {

    private static DatabaseAbstractionInterface database = new SQLDatastore();
    private static EnvironmentAbstractionInterface environment = new SQLEnvironment();

    public DatabaseAbstractionInterface getDatabase(){

        return database;
    }

    public EnvironmentAbstractionInterface getEnvironment(){

        return environment;
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
