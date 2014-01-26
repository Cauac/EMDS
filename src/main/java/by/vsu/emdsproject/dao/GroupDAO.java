package by.vsu.emdsproject.dao;

import com.mongodb.BasicDBObject;

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
}
