package by.vsu.emdsproject.web.propertyeditor;

import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.service.GroupService;

import java.beans.PropertyEditorSupport;

/**
 * @author Max
 *         Date: 16.05.13
 *         Time: 23:00
 */
public class GroupEditor extends PropertyEditorSupport {

    private GroupService groupService;

    public GroupEditor(GroupService groupService) {
        this.groupService = groupService;
    }

    @Override
    public String getAsText() {
        return super.getAsText();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Long id = Long.parseLong(text);
        Group group = groupService.read(id);
        setValue(group);
    }


}
