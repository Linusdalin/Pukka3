package backoffice.pages.template;

import backoffice.errorHandling.BackOfficeException;
import backoffice.modules.dynamicVariable.DynamicLoader;
import backoffice.pages.GenericPage;
import backoffice.pages.PageInterface;
import backoffice.pages.grid.GridRow;
import backoffice.style.HtmlBlock;
import backoffice.style.pageComponents.PageHeader;

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
    private List<DynamicLoader> loaders = new ArrayList<DynamicLoader>();

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

    protected void addDynamicLoader(DynamicLoader loader) {

        loaders.add(loader);
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

    public HtmlBlock toHtml(HttpServletRequest request) throws BackOfficeException{

        HtmlBlock html = new HtmlBlock();

        if(pageHeader != null)
            html.append(pageHeader.toHtml());

        for (GridRow row : rows) {

            html.append(row.render());
        }

        for (DynamicLoader loader : loaders) {

            html.append(loader.getScript());
        }

        return html;

    }


}
