package backoffice.pages.grid;


import backoffice.menu.Icon;
import backoffice.table.TableInterface;

/*************************************************************************
 *
 *          There are different types of panels that all can go in the row
 *
 *           A panel is typically set up in two steps. First the static
 *           information and in teh render method, adding dynamic content
 *
 */


public interface PanelInterface {

    public String render();
    public String renderInAccordion(int sectionNo, boolean open);

    // Dynamically set style and content

    PanelInterface withContent(String s);
    PanelInterface withContent(Accordion accordion);
    PanelInterface withContent(TableInterface table);

    PanelInterface withStyle(PanelType info);
    PanelInterface withBottom(String s);

    PanelInterface withTop(Icon icon, String s);
}
