package by.vsu.emdsproject.dao;

import by.vsu.emdsproject.common.Transliterator;
import com.mongodb.*;

public class TeacherDAO extends MongoDAO {

    public static final String IS_CHIEF = "is_chief";

    @Override
    public String getCollectionName() {
        return "teacher";
    }

    public void save(DBObject teacher) {
        if (!teacher.containsField(IDENTITY)) {
            teacher.put(IDENTITY, generateLogin(teacher));
            teacher.put("password", "12345");
            teacher.put(IS_CHIEF, false);
            teacher.put("default_password", true);
        }
        collection.save(teacher);
    }

    public void chooseChief(String id) {
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

    public DBObject readChief() {
        return collection.findOne(new BasicDBObject(IS_CHIEF, true));
    }

    public long getCount() {
        return collection.getCount();
    }

    public BasicDBList readAllForSelect() {
        DBObject field = new BasicDBObject();
        field.put("last_name", 1);
        field.put("first_name", 1);
        field.put("middle_name", 1);
        field.put("rank", 1);
        field.put("is_chief", 1);
        return readAll(field);
    }

    private String generateLogin(DBObject teacher) {
        String first_name = (String) teacher.get("first_name");
        String last_name = (String) teacher.get("last_name");
        String middle_name = (String) teacher.get("middle_name");
        return Transliterator.transliterate(last_name + first_name.charAt(0) + middle_name.charAt(0));
    }
}
