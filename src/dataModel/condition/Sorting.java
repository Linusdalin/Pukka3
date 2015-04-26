package dataModel.condition;

/**
 * Created with IntelliJ IDEA.
 * User: Linus
 * Date: 2015-04-24
 * Time: 19:03
 * To change this template use File | Settings | File Templates.
 */
public class Sorting {

    public final String column;
    public final Condition.Ordering ordering;

    public Sorting(String column, Condition.Ordering ordering){

        this.column = column;
        this.ordering = ordering;
    }

}
