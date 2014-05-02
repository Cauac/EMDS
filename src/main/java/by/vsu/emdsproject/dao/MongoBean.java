package by.vsu.emdsproject.dao;

import com.mongodb.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Required;

public abstract class MongoBean implements InitializingBean {

    public static final String IDENTITY = "_id";
    private MongoClient mongoClient;
    private String dbName;
    protected DB database;
    protected DBCollection collection;

    public abstract String getCollectionName();

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
