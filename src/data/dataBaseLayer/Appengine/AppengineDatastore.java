package data.dataBaseLayer.Appengine;

import backoffice.errorHandling.BackOfficeException;
import backoffice.errorHandling.LogLevel;
import backoffice.errorHandling.PukkaLogger;
import com.google.appengine.api.datastore.*;
import com.google.apphosting.api.ApiProxy;
import data.dataBaseLayer.DBResultSetInterface;
import data.dataBaseLayer.DatabaseAbstractionInterface;
import dataModel.column.ColumnStructureInterface;
import dataModel.condition.ConditionInterface;
import dataModel.condition.Sorting;
import dataModel.condition.filter.FilterInterface;
import dataModel.databaseLayer.DBKeyInterface;
import dataModel.table.DataObjectInterface;
import dataModel.table.DataTableInterface;

import java.util.ArrayList;
import java.util.List;

/*******************************************************************
 *
 *              App engine implementation of database
 *              using the data store
 */

public class AppengineDatastore implements DatabaseAbstractionInterface {


    public DBKeyInterface createKey(Object data) {

        return new AppEngineKey((String)data);

    }

    /***********************************************************
     *
     *      For the appstore implementation, there is no table to create,
     *      but we need to remove all existing values
     *
     *
     * @param dataTable     - the table
     * @return
     */

    public boolean createTable(DataTableInterface dataTable) {

        //TODO: delete existing values not implemented

        int deleted = deleteAll(dataTable.getTableName());

        return (deleted >= 0);

    }

    public DBKeyInterface store(DataObjectInterface object, Object[] par) throws BackOfficeException{


        Entity entity = createEntity(object, par);
        return storeEntity(entity);

    }

    //TODO: Check so that the update actually did work

    public boolean update(DataObjectInterface object, Object[] parameters) throws BackOfficeException{

        try{

            DatastoreService dataStore = DatastoreServiceFactory.getDatastoreService();
            AppEngineKey appKey = (AppEngineKey)object.getKey();
            Entity entity = dataStore.get(appKey.key);
            System.out.println("Updating entity with key " + object.getKey().toString());
            entity = createEntity(entity, object, parameters);
            storeEntity(entity);
            return true;

        }catch(EntityNotFoundException e){

            PukkaLogger.log(LogLevel.ERROR, "Entity not found in update");
            return false;
        }
    }


    public DBResultSetInterface load(String tableName, ConditionInterface condition, boolean useReferences) throws BackOfficeException {

       try{

           DatastoreService dataStore = DatastoreServiceFactory.getDatastoreService();
           Query q = getQuery(condition, tableName);
           PreparedQuery pq = dataStore.prepare(q);

           //PukkaLogger.log(PukkaLogger.Level.INFO, "Using Query: " + q.toString());

           return  new AppEngineResultSet(pq.asIterable(), tableName, useReferences);

       }catch(DatastoreNeedIndexException e){

           // Special case for Google App engine. The indexes have to be created manually,
           // but this is not seen on the dev server

           PukkaLogger.log(e);
           throw new BackOfficeException(BackOfficeException.Type.GENERIC, "The system is down for maintenance. Please try again later");

       }catch(ApiProxy.OverQuotaException e){

           // For non-paid apps, this may happen. Live server should of course not have this issue....

           PukkaLogger.log(e);
           throw new BackOfficeException(BackOfficeException.Type.GENERIC, "The system is down for maintenance. Please try again later");

       }

    }


    private Entity createEntity(DataObjectInterface object, Object[] par) throws BackOfficeException {

        Entity newEntity = new Entity(object.getTableName());
        return createEntity(newEntity, object, par);

    }


