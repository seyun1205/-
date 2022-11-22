package front.all.service;

import front.all.pojo.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> selectAll();
    boolean add(Comment comment);
}
