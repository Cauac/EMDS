package by.vsu.emdsproject.dao;

import com.mongodb.BasicDBList;
import com.mongodb.DBCollection;

public class JuniorDAO extends MongoDAO {

    public static final String STUDENT_COLLECTION_NAME = "student";

    public String getCollectionName() {
        return STUDENT_COLLECTION_NAME;
    }
}
