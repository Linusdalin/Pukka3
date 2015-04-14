package backoffice.pages.grid;

import java.util.ArrayList;
import java.util.List;

/**
 *          An accordion has multiple sections that can be opened/collapsed one at a time
 *
 */
public class Accordion {

    List<PanelInterface> sections = new ArrayList<PanelInterface>();
    int openSection = -1;

    public Accordion(){

    }

    public Accordion withOpenSection(int sectionNo){

        openSection = sectionNo;
        return this;

    }

    public Accordion addSection(PanelInterface panel){

        sections.add(panel);
        return this;
    }

    public String render() {

        StringBuffer html = new StringBuffer();
        html.append("                            <div class=\"panel-group\" id=\"accordion\">\n");

        int sectionNo = 0;
        for (PanelInterface section : sections) {

            html.append(section.renderInAccordion(sectionNo++, (sectionNo == openSection)));
        }


        html.append("                            </div>   <!-- panel group -->\n");

        return html.toString();
    }
}
