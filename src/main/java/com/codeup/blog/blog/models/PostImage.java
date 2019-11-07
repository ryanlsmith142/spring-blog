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

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

}
