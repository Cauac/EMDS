package by.vsu.emdsproject.dao.filter;

import com.mongodb.BasicDBList;
import com.mongodb.DBObject;

public interface Filter {

    void add(DBObject object);

    void remove(DBObject object);

    BasicDBList filter(String key);
}
