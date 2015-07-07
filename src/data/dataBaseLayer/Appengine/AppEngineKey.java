package data.dataBaseLayer.Appengine;

import backoffice.errorHandling.LogLevel;
import backoffice.errorHandling.PukkaLogger;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import dataModel.databaseLayer.DBKeyInterface;

public class AppEngineKey implements DBKeyInterface {

    //Two different representations of the key

    private String abstractReference;
    public Key key = null;
    private boolean isEmpty;

    public static final String emptyKeyName = "-empty-";
    public static final AppEngineKey emptyKey = new AppEngineKey();


    private AppEngineKey(){

        isEmpty = true;
    }

    // NOTE: This is only for local use. Not part of the interface.

    public AppEngineKey(Key key){

        this.key = key;
        isEmpty = false;
    }

    public AppEngineKey(String key){

        this.key = KeyFactory.stringToKey(key);

    }

    public AppEngineKey(String ref, boolean isAbstract){

        this.abstractReference = ref;
    }


    public String toString(){

        try{

            if(key == null || isEmpty())
                return emptyKeyName;

            return KeyFactory.keyToString(key);

        }catch(Exception e){

            if(key == null)
                PukkaLogger.log(LogLevel.ERROR, "Error in key-to-string. Key is null");
            else
                PukkaLogger.log(LogLevel.ERROR, "Error in key-to-string. Key is: " + key.toString());
        }
       return "no key - Error";
    }

    /**************************************************************
     *
     *          TODO: This is a bit slow comparing keys. Can it be improved?
     *
     * @param otherKey
     * @return
     */

    public boolean equals(DBKeyInterface otherKey){

        return KeyFactory.keyToString(key).equals(otherKey.toString());
    }

    public String getAbstractReference() {

        return abstractReference;
    }

    public boolean isEmpty() {

        return isEmpty;
    }


    public String getKey(){

        return toString();
    }

}
