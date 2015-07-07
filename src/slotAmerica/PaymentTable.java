package slotAmerica;

import backoffice.errorHandling.BackOfficeException;
import backoffice.errorHandling.PukkaLogger;
import backoffice.style.Html;
import backoffice.style.HtmlBlock;
import backoffice.table.StaticTable;
import data.dataBaseLayer.RemoteSQL.RemoteObjectInterface;
import data.dataBaseLayer.RemoteSQL.RemoteSQLTable;
import java.sql.*;

/**************************************************************'
 *
 *          This is the compound SQL table for payments
 *
 *          It is a remoteSQL table, hosted in another database
 *
 */
public class PaymentTable extends RemoteSQLTable {

    private static final String getSQL =
            "select sessions.playerid, amount, game, timestamp, promocode" +
            "     from payments, sessions " +
            "     where sessions.sessionId = payments.sessionId ";



    public PaymentTable(String  restriction, int limit){

        super(getSQL, restriction, limit);
    }

    public PaymentTable(){

        this("", -1);
    }

    /******************************************************************************
     *
     *      Gets the next object
     *
     * @return
     */


    public Payment getNext() throws BackOfficeException{

        if(resultSet == null)
            throw new BackOfficeException(BackOfficeException.Type.CONFIGURATION, "There is no result from loading table in database");

        try {
            if(!resultSet.next())
                return null;

            return new Payment(resultSet.getString(1), resultSet.getInt(2),resultSet.getString(3),resultSet.getTimestamp(4),resultSet.getString(5));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    //TODO: We really want this to be generic


    public HtmlBlock render(){

        try {


            load();

            StaticTable displayTable = new StaticTable("DaTable", new String[] {"Amount", "Game", "Time" }, new int[] { 1, 2, 3});


            RemoteObjectInterface p = this.getNext();

            while(p != null){

                displayTable.addRow(p.getValues());
                p = this.getNext();

            }


            return displayTable.toHtml();

        } catch (BackOfficeException e) {
            PukkaLogger.log( e );
        }

        return new HtmlBlock(Html.paragraph("Error rendering table"));

    }


    public String renderOld() {

        StringBuffer tableContent = new StringBuffer();

        try{

            load();

            tableContent.append(
                            "<div class=\"dataTable_wrapper\">\n" +
                                    "                                <table class=\"table table-striped table-bordered table-hover\" id=\"dataTables-example\">\n" +
                                    "                                    <thead>\n" +
                                    "                                        <tr>\n" +
                                    "                                            <th>Rendering engine</th>\n" +
                                    "                                            <th>Browser</th>\n" +
                                    "                                            <th>Platform(s)</th>\n" +
                                    "                                            <th>Engine version</th>\n" +
                                    "                                            <th>CSS grade</th>\n" +
                                    "                                            <th>CSS grade</th>\n" +
                                    "                                        </tr>\n" +
                                    "                                    </thead>\n" +
                                    "                                    <tbody>\n"
            );


            RemoteObjectInterface p = this.getNext();

            while(p != null){

                tableContent.append(p.toString());
                p = this.getNext();

            }

        }catch(BackOfficeException e){
            PukkaLogger.log( e );
        }


        tableContent.append(                        "                                    </tbody>\n" +
                                "                                </table>\n" +
                                "                            </div>" +
                                        "    <script>\n" +
                                        "    $(document).ready(function() {\n" +
                                        "        $('#dataTables-example').DataTable({\n" +
                                        "                responsive: true\n" +
                                        "        });\n" +
                                        "    });\n" +
                                        "    </script>\n"
        );




        return tableContent.toString();

    }


}
