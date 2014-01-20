package by.vsu.emdsproject.dao;

import by.vsu.emdsproject.common.Transliterator;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public class AbiturientDAO extends MongoDAO {

    public static final String ABITURIENT_COLLECTION_NAME = "abiturient";

    @Override
    public String getCollectionName() {
        return ABITURIENT_COLLECTION_NAME;
    }

    @Override
    public void save(DBObject abiturient) {
        if (!abiturient.containsField(IDENTITY)) {
            abiturient.put(IDENTITY, generateIdentity(abiturient));
        }
        super.save(abiturient);

    }

    public void saveDocument(String abiturientId, String documentType, DBObject document) {
        DBCollection collection = database.getCollection(getCollectionName());
        DBObject query = new BasicDBObject("_id", abiturientId);
        DBObject field = new BasicDBObject("document." + documentType, document);
        collection.update(query, new BasicDBObject("$set", field), true, true);
    }

    public void saveQuestionnaire(String abiturientId, DBObject questionnaire) {
        DBCollection collection = database.getCollection(getCollectionName());
        DBObject query = new BasicDBObject("_id", abiturientId);
        DBObject field = new BasicDBObject("questionnaire", questionnaire);
        collection.update(query, new BasicDBObject("$set", field), true, true);
    }

    private String generateIdentity(DBObject abiturient) {
        String first_name = (String) abiturient.get("first_name");
        String last_name = (String) abiturient.get("last_name");
        String middle_name = (String) abiturient.get("middle_name");
        String identity = Transliterator.transliterate(last_name + first_name.charAt(0) + middle_name.charAt(0));
        return identity + System.currentTimeMillis();
    }
}
