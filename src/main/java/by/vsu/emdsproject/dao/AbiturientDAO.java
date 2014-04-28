package by.vsu.emdsproject.dao;

import by.vsu.emdsproject.common.ReportUtil;
import by.vsu.emdsproject.dao.filter.Filter;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class AbiturientDAO extends MongoDAO {

    @Autowired
    public Filter abiturientFacultyFilter;

    @Override
    public String getCollectionName() {
        return "abiturient";
    }

    public DBObject getPerPage(int page, int perPage, String faculty) {
        if (!faculty.isEmpty()) {
            BasicDBList ids = abiturientFacultyFilter.filter(faculty);
            return readList(page, perPage, (List) ids);
        } else {
            return readList(page, perPage);
        }
    }

    @Override
    public void insert(DBObject object) {
        super.insert(object);
        abiturientFacultyFilter.add(object);
    }

    @Override
    public void update(DBObject object) {
        abiturientFacultyFilter.remove(getOldValue(object));
        super.update(object);
        abiturientFacultyFilter.add(object);
    }

    @Override
    public void delete(String id) {
        abiturientFacultyFilter.remove(read(id));
        super.delete(id);
    }

    public BasicDBList readByFaculty(String faculty) {
        BasicDBList ids = abiturientFacultyFilter.filter(faculty);
        return readObjectsByIds(ids);
    }

    public void saveDocument(String abiturientId, String documentType, DBObject document) {
        updateField(abiturientId, "document." + documentType, document);
    }

    public void saveQuestionnaire(String abiturientId, DBObject questionnaire) {
        updateField(abiturientId, "questionnaire", questionnaire);
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
