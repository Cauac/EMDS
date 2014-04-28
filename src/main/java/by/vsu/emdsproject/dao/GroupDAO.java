package by.vsu.emdsproject.dao;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class GroupDAO extends MongoDAO {

    @Override
    public String getCollectionName() {
        return "group";
    }

    public void updateSpecialtyRelation(String oldId, String newId) {
        BasicDBObject query = new BasicDBObject("specialty", oldId);
        BasicDBObject field = new BasicDBObject("specialty", newId);
        collection.update(query, new BasicDBObject("$set", field), false, true);
    }

    public BasicDBList getAllForSelect() {
        DBObject field = new BasicDBObject("_id", 1);
        return readAll(field);
    }
}
