package com.example.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.models.User;


public interface UserRepo extends CrudRepository<User, Integer>{

	User findByUsername(String username);

}
