package by.vsu.emdsproject.web;

import by.vsu.emdsproject.web.form.AbstractReportForm;
import by.vsu.emdsproject.web.form.PersonCardForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.bind.support.WebRequestDataBinder;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author Max
 *         Date: 17.05.13
 *         Time: 23:59
 */
public class ReportFormArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private ConversionService conversionService;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().equals(AbstractReportForm.class) ? true : false;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        PersonCardForm personCardForm = new PersonCardForm();
        WebRequestDataBinder binder = new WebRequestDataBinder(personCardForm);
        binder.setConversionService(conversionService);
        binder.bind(nativeWebRequest);
        return personCardForm;
    }

}
