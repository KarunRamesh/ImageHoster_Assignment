package ImageHoster.service;


import ImageHoster.model.Comment;
import ImageHoster.model.Tag;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    //The method calls the getAllComments() method in the Repository and returns the list of all comments in the database
    public List<Comment> getAllComments() {
        return commentRepository.getAllComments();
    }

    //The method calls the createComment() method in the Repository and passes the comment to be persisted in the database.
    public Comment createComment(Comment comment) {
        return commentRepository.createComment(comment);
    }


}