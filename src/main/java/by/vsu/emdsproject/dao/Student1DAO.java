package by.vsu.emdsproject.dao;

import com.mongodb.*;

public class Student1DAO extends MongoDAO {

    public static final String STUDENT_COLLECTION_NAME = "student";
    public static final String STUDENT1 = "student1";
    public static final String STUDENT2 = "student2";

    public String getCollectionName() {
        return STUDENT_COLLECTION_NAME;
    }

    public void addNewStudent(DBObject student, String groupId) {
        student.put("group", groupId);
        database.getCollection(STUDENT_COLLECTION_NAME).save(student);
        String id = student.get("_id").toString();
        addFilterValue("student", STUDENT1, id);
        database.getCollection(FILTER_COLLECTION_NAME)
                .update(new BasicDBObject("_id", "student"), new BasicDBObject("$addToSet", new BasicDBObject(STUDENT1, id)), true, false);
        database.getCollection(FILTER_COLLECTION_NAME)
                .update(new BasicDBObject("_id", "group"), new BasicDBObject("$addToSet", new BasicDBObject(groupId, id)), true, false);
    }

    @Override
    public BasicDBList readAll() {
        BasicDBList result = new BasicDBList();
        DBObject studentFilter = database.getCollection(FILTER_COLLECTION_NAME)
                .findOne(new BasicDBObject("_id", "student"), new BasicDBObject(STUDENT1, 1));
        if (studentFilter != null && studentFilter.containsField(STUDENT1)) {
            BasicDBList ids = (BasicDBList) studentFilter.get(STUDENT1);
            result = readObjectsByIds(STUDENT_COLLECTION_NAME, ids);
        }
        return result;
    }

    @Override
    public void delete(String id) {
        DBObject student = read(id);
        String groupId = student.get("group").toString();
        database.getCollection(FILTER_COLLECTION_NAME)
                .update(new BasicDBObject("_id", "student"), new BasicDBObject("$pull", new BasicDBObject(STUDENT1, id)), true, false);
        database.getCollection(FILTER_COLLECTION_NAME)
                .update(new BasicDBObject("_id", "group"), new BasicDBObject("$pull", new BasicDBObject(groupId, id)), true, false);
        super.delete(id);
    }

    public void promote(String id, String groupId) {
        DBObject student = read(id);
        String oldGroupId = student.get("group").toString();
        database.getCollection(FILTER_COLLECTION_NAME)
                .update(new BasicDBObject("_id", "student"), new BasicDBObject("$pull", new BasicDBObject(STUDENT1, id)), true, false);
        database.getCollection(FILTER_COLLECTION_NAME)
                .update(new BasicDBObject("_id", "student"), new BasicDBObject("$addToSet", new BasicDBObject(STUDENT2, id)), true, false);
        database.getCollection(FILTER_COLLECTION_NAME)
                .update(new BasicDBObject("_id", "group"), new BasicDBObject("$pull", new BasicDBObject(oldGroupId, id)), true, false);
        database.getCollection(FILTER_COLLECTION_NAME)
                .update(new BasicDBObject("_id", "group"), new BasicDBObject("$addToSet", new BasicDBObject(groupId, id)), true, false);
    }
}
