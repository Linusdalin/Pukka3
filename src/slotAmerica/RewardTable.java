package slotAmerica;

import backoffice.table.JSONTable;

/**
 * Created with IntelliJ IDEA.
 * User: Linus
 * Date: 2015-05-16
 * Time: 12:40
 * To change this template use File | Settings | File Templates.
 */
public class RewardTable extends JSONTable {

    private static final String[] Columns =  {"Type", "Value", "Categories",     "Message", "Id"};
    private static final String[] Ids     =  {"type", "value", "userCategories", "message", "id"};

    private static final String Source     =  "http://localhost:3003/listRewards";


    RewardTable(){

        super(Source, Columns, Ids);

    }
}
