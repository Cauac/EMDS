package by.vsu.emdsproject.dao.filter;

import by.vsu.emdsproject.dao.MongoBean;
import com.mongodb.BasicDBList;
import com.mongodb.DBObject;

public class AbiturientFacultyFilter implements Filter {

    private final String FACULTY = "faculty";
    private final String FILTER_NAME = "abiturient_faculty_filter";
    private FilterDAO dao;

    public AbiturientFacultyFilter(FilterDAO dao) {
        this.dao = dao;
    }

    @Override
    public void add(DBObject object) {
        String faculty = object.get(FACULTY).toString();
        Object id = object.get(MongoBean.IDENTITY);
        dao.addFilterValue(FILTER_NAME, faculty, id);
    }

    @Override
    public void remove(DBObject object) {
        String faculty = object.get(FACULTY).toString();
        String id = object.get(MongoBean.IDENTITY).toString();
        dao.removeFilterValue(FILTER_NAME, faculty, id);
    }

    @Override
    public BasicDBList filter(String key) {
        return dao.getFilterIds(FILTER_NAME, key);
    }
}
