package backoffice.pages.grid;

import backoffice.style.HtmlBlock;

import java.util.ArrayList;
import java.util.List;

/**
 *          An accordion has multiple sections that can be opened/collapsed one at a time
 *
 *
 *          //TODO: The accordion closes all other panels when one is opened. This is often not the desired behaviour. Change in the .js
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

    public HtmlBlock toHtml() {

        HtmlBlock html = new HtmlBlock();
        html.append("                            <div class=\"panel-group\" id=\"accordion\">\n");

        int sectionNo = 0;
        for (PanelInterface section : sections) {

            html.append(section.renderInAccordion(sectionNo++, (sectionNo == openSection)));
        }


        html.append("                            </div>   <!-- panel group -->\n");

        return html;
    }
}
