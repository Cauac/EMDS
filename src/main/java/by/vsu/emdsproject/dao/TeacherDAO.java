package by.vsu.emdsproject.dao;

import by.vsu.emdsproject.common.Transliterator;
import com.mongodb.*;

public class TeacherDAO extends MongoDAO {

    public static final String TEACHER_COLLECTION_NAME = "teacher";
    public static final String IS_CHIEF = "is_chief";

    @Override
    public String getCollectionName() {
        return TEACHER_COLLECTION_NAME;
    }

    public void save(DBObject teacher) {
        if (!teacher.containsField(IDENTITY)) {
            teacher.put(IDENTITY, generateLogin(teacher));
            teacher.put("password", "12345");
            teacher.put(IS_CHIEF, false);
            teacher.put("default_password", true);
        }
        database.getCollection(TEACHER_COLLECTION_NAME).save(teacher);
    }

    public void chooseChief(String id) {
        DBCollection collection = database.getCollection(TEACHER_COLLECTION_NAME);
        DBObject currentChief = collection.findOne(new BasicDBObject(IS_CHIEF, true));
        if (currentChief != null) {
            if (id.equals(currentChief.get(IDENTITY))) {
                return;
            }
            currentChief.put(IS_CHIEF, false);
            collection.save(currentChief);
        }
        DBObject newChief = collection.findOne(new BasicDBObject(IDENTITY, id));
        newChief.put(IS_CHIEF, true);
        collection.save(newChief);
    }

    private String generateLogin(DBObject teacher) {
        String first_name = (String) teacher.get("first_name");
        String last_name = (String) teacher.get("last_name");
        String middle_name = (String) teacher.get("middle_name");
        return Transliterator.transliterate(last_name + first_name.charAt(0) + middle_name.charAt(0));
    }

}