    private Entity createEntity(Entity entity, DataObjectInterface object, Object[] data) throws BackOfficeException {

        ColumnStructureInterface[] structure = object.getStructure();

        int index = 0;

        for(ColumnStructureInterface column : structure){


            switch (column.getType()) {


                case Reference:

                    String key = ((DBKeyInterface)data[index++]).toString();
                    entity.setProperty(column.getName(), key);
                    break;

                case String:

                    String stringData = (String)data[index++];
                    // String is limited to 500 chars. Attempting to store a larger string will fail so we truncate it

                    if(stringData != null && stringData.length() > 500)
                        stringData= stringData.substring(0, 496) + "...";

                    entity.setProperty(column.getName(), stringData);
                    break;

                case Int:

                    int intData = (Integer)data[index++];
                    entity.setProperty(column.getName(), intData);
                    break;


                default:
                    throw new BackOfficeException(BackOfficeException.Type.NOT_IMPLEMENTED, "Unknown Column type " + column.getType());
            }

            /*

                case IMAGE:
                case STRING:
                case CLASS:

                    StringData stringData = (StringData)data[index++];

                    // String is limited to 500 chars. Attempting to store a larger string will fail so we truncate it

                    if(stringData.value != null && stringData.value.length() > 500)
                        stringData.value = stringData.value.substring(0, 496) + "...";

                    entity.setProperty(column.getName(), stringData.getStringValue());

                    break;

                case TEXT:

                    TextData textData = (TextData)data[index++];

                        entity.setProperty(column.getName(), new Text(textData.getStringValue()));

                    break;

                case BLOB:

                    BlobData blobData = (BlobData)data[index++];

                        entity.setProperty(column.getName(), new Text(blobData.getStringValue()));

                    break;

                case TABLE:

                    ReferenceData refData = (ReferenceData)data[index++];

                    if(refData == null){

                        // Cannot store with a reference that is null

                        throw new BackOfficeException(BackOfficeException.Usage, "NULL in Table reference for column " + column.getName() + " in table " + object.getTable().getTableName());

                    }

                    entity.setProperty(column.getName(), refData.getStringValue());
                    break;

                case CURRENCY:

                    CurrencyData currencyData = (CurrencyData)data[index++];
                    entity.setProperty(column.getName(), currencyData.value);
                    break;

                case INT:

                    IntData intData = (IntData)data[index++];
                    entity.setProperty(column.getName(), intData.value);
                    break;

                case CONSTANT:
                    ConstantData constantData = (ConstantData)data[index++];
                    entity.setProperty(column.getName(), constantData.value);
                    break;

                case BOOLEAN:

                    BoolData boolData = (BoolData)data[index++];
                    entity.setProperty(column.getName(), (boolData.value ? "true" : "false"));

                    break;

                case DATE:

                    DateData dateData = (DateData)data[index++];
                    entity.setProperty(column.getName(), dateData.value);
                    break;



                case AUTOTIME:

                        // TODO: Store auto time doesn't work

                case TIME:
                case TIMESTAMP:

                    TimeStampData timeStampData = (TimeStampData)data[index++];
                    entity.setProperty(column.getName(), timeStampData.value);
                    break;


                default:
                    throw new BackOfficeException(BackOfficeException.TableError, "Unknown Column type " + column.getType());
            }
            */

        }

        return entity;

    }

    private DBKeyInterface storeEntity(Entity entity) throws BackOfficeException{

        DatastoreService dataStore = DatastoreServiceFactory.getDatastoreService();
        Key key = dataStore.put(entity);

        return new AppEngineKey(key);

    }


    /***************************************************************
     *
     *          Deleting all from the table
     *
     *
     * @return
     */

    private int deleteAll(String table){

        try{

            System.out.println("Deleting all from " + table);

            DatastoreService dataStore = DatastoreServiceFactory.getDatastoreService();

            Query delete = new Query(table);
            int deleted = 0;
            PreparedQuery pq = dataStore.prepare(delete);

            List<Key> killList = new ArrayList<Key>();

            for (Entity result : pq.asIterable()) {
                killList.add(result.getKey());
                deleted++;
            }

            System.out.println("Deleting " + deleted + " items from table " + table);

            dataStore.delete(killList);

            return deleted;

        }catch(Exception e){

            PukkaLogger.log( e );
            return -1;
        }
    }


    /*********************************************************************************
     *
     *      Create and build a query based on the condition.
     *
     * @param condition
     * @param tableName
     * @return              - the Query with the condition
     *
     * @throws BackOfficeException
     *
     *
     *                           //TODO: Add a check that the filter column contains valid column names. (Common mistake)
     *                           //TODO: Range filter not implemented
     *                           //TODO: DistinctFilter not implemented
     */

    private Query getQuery(ConditionInterface condition, String tableName){

        Query query = new Query(tableName);

        for(FilterInterface filter : condition.getFilters()){

            //PukkaLogger.log(PukkaLogger.Level.INFO, "Filter:" + filter.getColumn() + "=" + filter.getValue());

            /*

            if(filter instanceof DistinctFilter){

                uniqueByColumn = filter.getColumn();

            }

            if(filter instanceof RangeFilter){

                query.addFilter(((RangeFilter) filter).from.getColumn(), ((RangeFilter)filter).from.getOperator(), ((RangeFilter)filter).from.getValue());
                query.addFilter(((RangeFilter) filter).to.getColumn(), ((RangeFilter)filter).to.getOperator(), ((RangeFilter)filter).to.getValue());

            }else{

                query.addFilter(filter.getColumn(), filter.getOperator(), filter.getValue());
                //System.out.println(" *** Adding filter: " + filter.getColumn() + " " + filter.getOperator().toString() + " " + filter.getValue() );
            }

            */

        }

        Sorting sorting = condition.getSorting();

        switch (sorting.ordering) {

            case NONE:
                break;

            case FIRST_FIRST:

                query.addSort(sorting.column, Query.SortDirection.ASCENDING);
                break;

            case LAST_FIRST:
                query.addSort(sorting.column, Query.SortDirection.DESCENDING);
                break;

        }

        return query;

    }

}
