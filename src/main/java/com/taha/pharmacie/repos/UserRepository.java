package com.taha.pharmacie.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.taha.pharmacie.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}