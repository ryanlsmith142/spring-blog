package com.codeup.blog.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class MathController {
    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public String add(@PathVariable int num1, @PathVariable int num2) {
        int total = num1 + num2;

        return Integer.toString(total);
    }

    @GetMapping("/subtract/{num1}/and/{num2}")
    @ResponseBody
    public String subtract(@PathVariable int num1, @PathVariable int num2) {
        int total = num1 - num2;

        return Integer.toString(total);
    }

    @GetMapping("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public String multiply(@PathVariable int num1, @PathVariable int num2) {
        int total = num1 * num2;

        return Integer.toString(total);
    }

    @GetMapping("/divide/{num1}/and/{num2}")
    @ResponseBody
    public String divide(@PathVariable int num1, @PathVariable int num2) {
        int total = num1 / num2;

        return Integer.toString(total);
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
