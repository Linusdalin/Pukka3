package slotAmerica;

import backoffice.errorHandling.BackOfficeException;
import backoffice.errorHandling.PukkaLogger;
import data.dataBaseLayer.RemoteSQL.RemoteObjectInterface;
import data.dataBaseLayer.RemoteSQL.RemoteSQLObject;

import java.sql.Timestamp;

/***************************************************************
 *
 *              This is the very starting point for the
 *              autonatically generated remote db table
 *
 */


public class Payment extends RemoteSQLObject implements RemoteObjectInterface {

    public final String facebookId;
    public final int amount;
    public final String game;
    public final Timestamp timeStamp;
    public final String promoCode;

    Payment(String facebookId, int amount, String game, Timestamp timeStamp, String promoCode){

        this.facebookId = facebookId;
        this.amount = amount;
        this.game = game;
        this.timeStamp = timeStamp;
        this.promoCode = promoCode;

    }

    public String[] getValues(){

        String[] values = new String[5];

        values[0] = facebookId;
        values[1] = String.valueOf(amount);
        values[2] = game;
        values[3] = timeStamp.toString();
        values[4] = promoCode;

        return values;
    }




    public String toString(){

        return super.toString(getValues());

    }



}
