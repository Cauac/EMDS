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

    public BasicDBList readAll(DBObject field) {
        DBCursor cursor = database.getCollection(getCollectionName()).find(null, field);
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

    public void updateField(String id, String fieldName, Object value) {
        DBCollection collection = database.getCollection(getCollectionName());
        DBObject query = new BasicDBObject("_id", id);
        DBObject field = new BasicDBObject(fieldName, value);
        collection.update(query, new BasicDBObject("$set", field), true, false);
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

    protected BasicDBList readObjectsByIds(String collectionName, Collection ids, DBObject fields) {
        BasicDBList result = new BasicDBList();
        DBCursor cursor = database.getCollection(collectionName).find(new BasicDBObject("_id", new BasicDBObject("$in", ids)), fields);
        try {
            while (cursor.hasNext()) {
                result.add(cursor.next());
            }
        } finally {
            cursor.close();
        }
        return result;
    }

    protected DBObject readList(int page, int perPage, DBObject query) {
        DBCursor cursor = database.getCollection(getCollectionName()).find(query);
        DBObject list = new BasicDBObject("totalCount", cursor.count());
        cursor.skip((page - 1) * perPage).limit(perPage);
        BasicDBList data = new BasicDBList();
        try {
            while (cursor.hasNext()) {
                data.add(cursor.next());
            }
            list.put("data", data);
        } finally {
            cursor.close();
        }
        return list;
    }

    protected DBObject readList(Collection ids, int page, int perPage, DBObject query) {
        DBObject q = new BasicDBObject("_id", new BasicDBObject("$in", ids));
        q.putAll(query);
        DBCursor cursor = database.getCollection(getCollectionName()).find(q);
        DBObject list = new BasicDBObject("totalCount", cursor.count());
        cursor.skip((page - 1) * perPage).limit(perPage);
        BasicDBList data = new BasicDBList();
        try {
            while (cursor.hasNext()) {
                data.add(cursor.next());
            }
            list.put("data", data);
        } finally {
            cursor.close();
        }
        return list;
    }

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
    }
}
