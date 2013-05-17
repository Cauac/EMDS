package by.vsu.emdsproject.model.convertion;

import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author Max
 *         Date: 16.05.13
 *         Time: 22:01
 */
@Component
public class GroupConverter implements Converter<Long, Group> {

    @Autowired
    private GroupService groupService;

    public GroupConverter() {
    }

    public GroupConverter(GroupService groupService) {
        this.groupService = groupService;
    }

    @Override
    public Group convert(Long aLong) {
        return groupService.read(aLong);
    }
}
