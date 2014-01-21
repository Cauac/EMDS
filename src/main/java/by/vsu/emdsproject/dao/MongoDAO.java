package by.vsu.emdsproject.dao;

import com.mongodb.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Required;

import java.util.Collection;

public abstract class MongoDAO implements InitializingBean {

    public static final String IDENTITY = "_id";
    public static final String FILTER_COLLECTION_NAME = "filter";
    private MongoClient mongoClient;
    private String dbName;
    protected DB database;

    public abstract String getCollectionName();

    public DBObject read(String identity) {
        return database.getCollection(getCollectionName()).findOne(new BasicDBObject(IDENTITY, identity));
    }

    public BasicDBList readAll() {
        DBCursor cursor = database.getCollection(getCollectionName()).find();
        BasicDBList result = new BasicDBList();
        while (cursor.hasNext()) {
            result.add(cursor.next());
        }
        return result;
    }

    public void save(DBObject object) {
        database.getCollection(getCollectionName()).save(object);
    }

    public void delete(String id) {
        database.getCollection(getCollectionName()).remove(new BasicDBObject(IDENTITY, id));
    }

    protected BasicDBList readObjectsByIds(String collectionName, Collection ids) {
        BasicDBList result = new BasicDBList();
        DBCursor cursor = database.getCollection(collectionName).find(new BasicDBObject("_id", new BasicDBObject("$in", ids)));
        try {
            while (cursor.hasNext()) {
                result.add(cursor.next());
            }
        } finally {
            cursor.close();
        }
        return result;
    }

    protected void addFilterValue(String filterName, String listName, String id) {
        database.getCollection(FILTER_COLLECTION_NAME)
                .update(new BasicDBObject("_id", filterName), new BasicDBObject("$addToSet", new BasicDBObject(listName, id)), true, false);
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
    }
}
