package com.codeup.blog.blog.controllers;

import com.codeup.blog.blog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller

public class PostController {

    //Initialize arraylist outside;

    //Mock DaoFactory

    public PostController() {
        //create rrayList of Post Objects

        //add objects to array list
    }

    @GetMapping("/posts")
    public String index() {
        List<String> posts = new ArrayList<>();


        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewIndividualPost(@PathVariable long id, Model vModel) {
        Post individualPost = new Post(id,"Ten facts about dogs", "Here's ten facts about dogs.");

        vModel.addAttribute("individualPost", individualPost);

        return "posts/show";
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



















//Views Exercise 1

    @GetMapping("/roll-dice")
    public String showPage() {
        return "roll-dice";
    }

    @PostMapping("/roll-dice")
    public String rollDice(@RequestParam(name = "guess") String guess, Model vModel) {
        //Get a random number here


        double x = Math.floor(Math.random() * Math.floor(7));

        if(x == 0) {
            x = x + 1;
        }
        int y = (int) x;
        vModel.addAttribute("userNumber", guess);

        int guessNum = (int) Double.parseDouble(guess);


        if(y == guessNum) {
            vModel.addAttribute("success", "Hey you guessed right");
        } else {
            vModel.addAttribute("failure", "You got it wrong");
        }
        //send it back to page and display with message
        vModel.addAttribute("randomNumber", y);

        //return to /roll-dice

        return "roll-dice";
    }




}
