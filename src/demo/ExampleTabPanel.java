package demo;

import backoffice.pages.EmptyPage;
import backoffice.pages.Tab;
import backoffice.pages.TabPanel;

/******************************************************************************
 *
 *              Example page with a tab selector with multiple pages
 *
 */


public class ExampleTabPanel extends TabPanel {


    public ExampleTabPanel(){

        addTab(new Tab("First", "First", new EmptyPage()));         // Create a tab with an empty page
        addTab(new Tab("Second", "Second", new EmptyPage()));         // Create a tab with an empty page
    }
}
