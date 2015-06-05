package data.dataBaseLayer.Appengine;

import com.google.appengine.api.appidentity.AppIdentityServiceFactory;
import com.google.appengine.api.utils.SystemProperty;
import data.dataBaseLayer.EnvironmentAbstractionInterface;

import javax.management.relation.Role;

/**********************************************************************
 *
 * Created with IntelliJ IDEA.
 * User: Linus
 * Date: 2015-06-05
 * Time: 10:43
 * To change this template use File | Settings | File Templates.
 */

public class AppEngineEnvironment implements EnvironmentAbstractionInterface {

    public AppEngineEnvironment(){

    }

    public EnvironmentRole getRole() {

        if(SystemProperty.environment.value() == SystemProperty.Environment.Value.Production)
            return EnvironmentRole.LIVE;
        else
            return EnvironmentRole.DEV;


    }


}
