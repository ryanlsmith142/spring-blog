package com.codeup.blog.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String index() {
        return "posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String viewIndividualPost(@PathVariable long id) {
        return "view an individual page " + id;
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

    @PostMapping("/roll-dice")
    public String showPage() {
        return "roll-dice";
    }

    @PostMapping("/roll-dice/${guess}")
    public String rollDice(@RequestParam(name = "guess") String guess, Model vModel) {
        //Get a random number here
        double x = Math.floor(Math.random() * Math.floor(6));


        //send it back to page and display with message
        vModel.addAttribute("randomNumber", x);

        //return to /roll-dice

        return "roll-dice";
    }




}
