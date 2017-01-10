package com.greenfox.rita.decoder.repository;

import com.greenfox.rita.decoder.domain.Message;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Rita on 2017-01-10.
 */
public interface MessageRepository extends CrudRepository<Message, Long> {
}
