package com.greenfox.rita.reddit.controller;

import com.greenfox.rita.reddit.Post;
import com.greenfox.rita.reddit.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Rita on 2017-01-04.
 */
@Controller
@RequestMapping(value = "/posts")
public class PostController {

    PostService service;

    @Autowired
    public PostController(PostService service) {
        this.service = service;
    }

    @RequestMapping(value = "/")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "0") Integer page,
                        @RequestParam(name = "count", defaultValue = "10") Integer limit) {
        model.addAttribute("posts", service.getRequestedPage(page, limit));
        return "index";
    }

    @GetMapping(value = "/add")
    public String add(Model model) {
        model.addAttribute("post", new Post());
        return "add";
    }

    @PostMapping(value = "/add")
    public String submitNewPost(@ModelAttribute Post post) {
        service.savePost(post);
        return "redirect:/";
    }

    @RequestMapping(value = "/{id}/upvote")
    public String upvote(@PathVariable("id") Long id) {
        service.vote(id, 1);
        return "redirect:/";
    }

    @RequestMapping(value = "/{id}/downvote")
    public String downvote(@PathVariable("id") Long id) {
        service.vote(id, -1);
        return "redirect:/";
    }
}
