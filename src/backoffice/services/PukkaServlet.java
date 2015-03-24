package backoffice.services;

import backoffice.BackofficeInterface;
import backoffice.BackofficeFactory;
import backoffice.acs.ACSInterface;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

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

            String redirectURL = acsSystem.getLoginRedirectURL(request.getRequestURI());
            System.out.println("Redirecting to " + redirectURL);
            response.sendRedirect(redirectURL);
            response.flushBuffer();
            return false;


        }


        return true;
    }


    /**************************************************************************************
     *
     *          Logging the actual raw request to make it easy to review and understand what happened.
     *
     * @param request - http request
     *
     */


    protected void logRequest(HttpServletRequest request) {

        Enumeration pars = request.getParameterNames();
        StringBuffer logString = new StringBuffer();
        while(pars != null && pars.hasMoreElements()){

            String parameterName = (String)pars.nextElement();
            logString.append( parameterName + " - "+(request.getParameter(parameterName)).toString() + " ");
        }

        System.out.println( request.getMethod() + "-request " + request.getRequestURI() + " Parameters: " + logString);
    }



}
