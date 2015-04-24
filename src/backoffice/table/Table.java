package backoffice.table;

/**
 * Created with IntelliJ IDEA.
 * User: Linus
 * Date: 2015-04-15
 * Time: 11:01
 * To change this template use File | Settings | File Templates.
 */
public class Table {



    public void Table(){

    }


    public String render(){

        return
                "<div class=\"dataTable_wrapper\">\n" +
                        "                                <table class=\"table table-striped table-bordered table-hover\" id=\"dataTables-example\">\n" +
                        "                                    <thead>\n" +
                        "                                        <tr>\n" +
                        "                                            <th>Rendering engine</th>\n" +
                        "                                            <th>Browser</th>\n" +
                        "                                            <th>Platform(s)</th>\n" +
                        "                                            <th>Engine version</th>\n" +
                        "                                            <th>CSS grade</th>\n" +
                        "                                        </tr>\n" +
                        "                                    </thead>\n" +
                        "                                    <tbody>\n" +
                        "                                        <tr class=\"odd gradeX\">\n" +
                        "                                            <td>Trident</td>\n" +
                        "                                            <td>Internet Explorer 4.0</td>\n" +
                        "                                            <td>Win 95+</td>\n" +
                        "                                            <td class=\"center\">4</td>\n" +
                        "                                            <td class=\"center\">X</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"even gradeC\">\n" +
                        "                                            <td>Trident</td>\n" +
                        "                                            <td>Internet Explorer 5.0</td>\n" +
                        "                                            <td>Win 95+</td>\n" +
                        "                                            <td class=\"center\">5</td>\n" +
                        "                                            <td class=\"center\">C</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"odd gradeA\">\n" +
                        "                                            <td>Trident</td>\n" +
                        "                                            <td>Internet Explorer 5.5</td>\n" +
                        "                                            <td>Win 95+</td>\n" +
                        "                                            <td class=\"center\">5.5</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"even gradeA\">\n" +
                        "                                            <td>Trident</td>\n" +
                        "                                            <td>Internet Explorer 6</td>\n" +
                        "                                            <td>Win 98+</td>\n" +
                        "                                            <td class=\"center\">6</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"odd gradeA\">\n" +
                        "                                            <td>Trident</td>\n" +
                        "                                            <td>Internet Explorer 7</td>\n" +
                        "                                            <td>Win XP SP2+</td>\n" +
                        "                                            <td class=\"center\">7</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"even gradeA\">\n" +
                        "                                            <td>Trident</td>\n" +
                        "                                            <td>AOL browser (AOL desktop)</td>\n" +
                        "                                            <td>Win XP</td>\n" +
                        "                                            <td class=\"center\">6</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>Gecko</td>\n" +
                        "                                            <td>Firefox 1.0</td>\n" +
                        "                                            <td>Win 98+ / OSX.2+</td>\n" +
                        "                                            <td class=\"center\">1.7</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>Gecko</td>\n" +
                        "                                            <td>Firefox 1.5</td>\n" +
                        "                                            <td>Win 98+ / OSX.2+</td>\n" +
                        "                                            <td class=\"center\">1.8</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>Gecko</td>\n" +
                        "                                            <td>Firefox 2.0</td>\n" +
                        "                                            <td>Win 98+ / OSX.2+</td>\n" +
                        "                                            <td class=\"center\">1.8</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>Gecko</td>\n" +
                        "                                            <td>Firefox 3.0</td>\n" +
                        "                                            <td>Win 2k+ / OSX.3+</td>\n" +
                        "                                            <td class=\"center\">1.9</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>Gecko</td>\n" +
                        "                                            <td>Camino 1.0</td>\n" +
                        "                                            <td>OSX.2+</td>\n" +
                        "                                            <td class=\"center\">1.8</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>Gecko</td>\n" +
                        "                                            <td>Camino 1.5</td>\n" +
                        "                                            <td>OSX.3+</td>\n" +
                        "                                            <td class=\"center\">1.8</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>Gecko</td>\n" +
                        "                                            <td>Netscape 7.2</td>\n" +
                        "                                            <td>Win 95+ / Mac OS 8.6-9.2</td>\n" +
                        "                                            <td class=\"center\">1.7</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>Gecko</td>\n" +
                        "                                            <td>Netscape Browser 8</td>\n" +
                        "                                            <td>Win 98SE+</td>\n" +
                        "                                            <td class=\"center\">1.7</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>Gecko</td>\n" +
                        "                                            <td>Netscape Navigator 9</td>\n" +
                        "                                            <td>Win 98+ / OSX.2+</td>\n" +
                        "                                            <td class=\"center\">1.8</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>Gecko</td>\n" +
                        "                                            <td>Mozilla 1.0</td>\n" +
                        "                                            <td>Win 95+ / OSX.1+</td>\n" +
                        "                                            <td class=\"center\">1</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>Gecko</td>\n" +
                        "                                            <td>Mozilla 1.1</td>\n" +
                        "                                            <td>Win 95+ / OSX.1+</td>\n" +
                        "                                            <td class=\"center\">1.1</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>Gecko</td>\n" +
                        "                                            <td>Mozilla 1.2</td>\n" +
                        "                                            <td>Win 95+ / OSX.1+</td>\n" +
                        "                                            <td class=\"center\">1.2</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>Gecko</td>\n" +
                        "                                            <td>Mozilla 1.3</td>\n" +
                        "                                            <td>Win 95+ / OSX.1+</td>\n" +
                        "                                            <td class=\"center\">1.3</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>Gecko</td>\n" +
                        "                                            <td>Mozilla 1.4</td>\n" +
                        "                                            <td>Win 95+ / OSX.1+</td>\n" +
                        "                                            <td class=\"center\">1.4</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>Gecko</td>\n" +
                        "                                            <td>Mozilla 1.5</td>\n" +
                        "                                            <td>Win 95+ / OSX.1+</td>\n" +
                        "                                            <td class=\"center\">1.5</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>Gecko</td>\n" +
                        "                                            <td>Mozilla 1.6</td>\n" +
                        "                                            <td>Win 95+ / OSX.1+</td>\n" +
                        "                                            <td class=\"center\">1.6</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>Gecko</td>\n" +
                        "                                            <td>Mozilla 1.7</td>\n" +
                        "                                            <td>Win 98+ / OSX.1+</td>\n" +
                        "                                            <td class=\"center\">1.7</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>Gecko</td>\n" +
                        "                                            <td>Mozilla 1.8</td>\n" +
                        "                                            <td>Win 98+ / OSX.1+</td>\n" +
                        "                                            <td class=\"center\">1.8</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>Gecko</td>\n" +
                        "                                            <td>Seamonkey 1.1</td>\n" +
                        "                                            <td>Win 98+ / OSX.2+</td>\n" +
                        "                                            <td class=\"center\">1.8</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>Gecko</td>\n" +
                        "                                            <td>Epiphany 2.20</td>\n" +
                        "                                            <td>Gnome</td>\n" +
                        "                                            <td class=\"center\">1.8</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>Webkit</td>\n" +
                        "                                            <td>Safari 1.2</td>\n" +
                        "                                            <td>OSX.3</td>\n" +
                        "                                            <td class=\"center\">125.5</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>Webkit</td>\n" +
                        "                                            <td>Safari 1.3</td>\n" +
                        "                                            <td>OSX.3</td>\n" +
                        "                                            <td class=\"center\">312.8</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>Webkit</td>\n" +
                        "                                            <td>Safari 2.0</td>\n" +
                        "                                            <td>OSX.4+</td>\n" +
                        "                                            <td class=\"center\">419.3</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>Webkit</td>\n" +
                        "                                            <td>Safari 3.0</td>\n" +
                        "                                            <td>OSX.4+</td>\n" +
                        "                                            <td class=\"center\">522.1</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>Webkit</td>\n" +
                        "                                            <td>OmniWeb 5.5</td>\n" +
                        "                                            <td>OSX.4+</td>\n" +
                        "                                            <td class=\"center\">420</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>Webkit</td>\n" +
                        "                                            <td>iPod Touch / iPhone</td>\n" +
                        "                                            <td>iPod</td>\n" +
                        "                                            <td class=\"center\">420.1</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>Webkit</td>\n" +
                        "                                            <td>S60</td>\n" +
                        "                                            <td>S60</td>\n" +
                        "                                            <td class=\"center\">413</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>Presto</td>\n" +
                        "                                            <td>Opera 7.0</td>\n" +
                        "                                            <td>Win 95+ / OSX.1+</td>\n" +
                        "                                            <td class=\"center\">-</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>Presto</td>\n" +
                        "                                            <td>Opera 7.5</td>\n" +
                        "                                            <td>Win 95+ / OSX.2+</td>\n" +
                        "                                            <td class=\"center\">-</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>Presto</td>\n" +
                        "                                            <td>Opera 8.0</td>\n" +
                        "                                            <td>Win 95+ / OSX.2+</td>\n" +
                        "                                            <td class=\"center\">-</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>Presto</td>\n" +
                        "                                            <td>Opera 8.5</td>\n" +
                        "                                            <td>Win 95+ / OSX.2+</td>\n" +
                        "                                            <td class=\"center\">-</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>Presto</td>\n" +
                        "                                            <td>Opera 9.0</td>\n" +
                        "                                            <td>Win 95+ / OSX.3+</td>\n" +
                        "                                            <td class=\"center\">-</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>Presto</td>\n" +
                        "                                            <td>Opera 9.2</td>\n" +
                        "                                            <td>Win 88+ / OSX.3+</td>\n" +
                        "                                            <td class=\"center\">-</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>Presto</td>\n" +
                        "                                            <td>Opera 9.5</td>\n" +
                        "                                            <td>Win 88+ / OSX.3+</td>\n" +
                        "                                            <td class=\"center\">-</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>Presto</td>\n" +
                        "                                            <td>Opera for Wii</td>\n" +
                        "                                            <td>Wii</td>\n" +
                        "                                            <td class=\"center\">-</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>Presto</td>\n" +
                        "                                            <td>Nokia N800</td>\n" +
                        "                                            <td>N800</td>\n" +
                        "                                            <td class=\"center\">-</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>Presto</td>\n" +
                        "                                            <td>Nintendo DS browser</td>\n" +
                        "                                            <td>Nintendo DS</td>\n" +
                        "                                            <td class=\"center\">8.5</td>\n" +
                        "                                            <td class=\"center\">C/A<sup>1</sup>\n" +
                        "                                            </td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeC\">\n" +
                        "                                            <td>KHTML</td>\n" +
                        "                                            <td>Konqureror 3.1</td>\n" +
                        "                                            <td>KDE 3.1</td>\n" +
                        "                                            <td class=\"center\">3.1</td>\n" +
                        "                                            <td class=\"center\">C</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>KHTML</td>\n" +
                        "                                            <td>Konqureror 3.3</td>\n" +
                        "                                            <td>KDE 3.3</td>\n" +
                        "                                            <td class=\"center\">3.3</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>KHTML</td>\n" +
                        "                                            <td>Konqureror 3.5</td>\n" +
                        "                                            <td>KDE 3.5</td>\n" +
                        "                                            <td class=\"center\">3.5</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeX\">\n" +
                        "                                            <td>Tasman</td>\n" +
                        "                                            <td>Internet Explorer 4.5</td>\n" +
                        "                                            <td>Mac OS 8-9</td>\n" +
                        "                                            <td class=\"center\">-</td>\n" +
                        "                                            <td class=\"center\">X</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeC\">\n" +
                        "                                            <td>Tasman</td>\n" +
                        "                                            <td>Internet Explorer 5.1</td>\n" +
                        "                                            <td>Mac OS 7.6-9</td>\n" +
                        "                                            <td class=\"center\">1</td>\n" +
                        "                                            <td class=\"center\">C</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeC\">\n" +
                        "                                            <td>Tasman</td>\n" +
                        "                                            <td>Internet Explorer 5.2</td>\n" +
                        "                                            <td>Mac OS 8-X</td>\n" +
                        "                                            <td class=\"center\">1</td>\n" +
                        "                                            <td class=\"center\">C</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>Misc</td>\n" +
                        "                                            <td>NetFront 3.1</td>\n" +
                        "                                            <td>Embedded devices</td>\n" +
                        "                                            <td class=\"center\">-</td>\n" +
                        "                                            <td class=\"center\">C</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeA\">\n" +
                        "                                            <td>Misc</td>\n" +
                        "                                            <td>NetFront 3.4</td>\n" +
                        "                                            <td>Embedded devices</td>\n" +
                        "                                            <td class=\"center\">-</td>\n" +
                        "                                            <td class=\"center\">A</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeX\">\n" +
                        "                                            <td>Misc</td>\n" +
                        "                                            <td>Dillo 0.8</td>\n" +
                        "                                            <td>Embedded devices</td>\n" +
                        "                                            <td class=\"center\">-</td>\n" +
                        "                                            <td class=\"center\">X</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeX\">\n" +
                        "                                            <td>Misc</td>\n" +
                        "                                            <td>Links</td>\n" +
                        "                                            <td>Text only</td>\n" +
                        "                                            <td class=\"center\">-</td>\n" +
                        "                                            <td class=\"center\">X</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeX\">\n" +
                        "                                            <td>Misc</td>\n" +
                        "                                            <td>Lynx</td>\n" +
                        "                                            <td>Text only</td>\n" +
                        "                                            <td class=\"center\">-</td>\n" +
                        "                                            <td class=\"center\">X</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeC\">\n" +
                        "                                            <td>Misc</td>\n" +
                        "                                            <td>IE Mobile</td>\n" +
                        "                                            <td>Windows Mobile 6</td>\n" +
                        "                                            <td class=\"center\">-</td>\n" +
                        "                                            <td class=\"center\">C</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeC\">\n" +
                        "                                            <td>Misc</td>\n" +
                        "                                            <td>PSP browser</td>\n" +
                        "                                            <td>PSP</td>\n" +
                        "                                            <td class=\"center\">-</td>\n" +
                        "                                            <td class=\"center\">C</td>\n" +
                        "                                        </tr>\n" +
                        "                                        <tr class=\"gradeU\">\n" +
                        "                                            <td>Other browsers</td>\n" +
                        "                                            <td>All others</td>\n" +
                        "                                            <td>-</td>\n" +
                        "                                            <td class=\"center\">-</td>\n" +
                        "                                            <td class=\"center\">U</td>\n" +
                        "                                        </tr>\n" +
                        "                                    </tbody>\n" +
                        "                                </table>\n" +
                        "                            </div>" +
                        "    <!-- Page-Level Demo Scripts - Tables - Use for reference -->\n" +
                                "    <script>\n" +
                                "    $(document).ready(function() {\n" +
                                "        $('#dataTables-example').DataTable({\n" +
                                "                responsive: true\n" +
                                "        });\n" +
                                "    });\n" +
                                "    </script>\n" +
                        "\n\n";

    }
}
