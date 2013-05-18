package by.vsu.emdsproject.model.convertion;

import by.vsu.emdsproject.model.Group;
import org.springframework.stereotype.Component;

/**
 * @author Max
 *         Date: 16.05.13
 *         Time: 22:01
 */
@Component
public class GroupConverter extends EMDSEntityConverter<Group> {

    public GroupConverter() {
        super(Group.class);
    }
}
