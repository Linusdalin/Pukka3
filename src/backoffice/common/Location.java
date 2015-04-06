package backoffice.common;

/**
 * Created with IntelliJ IDEA.
 * User: Linus
 * Date: 2015-04-03
 * Time: 17:09
 * To change this template use File | Settings | File Templates.
 */
public class Location {

    public String page;
    public String tab;

    public Location(String page){

        this(page, "");
    }


    public Location(String page, String tab){

        this.page = page;
        this.tab = tab;
    }
}
