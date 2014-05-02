package by.vsu.emdsproject.dao;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import java.util.Collection;
import java.util.List;

public abstract class MongoDAO extends MongoBean {

    public DBObject read(String identity) {
        return collection.findOne(new BasicDBObject(IDENTITY, identity));
    }

    public BasicDBList readAll() {
        DBCursor cursor = collection.find();
        BasicDBList result = new BasicDBList();
        while (cursor.hasNext()) {
            result.add(cursor.next());
        }
        return result;
    }

    public BasicDBList readAll(DBObject field) {
        DBCursor cursor = collection.find(null, field);
        BasicDBList result = new BasicDBList();
        while (cursor.hasNext()) {
            result.add(cursor.next());
        }
        return result;
    }

    public void insert(DBObject object) {
        collection.insert(object);
    }

    public void update(DBObject object) {
        collection.save(object);
    }

    public void save(DBObject object) {
        collection.save(object);
    }

    public void delete(String id) {
        collection.remove(new BasicDBObject(IDENTITY, id));
    }

    public void updateField(String id, String fieldName, Object value) {
        DBObject query = new BasicDBObject("_id", id);
        DBObject field = new BasicDBObject(fieldName, value);
        collection.update(query, new BasicDBObject("$set", field), true, false);
    }

    protected DBObject getOldValue(DBObject object) {
        return read(object.get(IDENTITY).toString());
    }

    protected BasicDBList readObjectsByIds(Collection ids) {
        BasicDBList result = new BasicDBList();
        DBCursor cursor = collection.find(new BasicDBObject("_id", new BasicDBObject("$in", ids)));
        try {
            while (cursor.hasNext()) {
                result.add(cursor.next());
            }
        } finally {
            cursor.close();
        }
        return result;
    }

    protected BasicDBList readObjectsByIds(Collection ids, DBObject fields) {
        BasicDBList result = new BasicDBList();
        DBCursor cursor = collection.find(new BasicDBObject("_id", new BasicDBObject("$in", ids)), fields);
        try {
            while (cursor.hasNext()) {
                result.add(cursor.next());
            }
        } finally {
            cursor.close();
        }
        return result;
    }

    protected DBObject readList(int page, int perPage) {
        DBCursor cursor = collection.find();
        DBObject list = new BasicDBObject("totalCount", cursor.count());
        cursor.sort(new BasicDBObject("_id", 1)).skip((page - 1) * perPage).limit(perPage);
        BasicDBList data = new BasicDBList();
        try {
            while (cursor.hasNext()) {
                data.add(cursor.next());
            }
            list.put("data", data);
        } finally {
            cursor.close();
        }
        return data;
    }

    protected DBObject readList(int page, int perPage, List ids) {
        DBObject list = new BasicDBObject("totalCount", ids.size());
        List<Object> idsPerPage = ids.subList(page * perPage, page * perPage + perPage);
        list.put("data", readObjectsByIds(idsPerPage));
        return list;
    }
}
