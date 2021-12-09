package com.umid.apple.repo;

import com.umid.apple.db.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {

    User findByUsername(String username);

}
