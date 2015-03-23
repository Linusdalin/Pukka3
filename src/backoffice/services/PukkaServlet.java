package backoffice.services;

import backoffice.BackofficeInterface;
import backoffice.BackofficeFactory;
import backoffice.acs.ACSInterface;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * Created with IntelliJ IDEA.
 * User: Linus
 * Date: 2015-03-23
 * Time: 20:21
 * To change this template use File | Settings | File Templates.
 */


public class PukkaServlet extends HttpServlet {

    BackofficeInterface backOffice = BackofficeFactory.getBackoffice();


    protected boolean validateSession(HttpServletRequest request, HttpServletResponse response) throws IOException{

        ACSInterface acsSystem = backOffice.getAcs();

        if(!acsSystem.validate(request)){

            // Fail to validate. Try redirect

            String redirectURL = acsSystem.getLoginRedirectURL(request.getRequestURI() + "&page=oooppps");
            response.sendRedirect(redirectURL);
            response.flushBuffer();
            return false;


        }


        return true;
    }


    protected void logRequest(HttpServletRequest req) {

        //TODO: Not implemented logging request

    }


}
