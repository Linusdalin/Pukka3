package backoffice.acs;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: Linus
 * Date: 2015-03-23
 * Time: 19:23
 * To change this template use File | Settings | File Templates.
 */
public interface ACSInterface {


    String login(String user, String password);
    boolean validate(HttpServletRequest request);
    void logout(String sessionToken);
    ACSUser activeUser();
    String getLoginRedirectURL(String returnURL);
    String getLogoutRedirectURL(String returnURL);
}
