package by.vsu.emdsproject.model.convertion;

import by.vsu.emdsproject.web.form.*;
import org.springframework.core.convert.converter.Converter;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Max
 *         Date: 18.05.13
 *         Time: 2:37
 */
public class ReportFormConverter implements Converter<String, AbstractReportForm> {

    private static Map<String, Class<? extends AbstractReportForm>> forms =
            new HashMap<String, Class<? extends AbstractReportForm>>();

    static {
        forms.put(PersonCardForm.class.getSimpleName(), PersonCardForm.class);
        forms.put(ExamProtocolForm.class.getSimpleName(), ExamProtocolForm.class);
        forms.put(ExamStatementForm.class.getSimpleName(), ExamStatementForm.class);
        forms.put(AllowedListForm.class.getSimpleName(), AllowedListForm.class);
        forms.put(ProgressRequestForm.class.getSimpleName(), ProgressRequestForm.class);
    }

    @Override
    public AbstractReportForm convert(String s) {
        try {
            return forms.get(s).getConstructor().newInstance();
        } catch (NoSuchMethodException e) {
        } catch (InvocationTargetException e) {
        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
        }
        return null;
    }

}
