package com.greenfox.rita.reddit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

    public List<Post> getAllPosts() {
        return (List<Post>) repository.findAll();
    }

    public void savePost(Post post) {
        post.setScore(0);
        post.setDateTime(LocalDateTime.now());
        repository.save(post);
    }

    public void upvotePost(String id) {
        Post post = repository.findOne(Long.parseLong(id));
        post.increaseScore();
        repository.save(post);
    }

    public void downvotePost(String id) {
        Post post = repository.findOne(Long.parseLong(id));
        post.decreaseScore();
        repository.save(post);
    }

}
