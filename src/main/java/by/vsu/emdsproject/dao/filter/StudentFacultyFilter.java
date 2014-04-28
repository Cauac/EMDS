package by.vsu.emdsproject.dao.filter;

import by.vsu.emdsproject.dao.MongoBean;
import com.mongodb.BasicDBList;
import com.mongodb.DBObject;

public class StudentFacultyFilter implements Filter {

    private final String FACULTY = "faculty";
    private final String FILTER_NAME = "student_faculty_filter";
    private FilterDAO dao;

    public StudentFacultyFilter(FilterDAO dao) {
        this.dao = dao;
    }

    @Override
    public void add(DBObject object) {
        String faculty = object.get(FACULTY).toString();
        String id = object.get(MongoBean.IDENTITY).toString();
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
