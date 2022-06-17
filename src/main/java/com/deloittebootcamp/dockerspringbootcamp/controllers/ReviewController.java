package com.deloittebootcamp.dockerspringbootcamp.controllers;

import com.deloittebootcamp.dockerspringbootcamp.dto.Review;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class ReviewController {

    @Value("${BOOTCAMP_USER:Anonim}")
    private String defaultName;

    @GetMapping("/")
    public String indexPage(Model model){
        return "index";
    }

    @GetMapping("/review")
    public String reviewPage(Model model){
        Review dtoReview = new Review();

        dtoReview.setName(defaultName);
        model.addAttribute("review", dtoReview);

        List<String> theoryLevels = Arrays.asList("Prea greu", "Prea mult", "Ok", "Usor", "Prea usor");
        List<String> understandingScores = Arrays.asList("Nu am inteles", "Am inteles cateva subiecte", "Am inteles bine");
        List<String> presentationModels = Arrays.asList("Plictisitor", "Monoton", "Ok", "Interesant");

        model.addAttribute("theoryLevels", theoryLevels);
        model.addAttribute("understandingScores", understandingScores);
        model.addAttribute("presentationModels", presentationModels);

        return "review";
    }

    @PostMapping("/submit")
    public String retrieveReview(@ModelAttribute("review") Review review){
        review.send();
        return "thankyou";
    }
}
