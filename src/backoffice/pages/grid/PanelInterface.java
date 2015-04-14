package backoffice.pages.grid;

/*************************************************************************
 *
 *          There are different types of panels that all can go in the row
 *
 */


public interface PanelInterface {

    public String render();
    public String renderInAccordion(int sectionNo, boolean open);

}
