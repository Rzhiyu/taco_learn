package com.example.demo.repository;

import com.example.demo.beans.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {

    User findByUsername(String username);
}
