package backoffice.acs;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import javax.servlet.http.HttpServletRequest;

/***************************************************************************
 * 
 *              Google SSO Access control
 * 
 * 
 */


public class GoogleACS implements ACSInterface {
    
    private static final String Name = "Google ACS";
    private static final ACSUser DummyUser = new ACSUser("dummy", "linusdalin@gmail.com");

    // Google user service
    private static UserService userService = UserServiceFactory.getUserService();
    private ACSUser activeUser = null;

    public GoogleACS(){

    }

    /************************************************************''''
     *
     *          Login is not used in a SSO
     *
     *
     * @param user            -N/A
     * @param password        -N/A
     * @return                -N/A
     */

    public String login(String user, String password) {

        throw new RuntimeException("Login should not be used in a SSO implementation");
    }

    /********************************************************************
     *
     *          Validate the request
     *
     *          In a SSO situation, this is done by redirecting to an external login page
     *
     * @param request         - servlet request
     * @return                - validated or not
     */


    public boolean validate(HttpServletRequest request) {

        System.out.println(Name + ": Validating Google session");

        if (request.getUserPrincipal() == null) {

            return false;
        }

        //TODO: Not implemented list of users. Only dummy user

        if(!DummyUser.email.equals(request.getUserPrincipal().getName())){

            return false;

        }

        // Access granted. Create a new user with email as name (Typical Google login account)

        activeUser = new ACSUser(request.getUserPrincipal().getName(), request.getUserPrincipal().getName());
        return true;
    }

    /****************************************************************
     *
     *          Logout not used in a SSO
     *
     * @param sessionToken     -N/A
     */

    public void logout(String sessionToken) {

        throw new RuntimeException("Logout should not be used in a SSO implementation");
    }

    /****************************************************************
     *
     *              Get the active user stored from the validate redirect
     *
     * @return
     */

    public ACSUser activeUser() {

        System.out.println(Name + ": Returning active user");
        return activeUser;
    }


    /*************************************************************
     *
     *              Redirect to login page
     *
     * @param thisURL        - this page (for coming back from the redirect)
     * @return               - URL
     */

    public String getLoginRedirectURL(String thisURL) {

        return userService.createLoginURL(thisURL);
    }

    /*************************************************************
     *
     *              Redirect to logout page
     *
     * @param thisURL        - this page (for coming back from the redirect)
     * @return               - URL
     */


    public String getLogoutRedirectURL(String thisURL){

        return userService.createLogoutURL(thisURL);
    }

}
