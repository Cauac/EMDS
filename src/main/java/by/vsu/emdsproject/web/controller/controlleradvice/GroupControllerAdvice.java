package by.vsu.emdsproject.web.controller.controlleradvice;

import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.model.Specialty;
import by.vsu.emdsproject.service.GroupService;
import by.vsu.emdsproject.service.SpecialtyService;
import by.vsu.emdsproject.web.propertyeditor.SpecialtyEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * @author Max
 */
@ControllerAdvice
public class GroupControllerAdvice {

    @Autowired
    private GroupService groupService;
    @Autowired
    private SpecialtyService specialtyService;

    @ModelAttribute("group")
    public Group setGroup(Long id) {
        if (id != null) {
            return groupService.read(id);
        } else {
            return new Group();
        }
    }

    @InitBinder("group")
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Specialty.class, "specialty", new SpecialtyEditor(specialtyService));
        // comment it to use JSR-303 validation
        //binder.setValidator(new GroupValidator());
    }

}