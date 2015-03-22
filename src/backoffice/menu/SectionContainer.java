package backoffice.menu;


/**
 *
 *
 *          A compound section expandable with sub sections
 */

public class SectionContainer implements SectionInterface{

    String name;
    private SectionInterface[] subSections;

    public SectionContainer(String name, SectionInterface[] subSections){

        this.name = name;
        this.subSections = subSections;
    }

    public String render(){

        return " ...";
    }

}
