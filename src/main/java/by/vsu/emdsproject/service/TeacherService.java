package by.vsu.emdsproject.service;

import by.vsu.emdsproject.model.Teacher;

public interface TeacherService extends AbstractService<Teacher> {
    Teacher getChief();
}
