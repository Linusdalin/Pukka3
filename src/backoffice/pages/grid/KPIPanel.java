package backoffice.pages.grid;

import backoffice.errorHandling.BackOfficeException;
import backoffice.errorHandling.LogLevel;
import backoffice.errorHandling.PukkaLogger;
import backoffice.links.InternalLink;
import backoffice.menu.Icon;
import backoffice.table.TableInterface;

/**
 *          A KPI-panel is a panel with a figure (typically displayed in the dashboard
 *          It has a top and an (optional) bottom section and can be filled with anything in-between
 *
 *          The top section can also be loaded with an icon
 *
 *          //TODO. Make read more configurable
 *
 */
public class KPIPanel extends GenericPanel implements PanelInterface{

    private Icon icon = Icon.comments;  // Default
    private PanelType type;
    private String text = "&nbsp;";
    private String readMore = "View Details";
    private int value = 0;
    private InternalLink link = new InternalLink("#");
    private boolean hasBreakDownLink = false;

    public KPIPanel(){

        this.type = PanelType.PRIMARY;  // If no type is set, use the default style (greyish)
    }

    public KPIPanel(Icon icon){

        this.icon = icon;
        this.type = PanelType.PRIMARY;  // If no type is set, use the default style (greyish)
    }


    public KPIPanel withValue(int value){

        this.value = value;
        return this;
    }

    public KPIPanel withText(String text){

        this.text = text;
        return this;
    }

    public KPIPanel withLink(String linkText, InternalLink link) {

        this.link = link;
        this.readMore = linkText;
        this.hasBreakDownLink = true;
        return this;
    }


    public String render(){

        StringBuffer html = new StringBuffer();

        html.append("   <div class=\"panel panel-"+type.getClassName()+"\">\n");
        html.append(

                "                        <div class=\"panel-heading\">\n" +
                "                            <div class=\"row\">\n" +
                "                                <div class=\"col-xs-3\">\n" +
                "                                    "+ icon.render( 5 )+"\n" +
                "                                </div>\n" +
                "                                <div class=\"col-xs-9 text-right\">\n" +
                "                                    <div class=\"huge\">"+ this.value+"</div>\n" +
                "                                    <div>"+ this.text+"</div>\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
        "                            <div class=\"panel-footer\">\n");
        if(hasBreakDownLink)
            html.append(
                "                        "+ this.link.render(
                "                                <span class=\"pull-left\">"+ readMore+"</span>\n" +
                "                                <span class=\"pull-right\"><i class=\"fa fa-arrow-circle-right\"></i></span>\n" +
                "                                <div class=\"clearfix\"></div>\n"));
        else
            html.append(
                "                                <span class=\"pull-left\">&nbsp;</span>\n" +
                "                                <div class=\"clearfix\"></div>\n");


        html.append(
                "                        </div>\n" +
                "                    </div>\n");

        return html.toString();
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

        PukkaLogger.log(LogLevel.ERROR,  "Not supported KPI-panels in an accordion");
        return "";

    }


}
