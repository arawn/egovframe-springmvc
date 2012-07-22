package egovframe.mvc.old;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {

    @Override
    public ModelAndView handleRequest(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        String name = ServletRequestUtils.getStringParameter(request, "name", null);

        ModelAndView mav = new ModelAndView("hello");
        mav.addObject("name", name);
        
        return mav;
    }

}
