package com.example.comment.service;

import com.example.comment.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();
    void save(Comment comment);
    Comment findById(Long id);
    void delete(Comment comment);

}
