package com.codeup.blog.blog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable=false, columnDefinition = "int(11) UNSIGNED")
    private long id;

    @Column(nullable=false)
    private String title;

    @Column(columnDefinition="TEXT")
    private String body;

    @OneToOne
    private PostDetails postDetails;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<PostImage> images;


    @ManyToMany
    public List<PostImage> getImages() {
        return images;
    }

    @ManyToMany(mappedBy = "posts")
    private List<Tag> tags;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public List<Tag> getTags() {
        return tags;
    }

    public Post(){}

    public Post(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Post(String title, String body, long user_id) {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public PostDetails getPostDetails() {
        return postDetails;
    }

    public void setPetDetails(PostDetails petDetails) {
        this.postDetails = petDetails;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
    public void setImages(List<PostImage> images) {
        this.images = images;
    }



}
