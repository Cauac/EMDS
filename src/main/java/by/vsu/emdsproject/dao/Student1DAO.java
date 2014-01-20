package by.vsu.emdsproject.dao;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public class Student1DAO extends MongoDAO {

    public static final String STUDENT_COLLECTION_NAME = "student";
    public static final String FILTER_COLLECTION_NAME = "filter";
    public static final String STUDENT1 = "student1";

    public String getCollectionName() {
        return STUDENT_COLLECTION_NAME;
    }

    public void addNewStudent(DBObject student, String groupId) {
        student.put("group", groupId);
        database.getCollection(STUDENT_COLLECTION_NAME).save(student);
        String id = student.get("_id").toString();
        database.getCollection(FILTER_COLLECTION_NAME)
                .update(new BasicDBObject("_id", "student"), new BasicDBObject("$addToSet", new BasicDBObject(STUDENT1, id)), true, false);
        database.getCollection(FILTER_COLLECTION_NAME)
                .update(new BasicDBObject("_id", "group"), new BasicDBObject("$addToSet", new BasicDBObject(STUDENT1, id)), true, false);
    }
}
