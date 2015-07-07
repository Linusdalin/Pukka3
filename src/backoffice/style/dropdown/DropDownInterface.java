package backoffice.style.dropdown;

import backoffice.style.HtmlBlock;

/**
 * Created with IntelliJ IDEA.
 * User: Linus
 * Date: 2015-05-16
 * Time: 17:10
 * To change this template use File | Settings | File Templates.
 */
public interface DropDownInterface {

    DropDownInterface withOnChangeEvent();
    DropDownInterface withName(String name);
    DropDownInterface withId(String id);
    DropDownInterface withClass(String cssClass);
    DropDownInterface withUnselected(String display);

    HtmlBlock render();


}
