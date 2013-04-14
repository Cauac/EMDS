package by.vsu.emdsproject.test;

import by.vsu.emdsproject.model.Document;
import by.vsu.emdsproject.model.DocumentInfo;
import by.vsu.emdsproject.model.Student;
import by.vsu.emdsproject.service.DocumentInfoService;
import by.vsu.emdsproject.service.DocumentService;
import by.vsu.emdsproject.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * @author Max
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/emds-web-context.xml"})
public class StudentTest {

    @Autowired
    StudentService studentService;
    @Autowired
    DocumentService documentService;
    @Autowired
    DocumentInfoService documentInfoService;

    @Test
    public void test() {
        Student student = new Student();
        student.setFirstName("123");
        student.setLastName("123");
        student.setMiddleName("123");
        studentService.add(student);

        Student student2 = studentService.read(student.getId());
        assertEquals(student.getFirstName(), student2.getFirstName());
        for (Map.Entry<Document, DocumentInfo> entry : student.getDocuments().entrySet()) {
            DocumentInfo first = student.getDocuments().get(entry.getKey());
            DocumentInfo second = student2.getDocuments().get(entry.getKey());
            assertEquals(first, second);
        }

        Student student3 = studentService.read(student.getId());
        assertFalse(student3.getDocuments().size() == 0);

        studentService.remove(student2);
    }

}
