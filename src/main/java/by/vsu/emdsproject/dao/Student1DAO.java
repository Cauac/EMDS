package by.vsu.emdsproject.dao;

import com.mongodb.BasicDBList;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public class Student1DAO extends MongoDAO {

    public static final String STUDENT_COLLECTION_NAME = "student1";

    public String getCollectionName() {
        return STUDENT_COLLECTION_NAME;
    }

    public void addNewStudent(DBObject student, String groupId) {
        student.put("group", groupId);
        database.getCollection(STUDENT_COLLECTION_NAME).save(student);
    }
}
