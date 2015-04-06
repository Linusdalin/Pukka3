package backoffice.pages;

import backoffice.common.Location;

import javax.servlet.http.HttpServletRequest;

/**
 *
 *          Common page functionality
 */

abstract
public class GenericPage implements PageInterface {

    private String name = null;
    private String title = "No title";
    protected Location location;

    public String render(HttpServletRequest request){

        return "No content defined for page";
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
