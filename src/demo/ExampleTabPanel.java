package demo;

import backoffice.pages.predefined.Empty404Page;
import backoffice.pages.tab.Tab;
import backoffice.pages.tab.TabPanel;

/******************************************************************************
 *
 *              Example page with a tab selector with multiple pages
 *
 */


public class ExampleTabPanel extends TabPanel {


    public ExampleTabPanel(){

        addTab(new Tab("First", "First", new Empty404Page()).setDefault());    // Create a tab with an empty page
        addTab(new Tab("Second", "Second", new Empty404Page()));               // Create a tab with an empty page
    }
}
