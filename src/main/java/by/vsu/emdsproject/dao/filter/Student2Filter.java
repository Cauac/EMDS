package by.vsu.emdsproject.dao.filter;

import by.vsu.emdsproject.dao.MongoBean;
import com.mongodb.BasicDBList;
import com.mongodb.DBObject;

public class Student2Filter implements Filter {

    private final String STUDENT1 = "student2";
    private final String FILTER_NAME = "student_filter";
    private FilterDAO dao;

    public Student2Filter(FilterDAO dao) {
        this.dao = dao;
    }

    @Override
    public void add(DBObject object) {
        String id = object.get(MongoBean.IDENTITY).toString();
        dao.addFilterValue(FILTER_NAME, STUDENT1, id);
    }

    @Override
    public void remove(DBObject object) {
        String id = object.get(MongoBean.IDENTITY).toString();
        dao.removeFilterValue(FILTER_NAME, STUDENT1, id);
    }

    @Override
    public BasicDBList filter(String key) {
        return dao.getFilterIds(FILTER_NAME, key);
    }
}
