package by.vsu.emdsproject.test;

import by.vsu.emdsproject.service.SpecialtyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IntelliJ IDEA.
 * User: Max
 * Date: 24.03.13
 * Time: 0:02
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/emds-web-context.xml"})
public class SpecialtyTest {

    @Autowired
    SpecialtyService specialtyService;

    @Test
    public void writeReadTest() {
       /* Specialty specialty = new Specialty();
        specialty.setTitle("specialty");
        specialty = specialtyService.add(specialty);
        assertTrue("Specialty id shouldn't be null after persist", specialty.getId() != null);

        Specialty specialty1 = specialtyService.read(specialty.getId());
        assertEquals("Specialties should have equal titles", specialty.getTitle(), specialty1.getTitle());

        String newTitle = "newTitle";
        specialty1.setTitle(newTitle);
        specialty1 = specialtyService.update(specialty1);
        assertEquals("Title wasn't changed", specialtyService.read(specialty.getId()).getTitle(), newTitle);

        specialtyService.remove(specialty1.getId());
        assertEquals("Specialty wasn't removed", specialtyService.read(specialty1.getId()), null);*/
    }

}
