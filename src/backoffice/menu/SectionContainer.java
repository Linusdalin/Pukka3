package backoffice.menu;


/**
 *
 *
 *          A compound section expandable with sub sections
 *
 */

public class SectionContainer extends GenericSection implements SectionInterface{

    private static final String[] subSectionClassName = {"not used", "not used", "nav-second-level", "nav-third-level" };
    private static final int MAX_DEPTH = 3;

    private SectionInterface[] subSections;

    /*******************************************************'
     *
     *          Create a new Section
     *
     * @param name          - Name to be displayed in the menu
     * @param icon          - icon to display
     * @param subSections   - The under laying sections
     */


    public SectionContainer(String name, Icon icon, SectionInterface[] subSections){

        this.name = name;
        this.subSections = subSections;
        this.icon = icon;
    }

    /**********************************************************
     *
     *          Render the menu section
     *
     * @param level      - the level in the tree.
     * @return
     *
     *          NOTE: level must not be more than teh MAX_LEVEL as this is defined by the css styling
     */

    public String render(int level){

        StringBuffer section = new StringBuffer();

        section.append( "                        <li>\n" +
                        "                            <a href=\"#\">"+icon.render() + name+"<span class=\"fa arrow\"></span></a>\n");

        if(level < MAX_DEPTH){

            section.append( "                            <ul class=\"nav "+subSectionClassName[level + 1] +"\">\n");

            for (SectionInterface subSection : subSections) {

                section.append(subSection.render(level + 1));
            }

            section.append( "                            </ul>\n");
            section.append( "                            <!-- /."+subSectionClassName[level + 1]+" -->\n");

        }
        else{

            System.out.println("Not supported more than " + MAX_DEPTH + " subsection levels");
        }

        section.append( "                        </li>\n");


        return section.toString();
    }


}
