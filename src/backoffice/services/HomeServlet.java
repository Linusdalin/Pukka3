package backoffice.services;

import backoffice.BackofficeInterface;
import backoffice.BackofficeFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 *              Servlet to redirect to a specific landing page (index.html)
 *
 */

public class HomeServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws IOException {

        BackofficeInterface backOffice = BackofficeFactory.getBackoffice();

        System.out.println("In home servlet. Redirecting to " + backOffice.getWelcomePage().getName());

        resp.sendRedirect("/page?page=" + backOffice.getWelcomePage().getName());
    }
}
