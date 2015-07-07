package slotAmerica;

import backoffice.common.Location;
import backoffice.form.FormInterface;
import backoffice.pages.GenericPage;
import backoffice.pages.PageInterface;
import backoffice.style.HtmlBlock;
import backoffice.style.pageComponents.PageHeader;

import javax.servlet.http.HttpServletRequest;

/**
 *
 *          Page to demo the tabs
 */

public class AboutRewardsPage extends GenericPage implements PageInterface {

    private static final String Name = "aboutRewards";
    private static final FormInterface form = new TestForm(new Location(Name));

    public AboutRewardsPage(){

        setName(Name);
        setTitle("Rewards");



    }

    /*************************************************''
     *
     *          The page contains a heading and a tab pane
     *
     * @param request
     * @return
     */


    public HtmlBlock toHtml(HttpServletRequest request){

        HtmlBlock html = new HtmlBlock();

        html.append(new PageHeader("About Rewards").toHtml());


        html.append("<pre>\n" +
           "===================================================================\n" +
           "/createReward - POST\n" +
           "ex:http://localhost:3003/createReward\n" +
           "body payload is in json format:\n" +
           "\n" +
           "{ \"type\": \"COINS\", \"value\":10000, \"message\":\"YOU HAVE RECEIVED A BONUS\" } \n" +
           "\n" +
           "\"COINS\" are currently the only supported type but the system will accept any value here for future expansion\n" +
           "value is value in virtual coins\n" +
           "message is presented to the user upon claiming the reward\n" +
           "\n" +
           "returns a json record with the id of the newly created reward, example:\n" +
           "{\n" +
           "type: \"COINS\"\n" +
           "value: 10000\n" +
           "message: \"YOU HAVE RECEIVED A BONUS\"\n" +
           "userCategories: [\n" +
           "...\n" +
           "5]\n" +
           "groups: [\n" +
           "0]\n" +
           "expires: 1432277820\n" +
           "id: \"f5ae5e62-3209-4599-b448-925184e20e91\"\n" +
           "}\n" +
           "\n" +
           "userCategories, groups and expires are not currently in use\n" +
           "the server call should be expanded to include these as soon as there is\n" +
           "support for them in the reward engine.\n" +
           "===================================================================" +
           "</pre>");

        return html;
    }


    /*
    @Override
    public String renderDataScripts(){

        return  new TestForm(new Location("TestPage")).getSubmitScript();

    }
      */

}
