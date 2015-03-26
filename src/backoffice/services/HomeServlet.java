package backoffice.services;

import backoffice.common.BackofficeInterface;
import backoffice.common.BackofficeFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 *              Servlet to redirect to a specific landing page (index.html)
 *
 */

public class HomeServlet extends PukkaServlet {

    private static BackofficeInterface backOffice = BackofficeFactory.getBackoffice();


    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws IOException {



        System.out.println("In home servlet. Redirecting to " + backOffice.getWelcomePage().getName());

        resp.sendRedirect("/page?page=" + backOffice.getWelcomePage().getName());
        resp.flushBuffer();
    }
}
