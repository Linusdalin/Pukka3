package backoffice.common;

import backoffice.acs.ACSInterface;
import backoffice.acs.OpenDoorACS;
import backoffice.errorHandling.BackOfficeException;
import backoffice.errorHandling.LogLevel;
import backoffice.errorHandling.PukkaLogger;
import backoffice.form.FormInterface;
import backoffice.lightbox.LightboxInterface;
import backoffice.menu.Menu;
import backoffice.menu.NavBar;
import backoffice.pages.predefined.Empty404Page;
import backoffice.pages.PageInterface;
import dataModel.condition.SelectAll;
import dataModel.table.DataTable;
import dataModel.table.DataTableInterface;

import java.util.ArrayList;
import java.util.List;

/**********************************************************************''''
 *
 *
 *          General BackOffice functionality.
 *
 *          All backOffice implementations extends this interface
 *
 *
 */

abstract public class GenericBackoffice implements BackofficeInterface{

    private Menu menu;
    private String title = "Default Title";
    private List<PageInterface> pages = new ArrayList<PageInterface>();
    private List<LightboxInterface> lightboxes = new ArrayList<LightboxInterface>();
    private List<FormInterface> forms = new ArrayList<FormInterface>();
    private List<DataTableInterface> tables = new ArrayList<DataTableInterface>();

    private PageInterface homePage;
    private ACSInterface acs;


    public GenericBackoffice(){

        //Standard components for all systems
        pages.add(new Empty404Page());
        acs = new OpenDoorACS();


    }

    protected void setMenu(Menu menu) {

        this.menu = menu;
    }



    public Menu getMenu() {

        return menu;

    }

    public PageInterface getPageByName(String pageName) {

        if(pageName == null)
            return getPageByName("404");

        for (PageInterface page : pages) {
             if(page.getName().equals(pageName))
                 return page;
        }

        return getPageByName("404");


    }

    public FormInterface getFormByName(String formName) {

        if(formName == null)
            return null;

        for (FormInterface form : forms) {
             if(form.getName().equals(formName))
                 return form;
        }

        return null;


    }


    public LightboxInterface getLightBoxByName(String name) {

        if(name == null)
            return null;

        for (LightboxInterface lightBox : lightboxes) {
             if(lightBox.getName().equals(name))
                 return lightBox;
        }

        return null;


    }


    protected void addPage(PageInterface page) {

        pages.add(page);

    }

    protected void addLightBox(LightboxInterface lightBox) {

        lightboxes.add(lightBox);

    }

    protected void addForm(FormInterface form) {

        forms.add(form);

    }

    protected void addTable(DataTableInterface table) {

        tables.add(table);

    }


    public void setTitle(String title){

        this.title = title;
    }


    public String getSystemTitle() {
        return title;
    }

    protected void setWelcomePage(PageInterface page) {

        this.homePage = page;
    }

    public PageInterface getWelcomePage() {

        return homePage;
    }

    public NavBar getNavbar() {

        return menu.getNavBar();
    }


    public ACSInterface getAcs() {
        return acs;
    }

    public void setAcs(ACSInterface acs) {
        this.acs = acs;
    }


    /***********************************************************************
     *
     *          Populate example and base data
     *
     *
     * @param includeTestValues      - shall we add test data (only for test environments)
     * @return
     */


    public boolean populateValues(boolean includeTestValues){

        PukkaLogger.log(LogLevel.INFO, "Populating values in the database.");
        boolean success = true;


        for(DataTableInterface table : tables){

            PukkaLogger.log(LogLevel.INFO, " *** Populating default values for table: " + table.getTableName());

            try{

                int populatedValues = table.populateDefaultValues();

                if(populatedValues == DataTableInterface.FAIL_TO_GENERATE)
                    return false;

                if(includeTestValues){

                    PukkaLogger.log(LogLevel.INFO, " *** Populating test values for table: " + table.getTableName());
                    int testValues = table.populateTestValues();

                    if(testValues == DataTableInterface.FAIL_TO_GENERATE)
                        return false;

                }



            }catch (Exception e){

                PukkaLogger.log(e, "Table: " + table.getTableName());
            }
        }

        success &= replaceSymbolicValues();

        return success;
    }

    public DataTableInterface getTableByName(String tableName) throws BackOfficeException {

        for (DataTableInterface table : tables) {

            if(table.getTableName().equals(tableName))
                return table;

        }

        throw new BackOfficeException(BackOfficeException.Type.CONFIGURATION, "Table " + tableName + " not found");

    }

    public boolean createDB(){

        PukkaLogger.log(LogLevel.INFO, "Creating tables in the database.");
        boolean success = true;

        success &= createTables();

        return success;

    }


    private boolean createTables(){

        boolean success = true;

        for(DataTableInterface table : tables){

            PukkaLogger.log(LogLevel.INFO, " *** Create table: " + table.getTableName());

            try{

                success &= table.create();


            }catch (Exception e){

                PukkaLogger.log(e, "Table: " + table.getTableName());
            }
        }

        return success;

    }


    private boolean replaceSymbolicValues(){

        boolean success = true;

        for(DataTableInterface table : tables){

            PukkaLogger.log(LogLevel.INFO, " *** Create symbolic values for table: " + table.getTableName());

            try{

                table.load(new SelectAll());
                success &= table.replaceSymbolicValues(this);


            }catch (Exception e){

                PukkaLogger.log(e, "Table: " + table.getTableName());
            }
        }

        return success;

    }


}
