package by.vsu.emdsproject.web;

import by.vsu.emdsproject.web.form.AbstractReportForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.bind.support.WebRequestDataBinder;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class ReportFormArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private ConversionService conversionService;
    private final static String FORM_TYPE = "formType";

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().equals(AbstractReportForm.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        AbstractReportForm form = conversionService.convert(nativeWebRequest.getParameter(FORM_TYPE), AbstractReportForm.class);
        WebRequestDataBinder binder = new WebRequestDataBinder(form);
        binder.setConversionService(conversionService);
        binder.bind(nativeWebRequest);
        return form;
    }

}
