package com.codeup.blog.blog.models;

import javax.persistence.*;

@Entity
@Table(name="post_details")
public class PostDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition="int(11) UNSIGNED")
    private long id;

    @Column(columnDefinition = "boolean")
    private boolean isAwesome;

    @Column(columnDefinition =  "TEXT")
    private String historyOfPost;

    @Column(length = 255)
    private String topicDescription;

    @OneToOne
    private Post post;

    public PostDetails(){}

    public PostDetails(long id, boolean isAwesome, String historyOfPost, String topicDescription) {
        this.id = id;
        this.isAwesome = isAwesome;
        this.historyOfPost = historyOfPost;
        this.topicDescription = topicDescription;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isAwesome() {
        return isAwesome;
    }

    public void setAwesome(boolean awesome) {
        isAwesome = awesome;
    }

    public String getHistoryOfPost() {
        return historyOfPost;
    }

    public void setHistoryOfPost(String historyOfPost) {
        this.historyOfPost = historyOfPost;
    }

    public String getTopicDescription() {
        return topicDescription;
    }

    public void setTopicDescription(String topicDescription) {
        this.topicDescription = topicDescription;
    }
}
