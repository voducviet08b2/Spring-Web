package com.example.comment.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.regex.Pattern;

@Entity
public class Comment implements Validator {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "author")
    private String author;
    @Column(name = "feedback")
    private String feedback;
    @Column(name = "total_like")
    private int totalLike;

    public Comment(Long id, String author, String feedback, int totalLike) {
        this.id = id;
        this.author = author;
        this.feedback = feedback;
        this.totalLike = totalLike;
    }

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getTotalLike() {
        return totalLike;
    }

    public void setTotalLike(int totalLike) {
        this.totalLike = totalLike;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Comment.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Comment comment = (Comment) target;
        String feedback = comment.getFeedback();
        ValidationUtils.rejectIfEmpty(errors, "feedback", "feedback.empty");

        String[] words = feedback.split("\\s");
        for (int i = 0; i < words.length; i++) {
            if (Pattern.matches("(fuck|sex)", words[i])) {
                errors.rejectValue("feedback", "feedback.wrong");
                break;
            }
        }
//        if(!Pattern.matches("([A-Z]([a-z])* ?)+",name)){
//            throw new NameException("Ten khong dung dinh dang");
//        }
//        break;
    }
}
