package by.vsu.emdsproject.report.datasource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Базовый класс источника данных для отчета
 */
public abstract class AbstractReportDataSource {

    /**
     * Наименование полей отчета
     */
    public static class Field {

    }

    /**
     * Наименования параметров источника данных отчета
     */
    public static class DataSourceParameter {

    }

    /**
     * Наименования параметров отчета
     */

    public static class ReportParameter {

    }

    /**
     * Набор данных для отчета
     */
    protected ArrayList<HashMap> reportData = null;

    /**
     * Набор параметров представления отчета
     */
    protected HashMap<String, String> parameters = new HashMap<String, String>();

    /**
     * Индекс текущей записи
     */
    protected int currentRowIndex = ROW_INDEX_BEGINNING;

    /**
     * дефолтное значение индекса
     */
    public static int ROW_INDEX_BEGINNING = -1;


    public abstract String getName();

    public abstract String getTitle();

    protected abstract void initializeParameters(Map parameters) throws Exception;

    protected abstract void initializeReportData(Map parameters) throws Exception;

    public void init(Map parameters) {
        try {
            currentRowIndex = ROW_INDEX_BEGINNING;
            initializeParameters(parameters);
            initializeReportData(parameters);
        } catch (Exception e) {
            // TODO обработать ошибку инициализации данных отчета
        }
    }

    public void addParameter(String name, String value) {
        if (value == null) {
            value = "";
        }
        parameters.put(name, value);
    }

    public String getParameter(String name) {
        String result = parameters.get(name);
        return result != null ? result : "";
    }

    public HashMap<String, String> getParameters() {
        return parameters;
    }

    public boolean isEmpty() {
        return reportData == null || reportData.size() == 0;
    }

    public boolean next() {
        return reportData != null && ++currentRowIndex < reportData.size();
    }

    public void toFirstRow() {
        currentRowIndex = ROW_INDEX_BEGINNING;
    }

    public Object getFieldValue(String fieldName) {
        HashMap map = reportData.get(currentRowIndex);
        return map.get(fieldName);
    }
}
