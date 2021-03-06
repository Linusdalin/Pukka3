package backoffice.style.dropdown;

import backoffice.style.Html;
import backoffice.style.HtmlBlock;

import java.util.List;

/**********************************************************************
 *
 *          Generic functionality for the generations of drop down lists
 *
 */
public abstract class GenericDropDown implements DropDownInterface {


    protected boolean onChange = false;
    protected String id;
    protected String name;
    protected String cssClass = "";
    protected String unselected = null;

    public DropDownInterface withName(String name) {

        this.name = name;
        this.id = name;
        return this;
    }

    public DropDownInterface withOnChangeEvent(){

        onChange = true;
        return this;
    }

    public DropDownInterface withId(String id){

        this.id = id;
        return this;
    }

    public DropDownInterface withClass(String cssClass){

        this.cssClass = cssClass;
        return this;
    }

    public DropDownInterface withUnselected(String display){

        this.unselected = display;
        return this;
    }

    //TODO: Handle missing name/id here

    protected HtmlBlock generateSelect(List<String> options) {

        HtmlBlock html = new HtmlBlock();
        html.append("             <select id=\"" + id + "\" class=\""+ cssClass +"\" name=\"" + name + "\" ");

        if(onChange)
            html.append(" onchange='this.form.submit()'");
        html.append(">\n");

        if(unselected != null){

            html.append(Html.option("all", "0", false, unselected));       // Should this be 0?
        }

        for(String option : options){

            html.append("               " + option + "\n");
        }

        html.append("              </select>\n\n");


        return html;
    }


}
