package backoffice.common;

/**
* Created with IntelliJ IDEA.
* User: Linus
* Date: 2015-04-05
* Time: 17:00
* To change this template use File | Settings | File Templates.
*/
public enum AlertType {

    SUCCESS("success"), INFO("info"), WARNING("warning"), ERROR("error");
    private String name;

    AlertType(String name){

        this.name = name;
    }

    public String getName() {
        return name;
    }
}
