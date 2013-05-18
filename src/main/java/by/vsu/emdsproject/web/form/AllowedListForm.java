package by.vsu.emdsproject.web.form;

import by.vsu.emdsproject.common.EMDSContext;
import by.vsu.emdsproject.model.Group;
import by.vsu.emdsproject.report.datasource.AbstractReportDataSource;
import by.vsu.emdsproject.report.datasource.AllowedListDS;

import java.util.HashMap;
import java.util.Map;

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
        Map map = new HashMap();
        map.put(AllowedListDS.DataSourceParameter.GROUP, group);
        return map;
    }

    @Override
    public AbstractReportDataSource getReportDataSource() {
        return (AbstractReportDataSource) EMDSContext.getInstance().getFactory().getBean("allowedListDataSource");
    }
}
