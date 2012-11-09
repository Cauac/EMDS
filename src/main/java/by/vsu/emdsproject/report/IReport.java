package by.vsu.emdsproject.report;

import java.util.Collection;
import java.util.HashMap;

public abstract class IReport {

    private String templateFileName;
    
    public abstract HashMap getParametrs();

    public abstract Collection getDataSource();

    public String getTemplateFileName() {
        return templateFileName;
    }

    public void setTemplateFileName(String templateFileName) {
        this.templateFileName = templateFileName;
    }
    
    
}
