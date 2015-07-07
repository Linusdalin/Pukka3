package backoffice.style;

/************************************************************************'
 *
 *          A html block is for generating the html code
 */

public class HtmlBlock {

    StringBuffer text;

    public HtmlBlock(){

        text = new StringBuffer();
    }

    public HtmlBlock(String text) {

        this();
        this.text.append(text);
        //To change body of created methods use File | Settings | File Templates.
    }

    public void append(String text){

        this.text.append(text);
    }


    public String render(){

        return text.toString();
    }

    public void append(HtmlBlock htmlBlock) {
        this.text.append(htmlBlock.render());
    }
}
