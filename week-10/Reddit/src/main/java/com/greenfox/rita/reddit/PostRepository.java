package com.greenfox.rita.reddit;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Rita on 2017-01-04.
 */
public interface PostRepository extends CrudRepository<Post, Long> {
}
