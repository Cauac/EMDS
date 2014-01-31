package by.vsu.emdsproject.dao;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class GroupDAO extends MongoDAO {

    public static final String GROUP_COLLECTION_NAME = "group";

    @Override
    public String getCollectionName() {
        return GROUP_COLLECTION_NAME;
    }

    public void updateSpecialtyRelation(String oldId, String newId) {
        BasicDBObject query = new BasicDBObject("specialty", oldId);
        BasicDBObject field = new BasicDBObject("specialty", newId);
        database.getCollection(GROUP_COLLECTION_NAME).
                update(query, new BasicDBObject("$set", field), false, true);
    }

    public BasicDBList getAllForSelect() {
        DBObject field = new BasicDBObject("_id", 1);
        return readAll(field);
    }
}
