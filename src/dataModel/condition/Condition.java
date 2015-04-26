package dataModel.condition;

import dataModel.condition.filter.FilterInterface;
import java.util.ArrayList;
import java.util.List;


/****************************************************************'
 *
 *          Basic condition functionality.
 *
 *      //TODO: Group by and unique/distinct not implemented
 *
 *
 */
abstract public class Condition implements ConditionInterface{



    protected String column = "";
    protected Object value = null;

    protected List<FilterInterface> filters = new ArrayList<FilterInterface>();
    protected Sorting sorting = new Sorting(null, Ordering.NONE);



    public ConditionInterface addFilter(FilterInterface filter){

        filters.add(filter);
        return this;
    }

    public List<FilterInterface> getFilters(){

        return filters;
    }



    public ConditionInterface addSorting(Sorting sorting){

        this.sorting = sorting;

        return this;
    }


    public Sorting getSorting(){

        return sorting;
    }


}
