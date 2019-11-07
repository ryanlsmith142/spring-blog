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

    public Post(){}

    public Post(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
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




}
