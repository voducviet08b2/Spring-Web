package com.example.comment.model;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="author")
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
}
