package by.vsu.emdsproject.dao.filter;

import by.vsu.emdsproject.dao.MongoBean;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class FilterDAO extends MongoBean {

    @Override
    public String getCollectionName() {
        return "filter";
    }

    protected void addFilterValue(String filterName, String listName, Object id) {
        collection.update(new BasicDBObject(IDENTITY, filterName),
                new BasicDBObject("$push", new BasicDBObject(listName, id)), true, false);
    }

    protected void removeFilterValue(String filterName, String listName, String id) {
        collection.update(new BasicDBObject(IDENTITY, filterName),
                new BasicDBObject("$pull", new BasicDBObject(listName, id)), true, false);
    }

    protected BasicDBList getFilterIds(String filterName, String listName) {
        BasicDBList result = new BasicDBList();
        DBObject filter = collection.findOne(new BasicDBObject(IDENTITY, filterName), new BasicDBObject(listName, 1));
        if (filter != null && filter.containsField(listName)) {
            result = (BasicDBList) filter.get(listName);
        }
        return result;
    }
}
