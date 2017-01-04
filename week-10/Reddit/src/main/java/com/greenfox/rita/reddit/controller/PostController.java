package com.greenfox.rita.reddit.controller;

import com.greenfox.rita.reddit.Post;
import com.greenfox.rita.reddit.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Rita on 2017-01-04.
 */
@Controller
@RequestMapping(value = "/posts")
public class PostController {
    PostRepository repository;

    @Autowired
    public PostController(PostRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("posts", repository.findAll());
        return "index";
    }

    @GetMapping(value = "/add")
    public String add(Model model) {
        model.addAttribute("post", new Post());
        return "add";
    }

    @PostMapping(value = "/add")
    public String submitNewPost(@ModelAttribute Post post) {
        post.setScore(0);
        repository.save(post);
        return "redirect:/";
    }
}
