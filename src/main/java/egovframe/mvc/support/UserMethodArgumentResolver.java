package egovframe.mvc.support;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import egovframe.model.User;
import egovframe.mvc.UserController;

public class UserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return User.class.isAssignableFrom(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter
                                , ModelAndViewContainer mavContainer
                                , NativeWebRequest webRequest
                                , WebDataBinderFactory binderFactory) throws Exception {

        HttpSession session =  webRequest.getNativeRequest(HttpServletRequest.class).getSession();
        Object user = session.getAttribute(UserController.SESSION_USER_KEY);

        return user != null ? user : User.anonymous();
    }

}
