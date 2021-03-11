package vantoan.controller;

import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vantoan.exception.InvalidWordsException;
import vantoan.model.Comment;
import vantoan.service.ICommentService;

import java.util.List;

@Controller
@RequestMapping("pictures")
public class CommentController {
    @ModelAttribute("evaluates")
    public String[] getEvaluateLít(){
        String[] list = {"1","2","3","4","5"};
        return list;
    }
    private String[] invalidWords=new String[]{"fuck","sex","xxx"};

    @Autowired
    private ICommentService iCommentService;

    @ExceptionHandler(InvalidWordsException.class)
    public ModelAndView showError(){
        return new ModelAndView("invalidWord");
    }
    @GetMapping("")
    public ModelAndView showAll(){
        List<Comment> list= iCommentService.findAll();
        ModelAndView modelAndView=new  ModelAndView("pictures");
        modelAndView.addObject("list",list);
        modelAndView.addObject("newComment",new Comment());
        return modelAndView;
    }
    @PostMapping("create")
    public ModelAndView create(@ModelAttribute Comment comment) throws InvalidWordsException{
        for (String s:invalidWords) {
          if (comment.getFeedback().contains(s)) throw new InvalidWordsException();
        }
        comment.setLikesAmount(0);
        iCommentService.save(comment);
        return new ModelAndView("redirect:/pictures");
    }
    @GetMapping("like")
    public ModelAndView like(@RequestParam int id){
        Comment comment=iCommentService.findById(id);
        int likesAmount=comment.getLikesAmount()+1;
        comment.setLikesAmount(likesAmount);
        iCommentService.save(comment);
        return new ModelAndView("redirect:/pictures");
    }
}
