package backoffice.lightbox;

import backoffice.common.LinkType;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: Linus
 * Date: 2015-03-26
 * Time: 19:12
 * To change this template use File | Settings | File Templates.
 *
 *          //TODO: Make a simple static modal
 */
public interface LightBoxInterface {


    String renderAnchor();
    String renderLink(LinkType type, String anchorText);
    String renderContent(HttpServletRequest request);
    String getName();
}
