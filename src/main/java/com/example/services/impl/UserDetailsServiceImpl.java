package com.example.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.config.MyUserDetails;
import com.example.models.User;
import com.example.repos.UserRepo;



public class UserDetailsServiceImpl implements UserDetailsService
{

	 @Autowired
	    private UserRepo userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 
		System.out.println(username);
		User user = userRepository.findByUsername(username);
		 System.out.println(user.getAuthorities().size()); 
	        if (user == null) {
	        	
	            throw new UsernameNotFoundException("Could not find user");
	        }
	       
	         System.out.println(user.getId() + " " + user.getUsername());
	        return new MyUserDetails(user);
	}

}
