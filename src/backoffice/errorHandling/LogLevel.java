package backoffice.errorHandling;

/**
* Created with IntelliJ IDEA.
* User: Linus
* Date: 2015-04-06
* Time: 12:46
* To change this template use File | Settings | File Templates.
*/
public enum LogLevel { DEBUG(10), INFO(20), WARNING(25), ACTION(30), MAJOR_EVENT(40), ERROR(40), FATAL(50);
    private int levelId;

    LogLevel(int i) {

        levelId = i;
    }
    public int getOrdinal(){

        return levelId;
    }
}
