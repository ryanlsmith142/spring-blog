package com.codeup.blog.blog.controllers;

import com.codeup.blog.blog.dao.PostRepository;
import com.codeup.blog.blog.models.Post;
import com.codeup.blog.blog.models.PostDetails;
import com.codeup.blog.blog.models.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller

public class PostController {

    private final PostRepository postDao;


    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String index(Model vModel) {
        vModel.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewIndividualPost(@PathVariable long id, Model vModel) {
        vModel.addAttribute("post", postDao.getOne(id));
        return "posts/show";
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id) {
        postDao.deleteById(id);
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, @RequestParam(name="title") String newTitle, @RequestParam(name="body") String newBody, Model vModel) {
        Post oldPost = postDao.getOne(id);
        oldPost.setTitle(newTitle);
        oldPost.setBody(newBody);
        postDao.save(oldPost);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/historyOfPost")

    public String getHistoryOfPost(@PathVariable long id, Model vModel) {

        Post post = postDao.getOne(id);

        vModel.addAttribute("post", post);

        return "posts/historyOfPost";
    }

    @GetMapping("/posts/{id}/viewImages")
    public String getImages(@PathVariable long id, Model vModel) {
        Post post = postDao.getOne(id);

        vModel.addAttribute("post", post);

        return "posts/viewImages";
    }

//    @GetMapping("/posts")
//    public String getTags(Model vModel) {
//
//    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String showForm() {
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost(@RequestParam String title, @RequestParam String body) {
        return "create a new post";
    }

}
