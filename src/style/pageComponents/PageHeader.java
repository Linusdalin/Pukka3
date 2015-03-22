package style.pageComponents;

/**
 *          Top element on the page
 *
 */
public class PageHeader {

    private static final int ColumnWidth = 12;
    private String heading;

    public PageHeader(String heading){


        this.heading = heading;
    }

    public String render(){

        return
        "            <div class=\"row\">\n" +
        "                <div class=\"col-lg-"+ColumnWidth+"\">\n" +
        "                    <h1 class=\"page-header\">"+ heading +"</h1>\n" +
        "                </div>\n" +
        "                <!-- /.col-lg-"+ColumnWidth+" -->\n" +
        "            </div>\n";


    }

}
