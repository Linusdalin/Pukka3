package data.dataBaseLayer;

/**
 * Created with IntelliJ IDEA.
 * User: Linus
 * Date: 2015-06-05
 * Time: 10:44
 * To change this template use File | Settings | File Templates.
 */
public interface EnvironmentAbstractionInterface {

    // Execution environment
    public enum EnvironmentRole {LIVE, DEV}

    // Get the role of the current installation
    public EnvironmentRole getRole();

}
