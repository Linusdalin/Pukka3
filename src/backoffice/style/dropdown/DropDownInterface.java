package backoffice.style.dropdown;

/**
 * Created with IntelliJ IDEA.
 * User: Linus
 * Date: 2015-05-16
 * Time: 17:10
 * To change this template use File | Settings | File Templates.
 */
public interface DropDownInterface {

    public DropDownInterface withOnChangeEvent();
    public DropDownInterface withName(String name);
    public DropDownInterface withId(String id);
    public DropDownInterface withClass(String cssClass);
    public DropDownInterface withUnselected(String display);

    String render();


}
