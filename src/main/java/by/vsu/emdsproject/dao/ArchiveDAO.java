package by.vsu.emdsproject.dao;

import by.vsu.emdsproject.dao.filter.Filter;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArchiveDAO extends MongoDAO {

    @Autowired
    Filter archiveFacultyFilter;
    @Autowired
    Filter archiveStatusFilter;

    @Override
    public String getCollectionName() {
        return "archive";
    }

    public void save(DBObject object, String status) {
        object.put("status", status);
        super.save(object);
        archiveFacultyFilter.add(object);
        archiveStatusFilter.add(object);
    }

    @Override
    public void update(DBObject object) {
        DBObject oldValue = getOldValue(object);
        archiveFacultyFilter.remove(oldValue);
        archiveStatusFilter.remove(oldValue);
        super.update(object);
        archiveFacultyFilter.add(object);
        archiveStatusFilter.add(object);
    }

    @Override
    public void delete(String id) {
        super.delete(id);
        DBObject object = read(id);
        archiveFacultyFilter.remove(object);
        archiveStatusFilter.remove(object);
    }

    public DBObject readList(int page, int perPage, String faculty, String status) {
        if (!faculty.isEmpty() && !status.isEmpty()) {
            Set set = new HashSet(archiveFacultyFilter.filter(faculty));
            set.retainAll(archiveStatusFilter.filter(status));
            return readList(page, perPage, new ArrayList(set));
        }

        if (!status.isEmpty()) {
            return readList(page, perPage, (List) archiveStatusFilter.filter(status));
        }
        if (!faculty.isEmpty()) {
            return readList(page, perPage, (List) archiveFacultyFilter.filter(faculty));
        }

        return readList(page, perPage);
    }
}
