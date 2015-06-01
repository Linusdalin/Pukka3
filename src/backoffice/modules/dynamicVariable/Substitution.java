package backoffice.modules.dynamicVariable;

/****************************************************************************
 *
 *              A substitution is a part of the DynamicLoader.
 *
 *              It defines a mapping between a json field in a data
 *              structure and a div/span class that should be replaced
 *
 *
 */


public class Substitution {

    public final String jsonField;
    public final String substitutionClass;

    /********************************************************
     *
     *          Create a substitution
     *
     * @param jsonField              - the field name in the json data
     * @param substitutionClass      - the class of the html element
     */


    public Substitution(String jsonField, String substitutionClass){

        this.jsonField = jsonField;
        this.substitutionClass = substitutionClass;
    }

}
