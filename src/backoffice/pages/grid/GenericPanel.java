package backoffice.pages.grid;

import backoffice.errorHandling.BackOfficeException;
import backoffice.errorHandling.PukkaLogger;
import backoffice.menu.Icon;
import backoffice.style.Html;
import backoffice.style.HtmlBlock;
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
public abstract class GenericPanel implements PanelInterface{

    protected String panelTop = null;
    protected Icon panelTopIcon = null;
    protected String panelBottom = null;
    protected String mainContent = null;

    protected PanelType type;

    public GenericPanel(){

        this.type = PanelType.DEFAULT;  // If no type is set, use the default style (greyish)
    }

    public GenericPanel(PanelType type){

        this.type = type;
    }



    public GenericPanel withTop(String html){

        this.panelTop = html;
        return this;
    }

    public PanelInterface withTop(Icon icon, String html){

        this.panelTop = html;
        this.panelTopIcon = icon;
        return this;
    }



    public PanelInterface withBottom(String html){

        this.panelBottom = html;
        return this;
    }

    @Deprecated
    public PanelInterface withContent(String html){

        this.mainContent = html;
        return this;
    }

    public PanelInterface withContent(HtmlBlock html){

        this.mainContent = html.toString();
        return this;
    }


    public PanelInterface withContent(){

        this.mainContent = "";
        return this;
    }

    public PanelInterface withContent(Accordion accordion) {

        this.mainContent = accordion.toHtml().render();
        return this;
    }

    public PanelInterface withContent(TableInterface table) {

        try {

            this.mainContent = table.toHtml().render();
        } catch (BackOfficeException e) {

            PukkaLogger.log( e );
            this.mainContent = Html.paragraph("Error generating table");
        }

        return this;
    }



    public PanelInterface withStyle(PanelType type) {

        this.type = type;
        return this;

    }

    //TODO: Log this properly

    public PanelInterface withIcon(Icon icon){

        return this;
    }



}
