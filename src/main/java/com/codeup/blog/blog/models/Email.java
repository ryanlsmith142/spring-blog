package com.codeup.blog.blog.models;

import javax.persistence.*;

@Entity
@Table(name = "emails")
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false, columnDefinition = "int(11) UNSIGNED")
    private long id;

    private String subject;

    @Column(columnDefinition = "TEXT", nullable=false)
    private String body;

    @Column(nullable=false)
    private String sender;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Email(){}

    public Email(String subject, String body, String sender) {
        this.subject = subject;
        this.body = body;
        this.sender = sender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
