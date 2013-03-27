package by.vsu.emdsproject.test;

import by.vsu.emdsproject.model.Specialty;
import by.vsu.emdsproject.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: Max
 * Date: 24.03.13
 * Time: 0:02
 * To change this template use File | Settings | File Templates.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:/jpademo-web-context.xml" })
public class SpecialtyRepositoryTest {

    @Autowired
    SpecialtyRepository specialtyRepository;

    void writeReadTest() {
        Specialty specialty = new Specialty();
        specialty.setTitle("specialty1");
        specialtyRepository.save(specialty);
        //assertT
    }

}
