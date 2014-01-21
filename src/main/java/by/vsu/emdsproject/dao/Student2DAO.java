package by.vsu.emdsproject.dao;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Student2DAO extends MongoDAO {

    public static final String STUDENT_COLLECTION_NAME = "student";
    public static final String STUDENT2 = "student2";

    public String getCollectionName() {
        return STUDENT_COLLECTION_NAME;
    }

    public void addNewStudent(DBObject student, String groupId) {
        student.put("group", groupId);
        database.getCollection(STUDENT_COLLECTION_NAME).save(student);
    }

    @Override
    public BasicDBList readAll() {
        BasicDBList result = new BasicDBList();
        DBObject studentFilter = database.getCollection(FILTER_COLLECTION_NAME)
                .findOne(new BasicDBObject("_id", "student"), new BasicDBObject(STUDENT2, 1));
        if (studentFilter != null && studentFilter.containsField(STUDENT2)) {
            BasicDBList ids = (BasicDBList) studentFilter.get(STUDENT2);
            result = readObjectsByIds(STUDENT_COLLECTION_NAME, ids);
        }
        return result;
    }
}
