package com.codeup.blog.blog.controllers;

import com.codeup.blog.blog.dao.PostRepository;
import com.codeup.blog.blog.models.Post;
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

    @PostMapping("/posts/edit")
    public String editPost(@RequestParam(name="id") String id, @RequestParam(name="title") String newTitle, @RequestParam(name="body") String newBody, Model vModel) {
        long postId = Long.parseLong(id);
        Post oldPost = postDao.getOne(postId);
        oldPost.setTitle(newTitle);
        oldPost.setBody(newBody);
        postDao.save(oldPost);
        vModel.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

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
