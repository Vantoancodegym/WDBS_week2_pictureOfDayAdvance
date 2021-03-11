package vantoan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vantoan.exception.InvalidWordsException;
import vantoan.model.Comment;
import vantoan.repository.CommentRepo;

import java.util.List;

@Service
public class CommentService implements ICommentService{
    @Autowired
    private CommentRepo commentRepo;
    @Override
    public List<Comment> findAll() {
        return (List<Comment>)  commentRepo.findAll();
    }

    @Override
    public Comment findById(int id) {
        return commentRepo.findOne(id);
    }

    @Override
    public void save(Comment comment) {
        commentRepo.save(comment);

    }


    @Override
    public void delete(int id) {
        commentRepo.delete(id);

    }
}
