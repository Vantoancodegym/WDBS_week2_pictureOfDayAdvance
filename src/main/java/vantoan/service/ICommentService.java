package vantoan.service;

import vantoan.exception.InvalidWordsException;
import vantoan.model.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> findAll();
    Comment findById(int id);
    void save(Comment comment);
    void delete(int id);

}
