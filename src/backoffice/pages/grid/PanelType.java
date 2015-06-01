package backoffice.pages.grid;

/**
 *
 *          Panel types are defined in the .css file
 *
 */
public enum PanelType {

    DEFAULT("default"),
    PRIMARY("primary"),
    INFO("info"),
    SUCCESS("success"),
    WARNING("warning"),
    ERROR("danger"),

    GREEN("green"),
    YELLOW("yellow"),
    RED("red"),


    ;


    private String className;

    PanelType(String name) {

        this.className = name;
    }

    public String getClassName() {
        return className;
    }
}
