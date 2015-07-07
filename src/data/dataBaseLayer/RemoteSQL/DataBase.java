package data.dataBaseLayer.RemoteSQL;

import java.sql.Connection;

/**
 * Created with IntelliJ IDEA.
 * User: Linus
 * Date: 2015-06-30
 * Time: 15:01
 * To change this template use File | Settings | File Templates.
 *
 *      //TODO: This should cache the connection
 *      //TODO: An instance of Database should hold the URL, database and password
 *
 */
public class DataBase {

    Connection connection;

    public DataBase(String url){

        connection = ConnectionHandler.getConnection();

    }

    public Connection getConnection(){

        return connection;
    }
}
