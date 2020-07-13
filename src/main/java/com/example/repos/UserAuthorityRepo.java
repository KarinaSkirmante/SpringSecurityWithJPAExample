package com.example.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.models.UserAuthority;


public interface UserAuthorityRepo extends CrudRepository<UserAuthority, Integer>{

	UserAuthority findByAuthority(String string);

}
