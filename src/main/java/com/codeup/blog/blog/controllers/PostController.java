package com.codeup.blog.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

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
