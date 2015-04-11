package backoffice.pages.grid;

import backoffice.errorHandling.BackOfficeException;

import java.util.ArrayList;
import java.util.List;

/**
 *          A grid row collects columns
 *
 */

public class GridRow {

    private final static int GRID_SIZE = 12;
    private int noColumns = 0;
    private int totalWidth = 0;
    private List<GridColumn> columns = new ArrayList<GridColumn>();

    public GridRow(int columns){

        this.noColumns = columns;
    }



    /********************************************************'
     *
     *          Adding a column to the row.
     *          The total column width must not exceed the GRID_SIZE
     *
     *
     * @param column        - column with panels to add
     * @throws BackOfficeException
     */


    public GridRow addColumn(GridColumn column) throws BackOfficeException{

        columns.add(column);
        totalWidth += column.getWidth();
        if(totalWidth > GRID_SIZE)
            throw new BackOfficeException(BackOfficeException.Type.CONFIGURATION, "Trying to construct a to wide row. GRID width = " + GRID_SIZE +". " + noColumns + " columns at a total width of " + totalWidth);
        return this;
    }

    public String render() throws BackOfficeException{

        if(noColumns != columns.size())
            throw new BackOfficeException(BackOfficeException.Type.CONFIGURATION, "Expecting "+ noColumns+" columns n row. Found " + columns.size());

        StringBuffer html = new StringBuffer();
        html.append("            <div class=\"row\">\n");

        for (GridColumn column : columns) {

            html.append(column.render());
        }

        html.append("            </div> <!-- row -->\n");
        return html.toString();
    }


}
