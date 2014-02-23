package by.vsu.emdsproject.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class ArchiveDAO extends MongoDAO {

    public static final String ARCHIVE_COLLECTION_NAME = "archive";

    @Override
    public String getCollectionName() {
        return ARCHIVE_COLLECTION_NAME;
    }

    public void save(DBObject object, String status) {
        object.put("status", status);
        super.save(object);
    }

    public DBObject readList(int page, int perPage, String faculty, String status) {
        if (status.isEmpty() && faculty.isEmpty()) {
            return readList(page, perPage, null);
        }
        DBObject query = new BasicDBObject();
        if (!status.isEmpty()) {
            query.put("status", status);
        }
        if (!faculty.isEmpty()) {
            query.put("faculty", faculty);
        }
        return readList(page, perPage, query);
    }
}
