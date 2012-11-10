package by.vsu.emdsproject.report.jasper;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReportTemplateFactory {

    static class ReportName {

        public static final String PERSON_CARD_REPORT = "personCardReport";
    }

    public static JasperReportTemlate getReportTemplate(String name) {
        ApplicationContext context = new ClassPathXmlApplicationContext("emds-model-context.xml");
        BeanFactory factory = (BeanFactory) context;
        return (JasperReportTemlate) factory.getBean(name);
    }
}
