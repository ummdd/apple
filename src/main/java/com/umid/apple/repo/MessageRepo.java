package com.umid.apple.repo;

import com.umid.apple.db.MessageDatabase;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepo extends CrudRepository<MessageDatabase, Integer> {

}
