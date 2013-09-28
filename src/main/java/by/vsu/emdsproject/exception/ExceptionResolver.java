package by.vsu.emdsproject.exception;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;

public class ExceptionResolver extends SimpleMappingExceptionResolver {
    @Override
    protected ModelAndView getModelAndView(String viewName, Exception ex) {
        return getCustomModelAndView(viewName, ex, null);
    }

    @Override
    protected ModelAndView getModelAndView(String viewName, Exception ex, HttpServletRequest request) {
        return getCustomModelAndView(viewName, ex, request);
    }

    private ModelAndView getCustomModelAndView(String viewName, Exception ex, HttpServletRequest request) {
        ModelAndView mv = super.getModelAndView(viewName, ex);
        mv.addObject("text", ex.getMessage());
        return mv;
    }
}
