package com.example.jwt.configuration;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.jwt.entity.User;

public class MyUserDetails implements UserDetails{
	
	private String userName;
	private String pass;
	private Integer isActive;
	private List<GrantedAuthority> roles;

	public MyUserDetails(User user) {
		this.userName = user.getName();
		this.pass=user.getPass();
		this.isActive=user.getIsActive();
		this.roles=Arrays.stream(user.getRole().split(","))
				.map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}

	public MyUserDetails() {
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public String getPassword() {
		return pass;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return isActive == 1 ? true : false;
	}


	
}
