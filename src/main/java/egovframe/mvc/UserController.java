package egovframe.mvc;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import egovframe.model.User;

@Controller
public class UserController {
    
    public static final String SESSION_USER_KEY = "SESSION_USER_KEY";
    
    @RequestMapping("/login")
    public String login(String username, HttpSession httpSession) {
        if(StringUtils.hasText(username)) {
            httpSession.setAttribute(SESSION_USER_KEY, new User(username));
        } else {
            httpSession.invalidate();
        }
        
        return "redirect:/notice/post";
    }
    
    @RequestMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        
        return "redirect:/notice/post";
    }
    
    @RequestMapping("/user-info")
    public String userInfo(User user, Model model, RedirectAttributes redirectAttributes) {
        if(user.isAnonymous()) {
            redirectAttributes.addFlashAttribute("loginRequest", true);
            return "redirect:/notice/post";
        }
        
        model.addAttribute("user", user);
        
        return "user-info";
    }
    
    

}
