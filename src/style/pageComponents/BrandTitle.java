package style.pageComponents;

import backoffice.BackofficeInterface;

/**
 * Created with IntelliJ IDEA.
 * User: Linus
 * Date: 2015-03-22
 * Time: 12:23
 * To change this template use File | Settings | File Templates.
 */
public class BrandTitle {

    private BackofficeInterface backoffice;

    public BrandTitle(BackofficeInterface backoffice){

        this.backoffice = backoffice;
    }


    public String render(){

        return
                "                <a class=\"navbar-brand\" href=\"/home\">"+ backoffice.getSystemTitle()+"</a>\n";

    }
}
