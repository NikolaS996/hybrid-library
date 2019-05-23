package com.hybridlibrary.repositories;


import com.hybridlibrary.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface UserRepository extends JpaRepository<User, Long> {
    Collection<User> findByUsernameContainingIgnoreCase(String username);
}
