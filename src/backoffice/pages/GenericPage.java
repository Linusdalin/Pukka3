package backoffice.pages;

import backoffice.common.Location;
import backoffice.errorHandling.BackOfficeException;

import javax.servlet.http.HttpServletRequest;

/**
 *
 *          Common page functionality
 *
 *          This can be inherited for a generic page that can be filled with anything and then rendered with a custom render function.
 *
 */

abstract
public class GenericPage implements PageInterface {

    private String name = null;
    private String title = "No title";
    protected Location location;

    /*********************************************************************
     *
     *          The abstract render function is not supposed to be called
     *
     * @param request
     * @return
     */

    public String render(HttpServletRequest request) throws BackOfficeException{

        throw new BackOfficeException(BackOfficeException.Type.CONFIGURATION, "No renderer defined for page " + name);

    }

    protected void setName(String name) {
        this.name = name;
        this.location = new Location(name);
    }

    protected void setTitle(String title) {
        this.title = title;
    }

    public String getTitle(){

        return title;
    }

    public String getName(){

        return name;
    }

    public String renderDataScripts(){

        return  "            <script src=\"adminCommon/pukka.js\"></script>\n";

    }

}
