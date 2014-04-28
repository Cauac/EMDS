package by.vsu.emdsproject.dao.filter;

import by.vsu.emdsproject.dao.MongoBean;
import com.mongodb.BasicDBList;
import com.mongodb.DBObject;

public class ArchiveStatusFilter implements Filter {

    private final String STATUS = "status";
    private final String FILTER_NAME = "archive_faculty_filter";
    private FilterDAO dao;

    public ArchiveStatusFilter(FilterDAO dao) {
        this.dao = dao;
    }

    @Override
    public void add(DBObject object) {
        String faculty = object.get(STATUS).toString();
        String id = object.get(MongoBean.IDENTITY).toString();
        dao.addFilterValue(FILTER_NAME, faculty, id);
    }

    @Override
    public void remove(DBObject object) {
        String faculty = object.get(STATUS).toString();
        String id = object.get(MongoBean.IDENTITY).toString();
        dao.removeFilterValue(FILTER_NAME, faculty, id);
    }

    @Override
    public BasicDBList filter(String key) {
        return dao.getFilterIds(FILTER_NAME, key);
    }
}
