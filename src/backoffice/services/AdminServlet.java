package backoffice.services;

import dataModel.condition.SelectAll;
import dataModel.condition.filter.ColumnFilter;
import demo.DemoItem;
import demo.DemoItemTable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/*************************************************************************'''
 *
 *              Admin Servlet
 *
 *              This uses Google accounts for access control
 */

public class AdminServlet extends PukkaServlet {


    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws IOException {

             // Get the application to be able to set different actions

        String action = req.getParameter("Action");
        String message = req.getParameter("Message");

        if(action != null){

            if(action.equals("CREATE")){

                boolean success = backOffice.createDB();
                if(success)
                    message = "Database Created";
                else
                    message = "Failed to create Database";
            }
            else if(action.equals("CONSTANTS")){

                boolean success = backOffice.populateValues(false);
                if(success)
                    message = "Added constants";
                else
                    message = "Failed to add constants";
            }
            else if(action.equals("TESTDATA")){

                boolean success = backOffice.populateValues(true);
                if(success)
                    message = "Added constants and test values";
                else
                    message = "Failed to add constants and test values";
            }
            else if(action.equals("TEST")){

                DemoItem test = new DemoItem(new SelectAll().addFilter(new ColumnFilter(DemoItemTable.Columns.Name.name(), "test Value")));
                if(test.exists())
                    message = "exist. Ordinal=" + test.getOrdinal() ;
                else
                    message = "not found :-(";

            }
            else message = "Action " + action + " not implemented";

        }

        String heading = "Pukka3 setup admin control";
        String bgColour = "#EEEEEE";


        resp.getWriter().println("<html>");
        resp.getWriter().println("<body bgColor=\""+bgColour+"\">");
        resp.getWriter().println("<h1>"+ heading +"</h1>");

        // TODO: Check access right


        if(message != null)
            resp.getWriter().println("<p>"+ message + "</p>");

        resp.getWriter().println("<a href=\"?Action=CREATE\">Create Database</a><br>");
        resp.getWriter().println("<a href=\"?Action=CONSTANTS\">Populate Constants</a>");
        resp.getWriter().println("<a href=\"?Action=TESTDATA\">Constants and Test values</a><br>");

        resp.getWriter().println("<br>");

        resp.getWriter().println("<a href=\"home\">To Backoffice</a><br>");
        resp.getWriter().println("<a href=\"_ah/admin/datastore\">Database Viewer</a><br>");

        resp.getWriter().println("<br>");
        resp.getWriter().println("<a href=\"?Action=TEST\">Launch test function</a><br>");

        resp.getWriter().println("</body>");
        resp.getWriter().println("</html>");

        resp.flushBuffer();


    }


}
