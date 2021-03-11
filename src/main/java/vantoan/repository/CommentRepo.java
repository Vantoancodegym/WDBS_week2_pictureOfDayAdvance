package vantoan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vantoan.model.Comment;

@Repository
public interface CommentRepo extends CrudRepository<Comment, Integer> {
}
