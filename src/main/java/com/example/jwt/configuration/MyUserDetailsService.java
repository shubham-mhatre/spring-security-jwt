package com.example.jwt.configuration;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.jwt.entity.User;
import com.example.jwt.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User>user= userRepository.findByName(username);
		
		user.orElseThrow(()-> new UsernameNotFoundException(username+" not found."));
		
		return user.map(MyUserDetails::new).get();
	}

}
