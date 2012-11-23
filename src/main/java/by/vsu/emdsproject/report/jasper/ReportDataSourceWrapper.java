package by.vsu.emdsproject.report.jasper;

import java.util.HashMap;

/**
 * класс формирующий и инкопсулирующий все данные необходимые для шаблона
 *
 */
public interface ReportDataSourceWrapper {

    /**
     *
     * @return данные для заполнения шаблона отчета
     */
    public String getTemplateName();

    public HashMap getDataSource();
}
