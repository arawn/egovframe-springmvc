package egovframe.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import egovframe.model.Board;
import egovframe.model.Post;

@Controller
@RequestMapping("/{board}/post")
public class PostController {
    
    @RequestMapping(method=RequestMethod.GET)
    public String list(@PathVariable Board board, Model model) {
        model.addAttribute("posts", board.getPosts());
        
        return "post/list";
    }
    
    @RequestMapping(value="{postNo}", method=RequestMethod.GET)
    public String view(@PathVariable Board board, @PathVariable Long postNo, Model model) {
        model.addAttribute(board.findPost(postNo));
        
        return "post/view";
    }
    
    @RequestMapping(value="new", method=RequestMethod.GET)
    public String addForm(@ModelAttribute Post post) {
        
        return "post/form";
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public String writing(@PathVariable Board board, Post post) {
        board.writing(post);
        
        return "redirect:/{board}/post";
    }
    
    @RequestMapping(value="edit/{postNo}", method=RequestMethod.GET)
    public String editForm(@PathVariable Board board, @PathVariable Long postNo, Model model) {
        model.addAttribute(board.findPost(postNo));
        
        return "post/form";
    }
    
    @RequestMapping(method=RequestMethod.PUT)
    public String editing(@PathVariable Board board, Post post, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("postNo", board.editing(post).getNo());
        
        return "redirect:/{board}/post/{postNo}";
    }
    
    @RequestMapping(method=RequestMethod.DELETE)
    public String erase(@PathVariable Board board, @RequestParam Long postNo) {
        board.erase(postNo);
        
        return "redirect:/{board}/post";
    }

}
