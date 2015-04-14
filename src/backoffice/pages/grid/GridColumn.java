package backoffice.pages.grid;

import backoffice.errorHandling.BackOfficeException;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *          A grid column is filling part of a row
 *
 *          The width defines how much of the grid. Grid size is 12 so this is part-of-12
 *
 *
 */

public class GridColumn {

    private final int width;
    private List<PanelInterface> panels = new ArrayList<PanelInterface>();

    public GridColumn(int width) throws BackOfficeException{

        if(width < 1 || width > 12)
            throw new BackOfficeException(BackOfficeException.Type.CONFIGURATION, "Illegal column width " + width);

        this.width = width;
    }

    public int getWidth() {

        return width;
    }

    public GridColumn addPanel(PanelInterface panel){

        panels.add(panel);
        return this;
    }

    /****************************************************
     *
     *          Render teh column by rendering all components
     *
     * @return      - html
     */

    public String render(){

        StringBuffer html = new StringBuffer();
        html.append("                <div class=\"col-lg-"+width+"\">\n");

        for (PanelInterface panel : panels) {

            html.append(panel.render());
        }
        html.append("                </div> <!-- column -->\n");

        return html.toString();
    }

}
