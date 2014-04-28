package by.vsu.emdsproject.dao;

import by.vsu.emdsproject.dao.filter.Filter;
import com.mongodb.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class StudentDAO extends MongoDAO {

    @Autowired
    Filter studentFacultyFilter;
    @Autowired
    Filter groupFilter;
    @Autowired
    Filter student1Filter;
    @Autowired
    Filter student2Filter;

    public String getCollectionName() {
        return "student";
    }

    public void addStudent(DBObject student, String groupId) {
        student.put("group", groupId);
        collection.save(student);
        studentFacultyFilter.add(student);
        groupFilter.add(student);
        student1Filter.add(student);
    }

    public DBObject readListStudent1(int page, int perPage, String faculty, String group) {
        Set set = new HashSet(student1Filter.filter(""));
        if (!group.isEmpty()) {
            set.removeAll(groupFilter.filter(group));
        }
        if (!faculty.isEmpty()) {
            set.removeAll(studentFacultyFilter.filter(faculty));
        }
        return readList(page, perPage, new ArrayList(set));
    }

    public DBObject readListStudent2(int page, int perPage, String faculty, String group) {
        Set set = new HashSet(student2Filter.filter(""));
        if (!group.isEmpty()) {
            set.removeAll(groupFilter.filter(group));
        }
        if (!faculty.isEmpty()) {
            set.removeAll(studentFacultyFilter.filter(faculty));
        }
        return readList(page, perPage, new ArrayList(set));
    }

    public BasicDBList readByGroup(String groupId) {
        BasicDBList filter = groupFilter.filter(groupId);
        return readObjectsByIds(filter);
    }

    public BasicDBList readByGroupForSelect(String groupId) {
        DBObject field = new BasicDBObject();
        field.put("last_name", 1);
        field.put("first_name", 1);
        BasicDBList filter = groupFilter.filter(groupId);
        return readObjectsByIds(filter, field);
    }

    public void delete(String id) {
        DBObject student = read(id);
        super.delete(id);
        studentFacultyFilter.remove(student);
        groupFilter.remove(student);
        student1Filter.remove(student);
        student2Filter.remove(student);
    }

    public void promote(String id, String groupId) {
        DBObject student = read(id);
        updateField(id, "group", groupId);
        student1Filter.remove(student);
        groupFilter.remove(student);
        student.put("group", groupId);
        student2Filter.add(student);
        groupFilter.add(student);
    }
}
