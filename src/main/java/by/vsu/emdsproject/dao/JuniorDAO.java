package by.vsu.emdsproject.dao;

import com.mongodb.BasicDBList;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public class JuniorDAO extends MongoDAO {

    public static final String STUDENT_COLLECTION_NAME = "student";

    public String getCollectionName() {
        return STUDENT_COLLECTION_NAME;
    }

    public void addNewStudent(DBObject student, String groupId) {

    }
}
