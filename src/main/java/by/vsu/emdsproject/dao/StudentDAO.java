package by.vsu.emdsproject.dao;

import com.mongodb.*;

public class StudentDAO extends MongoDAO {

    public static final String STUDENT_COLLECTION_NAME = "student";
    public static final String STUDENT1 = "student1";
    public static final String STUDENT2 = "student2";

    public String getCollectionName() {
        return STUDENT_COLLECTION_NAME;
    }

    public void addStudent(DBObject student, String groupId) {
        student.put("group", groupId);
        database.getCollection(STUDENT_COLLECTION_NAME).save(student);
        String id = student.get("_id").toString();
        addFilterValue("student", STUDENT1, id);
        addFilterValue("group", groupId, id);
    }

    public BasicDBList readAll(String type) {
        BasicDBList studentIds = getFilterIds("student", type);
        return readObjectsByIds(STUDENT_COLLECTION_NAME, studentIds);
    }

    public BasicDBList readByGroup(String groupId) {
        BasicDBList studentIds = getFilterIds("group", groupId);
        return readObjectsByIds(STUDENT_COLLECTION_NAME, studentIds);
    }

    public BasicDBList readByGroupForSelect(String groupId) {
        DBObject field = new BasicDBObject();
        field.put("last_name", 1);
        field.put("first_name", 1);
        BasicDBList studentIds = getFilterIds("group", groupId);
        return readObjectsByIds(STUDENT_COLLECTION_NAME, studentIds, field);
    }

    public void delete(String id, String type) {
        DBObject student = read(id);
        String groupId = student.get("group").toString();
        removeFilterValue("student", type, id);
        removeFilterValue("group", groupId, id);
        super.delete(id);
    }

    public void promote(String id, String groupId) {
        DBObject student = read(id);
        String oldGroupId = student.get("group").toString();
        addFilterValue("student", STUDENT2, id);
        addFilterValue("group", groupId, id);
        removeFilterValue("student", STUDENT1, id);
        removeFilterValue("group", oldGroupId, id);
        updateField(id, "group", groupId);
    }

}
