package com.greenfox.rita.reddit;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Rita on 2017-01-04.
 */
public interface PostRepository extends CrudRepository<Post, Long> {

    @Query("SELECT post from Post post order by post.score desc")
    Page<Post> findAllOrderedByScore(Pageable pageable);
}
