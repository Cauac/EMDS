package by.vsu.emdsproject.dao;

import by.vsu.emdsproject.common.Transliterator;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
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
        updateField(abiturientId, "document." + documentType, document);
    }

    public void saveQuestionnaire(String abiturientId, DBObject questionnaire) {
        updateField(abiturientId,"questionnaire",questionnaire);
    }

    public BasicDBList readByFaculty(String faculty) {
        DBObject query = new BasicDBObject("faculty", faculty);
        DBCursor cursor = database.getCollection(getCollectionName()).find(query);
        BasicDBList result = new BasicDBList();
        while (cursor.hasNext()) {
            result.add(cursor.next());
        }
        return result;
    }

    private String generateIdentity(DBObject abiturient) {
        String first_name = (String) abiturient.get("first_name");
        String last_name = (String) abiturient.get("last_name");
        String middle_name = (String) abiturient.get("middle_name");
        String identity = Transliterator.transliterate(last_name + first_name.charAt(0) + middle_name.charAt(0));
        return identity + System.currentTimeMillis();
    }
}
