package dataModel.databaseLayer;

/**
 * Created with IntelliJ IDEA.
 * User: Linus
 * Date: 2015-04-23
 * Time: 09:26
 * To change this template use File | Settings | File Templates.
 */
public class AbstractKey implements DBKeyInterface {

    private String abstractReference;

    public AbstractKey(String abstractReference){

        this.abstractReference = abstractReference;
    }


    public String toString(){

        return abstractReference;
    }
}
