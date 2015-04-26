package dataModel.condition;

import dataModel.condition.filter.FilterInterface;

import java.util.List;

/*****************************************************************'''
 *
 *            Generic condition wrapper
 *            A condition defines a selection for a table access.
 *
 */


public interface ConditionInterface {


    // Filters handle which rows should be accessed

    public ConditionInterface addFilter(FilterInterface filter);
    public List<FilterInterface> getFilters();

    // Sorting defines the order for the result

    public enum Ordering { NONE, FIRST_FIRST, LAST_FIRST}

    public ConditionInterface addSorting(Sorting sorting);
    Sorting getSorting();

}
