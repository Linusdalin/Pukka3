package backoffice.pages.template;

import backoffice.errorHandling.BackOfficeException;
import backoffice.pages.GenericPage;
import backoffice.pages.PageInterface;
import backoffice.pages.grid.GridRow;
import style.pageComponents.PageHeader;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *          Abstract Grid page
 */

abstract public class GridPage extends GenericPage implements PageInterface {

    private PageHeader pageHeader = null;
    private List<GridRow> rows = new ArrayList<GridRow>();

    public GridPage(String name, String title){

        setName(name);
        setTitle(title);

    }

    /**************************************************************
     *
     *          The grid page is built up by grid rows. These contain the columns and the panels
     *
     *
     * @param row
     */

    protected void addRow(GridRow row) {

        rows.add(row);
    }


    protected void setPageHeader(PageHeader header) {

        this.pageHeader = header;
    }


    /*********************************************************************
     *
     *                  The grid page shall render the grid structure defined
     *                  by the rows, columns and panels given
     *
     *
     * @param request     - the request data. (used for overriding the method)
     * @return
     */

    public String render(HttpServletRequest request) throws BackOfficeException{

        StringBuffer html = new StringBuffer();

        if(pageHeader != null)
            html.append(pageHeader.render());

        for (GridRow row : rows) {

            html.append(row.render());
        }

        return html.toString();


    }


}
