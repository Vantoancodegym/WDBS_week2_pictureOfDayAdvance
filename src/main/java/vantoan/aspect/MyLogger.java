package vantoan.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import vantoan.model.Comment;

@Aspect
public class MyLogger {
    @AfterThrowing(pointcut = "execution(public * vantoan.controller.CommentController.*(..))&&args(comment)")
    public void log(JoinPoint joinPoint, Comment comment){
        System.out.println("author");
        System.out.println(comment.getAuthor());
        System.out.println("invalid feedback: ");
        System.out.println(comment.getFeedback());
    }


}
