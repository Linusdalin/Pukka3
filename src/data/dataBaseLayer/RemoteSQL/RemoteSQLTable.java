package data.dataBaseLayer.RemoteSQL;

import backoffice.errorHandling.BackOfficeException;
import backoffice.errorHandling.PukkaLogger;
import backoffice.style.Html;
import slotAmerica.Payment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created with IntelliJ IDEA.
 * User: Linus
 * Date: 2015-06-30
 * Time: 14:48
 * To change this template use File | Settings | File Templates.
 */
public class RemoteSQLTable {

    protected ResultSet resultSet;


    private final String getSQL;
    private final String restriction;
    private final int limit;

    public RemoteSQLTable(String getSQL, String restriction, int limit) {

        this.getSQL = getSQL;
        this.restriction = restriction;
        this.limit = limit;
    }

    /**************************************************************'
     *
     *      Load values from the database into the result set
     *
     *
     */

    public void load() throws BackOfficeException{

        String queryString = getSQL();

        Connection connection = ConnectionHandler.getConnection();

        if(connection == null)
            throw new BackOfficeException(BackOfficeException.Type.SYSTEM, "Could not establish connection ");

        System.out.println("Query: " + queryString);

        try{

            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(queryString);

        }catch(SQLException e){

            PukkaLogger.log( e );
            throw new BackOfficeException(BackOfficeException.Type.SYSTEM, "Error accessing the database");


        }catch(Exception e){

            PukkaLogger.log( e );
            throw new BackOfficeException(BackOfficeException.Type.SYSTEM, "Error accessing the database");
        }
    }


    public String getSQL(){

        String queryString = getSQL + (restriction == null || restriction.equals("") ? "" :" and " + restriction);

        if(limit != -1)
            queryString += " limit " + limit;

        return queryString;

    }





}



