package backoffice.acs;

import javax.servlet.http.HttpServletRequest;

/***************************************************************************
 *
 *              Very simple ACS implementation ignoring username/password
 *
 *
 */


public class OpenDoorACS implements ACSInterface {

    private static final String Name = "Open Door ACS";
    private static final String DummyToken = "DummyToken";
    private static final ACSUser DummyUser = new ACSUser("dummy", "dummy@dev.null");


    public String login(String user, String password) {

        System.out.println(Name + ": Allowing login without checking user/password");
        return DummyToken;
    }

    public boolean validate(HttpServletRequest request) {

        System.out.println(Name + ": Blindly ignoring validate token");
        return true;
    }

    public void logout(String sessionToken) {

        System.out.println(Name + ": Ignoring logout");
    }

    public ACSUser activeUser() {

        System.out.println(Name + ": Returning dummy user");
        return DummyUser;
    }

    public String getLoginRedirectURL(String returnURL) {
        return null;
    }

    public String getLogoutRedirectURL(String returnURL){

        return "#";
    }


}
