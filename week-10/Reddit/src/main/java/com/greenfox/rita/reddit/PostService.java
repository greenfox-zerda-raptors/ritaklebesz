package com.greenfox.rita.reddit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Created by Rita on 2017-01-04.
 */
@Service
public class PostService {

    PostRepository repository;

    @Autowired
    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public Page<Post> getRequestedPage(int page, int limit) {
        return repository.findAllOrderedByScore(new PageRequest(page, limit));
    }

    public void savePost(Post post) {
        post.setScore(0);
        post.setUser(SecurityContextHolder.getContext().getAuthentication().getName());
        post.setDateTime(LocalDateTime.now());
        repository.save(post);
    }

    public void vote(Long id, int changeInScore) {
        Post post = repository.findOne(id);
        post.changeScore(changeInScore);
        repository.save(post);
    }

}
