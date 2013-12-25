package by.vsu.emdsproject.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class TeacherDAO extends MongoDAO {

    public static final String USER_COLLECTION_NAME = "teacher";

    public DBObject read(String username) {
        return database.getCollection(USER_COLLECTION_NAME).findOne(new BasicDBObject("_id", username));
    }

}
