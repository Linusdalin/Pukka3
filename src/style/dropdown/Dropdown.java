package style.dropdown;

import style.Html;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Linus
 * Date: 2015-05-16
 * Time: 17:12
 * To change this template use File | Settings | File Templates.
 */
public class Dropdown extends GenericDropDown implements DropDownInterface {

    private static List<String> options = new ArrayList<String>();

    public Dropdown(String[] values){

        this(values, null);
    }

    public Dropdown(String[] values, String selectedValue){

        for (String value : values) {

            boolean selected = (selectedValue != null && selectedValue.equals(value));
            options.add(Html.option(value, value, selected));
        }

    }

    public String render() {

        return generateSelect(options);
    }
}
