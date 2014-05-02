package by.vsu.emdsproject.dao;

import com.mongodb.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Required;

public abstract class MongoBean implements InitializingBean {

    public static final String IDENTITY = "_id";
    public static final String FILTER_COLLECTION_NAME = "filter";
    private MongoClient mongoClient;
    private String dbName;
    protected DB database;
    protected DBCollection collection;

    public abstract String getCollectionName();

    protected void addFilterValue(String filterName, String listName, String id) {
        database.getCollection(FILTER_COLLECTION_NAME)
                .update(new BasicDBObject("_id", filterName), new BasicDBObject("$push", new BasicDBObject(listName, id)), true, false);
    }

    protected void removeFilterValue(String filterName, String listName, String id) {
        database.getCollection(FILTER_COLLECTION_NAME)
                .update(new BasicDBObject("_id", filterName), new BasicDBObject("$pull", new BasicDBObject(listName, id)), true, false);
    }

    protected BasicDBList getFilterIds(String filterName, String listName) {
        BasicDBList result = new BasicDBList();
        DBObject filter = database.getCollection(FILTER_COLLECTION_NAME)
                .findOne(new BasicDBObject("_id", filterName), new BasicDBObject(listName, 1));
        if (filter != null && filter.containsField(listName)) {
            result = (BasicDBList) filter.get(listName);
        }
        return result;
    }

    @Required
    public void setMongoClient(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    @Required
    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        database = mongoClient.getDB(dbName);
        collection = database.getCollection(getCollectionName());
    }
}
