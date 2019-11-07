package com.codeup.blog.blog.models;

import javax.persistence.*;

@Entity
@Table(name = "post_image")
public class PostImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition="int(11) UNSIGNED")
    private long id;

    @Column(nullable = false, columnDefinition="VARCHAR(100)")
    private String imageTitle;

    @Column(nullable = false, columnDefinition="VARCHAR(1000)")
    private String url;

    public PostImage(String imageTitle, String url, Post post) {
        this.imageTitle = imageTitle;
        this.url = url;
        this.post = post;
    }

    public PostImage(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImageTitle() {
        return imageTitle;
    }

    public void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;


}
