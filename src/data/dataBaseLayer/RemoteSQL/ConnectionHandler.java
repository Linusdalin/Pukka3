package data.dataBaseLayer.RemoteSQL;

import java.sql.Connection;
import java.sql.DriverManager;


/********************************************************************
 * Created with IntelliJ IDEA.
 * User: Linus
 * Date: 2015-04-10
 * Time: 13:33
 * To change this template use File | Settings | File Templates.
 */

public class ConnectionHandler {

    //TODO: Configure the access with the URL
    //TODO: cache connections to reuse

    public static Connection getConnection(){

        Connection connection = null;

        try{

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://db.slot-america.com:3306/slotamerica", "linus", "KqgiC84Jwf$#");

        }catch(Exception e){

            e.printStackTrace(System.out);

        }
        return connection;
    }

}
