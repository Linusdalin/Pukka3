package backoffice.common;

import backoffice.style.HtmlBlock;

/**
 * Created with IntelliJ IDEA.
 * User: Linus
 * Date: 2015-04-05
 * Time: 16:56
 * To change this template use File | Settings | File Templates.
 */
public class AlertBox {

    private final AlertType type;
    private String message;

    public AlertBox(AlertType type, String message){

        this.type = type;
        this.message = message;
    }

    public HtmlBlock render(){

        return new HtmlBlock(
                "                            <div class=\"alert alert-"+type.getName()+" alert-dismissable\">\n" +
                "                                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>\n" +
                "                                "+ message+"\n" +
                "                            </div>\n");
    }
}
