package com.example.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt.configuration.MyUserDetails;
import com.example.jwt.configuration.MyUserDetailsService;
import com.example.jwt.dto.AuthenticateRequest;
import com.example.jwt.dto.AuthenticateResponse;
import com.example.jwt.util.JwtUtil;

@RestController
public class HomeController {

	@Autowired private AuthenticationManager authManager;
	@Autowired private MyUserDetailsService userDetailsService;
	@Autowired private JwtUtil jwtUtil;

	@GetMapping("/")
	public String home() {
		return "<h1>Welcome</h1>";
	}

	@GetMapping("/user")
	public String user() {
		return "<h1>Welcome user</h1>";
	}

	@GetMapping("/admin")
	public String admin() {
		return "<h1>Welcome admin</h1>";
	}

	@PostMapping("/generateToken")
	public ResponseEntity<?> generateToken(@RequestBody AuthenticateRequest authRequest){
		try {
			authManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		}catch(BadCredentialsException bce) {
			bce.printStackTrace();
			return ResponseEntity.ok(new AuthenticateResponse("-","invalid credentials"));
		}

		UserDetails userDetails= this.userDetailsService.loadUserByUsername(authRequest.getUserName());

		String jwt = this.jwtUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticateResponse(jwt,"success"));
	}
}
