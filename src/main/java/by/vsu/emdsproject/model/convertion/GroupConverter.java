package by.vsu.emdsproject.model.convertion;

import by.vsu.emdsproject.model.Group;
import org.springframework.stereotype.Component;

@Component
public class GroupConverter extends EMDSEntityConverter<Group> {

    public GroupConverter() {
        super(Group.class);
    }
}
