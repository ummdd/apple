package com.umid.apple.repo;

import com.umid.apple.db.MessageDatabase;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepo extends CrudRepository<MessageDatabase, Integer> {

    List<MessageDatabase> findByText(String text);
}
