package by.vsu.emdsproject.dao;

import by.vsu.emdsproject.common.ReportUtil;
import by.vsu.emdsproject.common.Transliterator;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import org.apache.commons.lang.math.NumberUtils;

import java.util.Map;

public class AbiturientDAO extends MongoDAO {

    public static final String ABITURIENT_COLLECTION_NAME = "abiturient";

    @Override
    public String getCollectionName() {
        return ABITURIENT_COLLECTION_NAME;
    }

    public DBObject getAbiturients(int page, int perPage, String faculty) {
        if (!faculty.isEmpty()) {
            return readList(page, perPage, new BasicDBObject("faculty", faculty));
        } else {
            return readList(page, perPage, null);
        }
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
        updateField(abiturientId, "questionnaire", questionnaire);
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

    public void setProgress(Map<String, String> progressMap, String faculty) {
        String value;
        for (Object o : readByFaculty(faculty)) {
            DBObject student = (DBObject) o;
            if ((value = progressMap.get(ReportUtil.getFullFIO(student))) != null) {
                value = value.replaceAll("[^\\x20-\\x7e]", "");
                double score = NumberUtils.toDouble(value, 0.0);
                database.getCollection(getCollectionName()).update(student, new BasicDBObject("$set", new BasicDBObject("document.score.score", score)));
            }
        }
    }
}
