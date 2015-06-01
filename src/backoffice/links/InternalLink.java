package backoffice.links;

import backoffice.pages.PageInterface;

/**
 * Created with IntelliJ IDEA.
 * User: Linus
 * Date: 2015-05-21
 * Time: 11:13
 * To change this template use File | Settings | File Templates.
 */
public class InternalLink {


    private String url;

    public InternalLink(String url){

        this.url = url;
    }

    public InternalLink(PageInterface page){

        this.url = "page?page="+page.getName();
    }


    public String render(String anchorText){

        return "<a href=\""+url+"\">" + anchorText + "</a>";
    }

    public String getURL() {
        return url;
    }
}
