package by.vsu.emdsproject.web.form;

import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.report.datasource.AbstractReportDataSource;

import java.util.Map;

/**
 * @author Max
 *         Date: 18.05.13
 *         Time: 13:13
 */
public class AllowedListForm extends AbstractReportForm {

    private Group group;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public Map getReportDataMap() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public AbstractReportDataSource getReportDataSource() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

}
