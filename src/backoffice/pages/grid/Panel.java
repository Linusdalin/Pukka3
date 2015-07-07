package backoffice.pages.grid;

import backoffice.menu.Icon;
import backoffice.style.HtmlBlock;
import backoffice.table.Table;
import backoffice.table.TableInterface;

/**
 *          A panel is the smallest building block of the pages.
 *          It has a top and an (optional) bottom section and can be filled with anything in-between
 *
 *          The top section can also be loaded with an icon
 *
 *
 *          //TODO: Add support for actions in panels (see demo page)
 *
 */
public class Panel extends GenericPanel implements PanelInterface{

    private Icon topIcon = null;

    public Panel(){

        this.type = PanelType.DEFAULT;  // If no type is set, use the default style (greyish)
    }

    public Panel(PanelType type, Icon topIcon){

        this.type = type;
        this.topIcon = topIcon;
    }

    public Panel(PanelType type){

        this.type = type;
    }



    public PanelInterface withIcon(Icon icon) {

        this.topIcon = icon;
        return this;
    }


    public HtmlBlock toHtml(){

        HtmlBlock html = new HtmlBlock();
        html.append("   <div class=\"panel panel-"+type.getClassName()+"\">");

        html.append("       <div class=\"panel-heading\">");
        if(topIcon != null)
            html.append(topIcon.render());

        html.append(panelTop);
        html.append("       </div>   <!-- Panel heading  -->\n");

        html.append("       <div class=\"panel-body\">");
        html.append(mainContent);
        html.append("       </div>   <!-- Panel body  -->\n");

        if(panelBottom != null){

            html.append("       <div class=\"panel-footer\">");
            html.append(panelBottom);
            html.append("       </div>   <!-- Panel footer  -->\n");
        }

        html.append("   </div>   <!-- Panel  -->\n");
        return html;
    }

    /********************************************************************************'
     *
     *          A panel can appear in an accordion, but is then rendered a bit differently.
     *          (With a link to open/collapse)
     *
     *          Also note that a panel in an accordion does not have a bottom
     *
     * @return
     */

    public String renderInAccordion(int sectionNo, boolean open){

        HtmlBlock html = new HtmlBlock();
        html.append("   <div class=\"panel panel-"+type.getClassName()+"\">\n");

        html.append("       <div class=\"panel-heading\">\n");
        html.append("           <h4 class=\"panel-title\">\n");
        if(topIcon != null)
            html.append(topIcon.render());
        html.append("              <a data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#section"+sectionNo+"\">" +panelTop + "</a>\n");
        html.append("           </h4>\n");

        html.append("       </div>   <!-- Panel heading  -->\n");

        html.append("       <div id=\"section"+sectionNo+"\" class=\"panel-collapse collapse "+(open ? "in" : "")+"\">\n");

        html.append("           <div class=\"panel-body\">\n");
        html.append(mainContent+ "\n");
        html.append("           </div>   <!-- Panel body  -->\n");
        html.append("       </div>   <!-- Panel collapse  -->\n");


        html.append("   </div>   <!-- Panel  -->\n");
        return html.toString();

    }



}
