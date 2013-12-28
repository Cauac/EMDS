package by.vsu.emdsproject.dao;

import com.mongodb.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Required;

public abstract class MongoDAO implements InitializingBean {

    public static final String IDENTITY = "_id";
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
