package style;

/**
 * Created with IntelliJ IDEA.
 * User: Linus
 * Date: 2015-03-21
 * Time: 20:57
 * To change this template use File | Settings | File Templates.
 */
public class PukkaHtml extends Html {


    private enum BoxClasses {
        msginfo,            // blue
        msgalert,           // amber
        msgsuccess,         // gren
        msgerror,           // red
    }


    private static String box(String narration, BoxClasses boxClass) {

        return("<div class=\"notification "+ boxClass.name()+"\">\n" +
                "                        <a class=\"close\"></a>\n" +
                "                        <p>"+ narration+"</p>\n" +
                "                    </div><!-- notification -->");

    }


    public static String errorBox(String narration){

        return box(narration, BoxClasses.msgerror);

    }

    public static String infoBox(String narration){

        return box(narration, BoxClasses.msginfo);

    }

    public static String alertBox(String narration){

        return box(narration, BoxClasses.msgalert);

    }


    public static String successBox(String narration){

        return box(narration, BoxClasses.msgsuccess);

    }

    public static String variableBox(String narration){

        if(narration.startsWith("Error:"))
            return box(narration.substring( 6 ), BoxClasses.msgerror);
        if(narration.startsWith("Alert:"))
            return box(narration.substring( 6 ), BoxClasses.msgalert);
        if(narration.startsWith("Success:"))
            return box(narration.substring( 8 ), BoxClasses.msgsuccess);

        return box(narration, BoxClasses.msginfo);
    }

}
