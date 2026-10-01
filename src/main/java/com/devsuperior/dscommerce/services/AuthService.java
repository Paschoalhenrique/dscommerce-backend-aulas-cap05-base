package com.devsuperior.dscommerce.services;

import com.devsuperior.dscommerce.dto.TokenDTO;
import com.devsuperior.dscommerce.config.JwtTokenUtil; // IMPORT CORRETO

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil; // injeta o utilitário

	public TokenDTO authenticate(String username, String password) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(username, password)
		);

		String token = jwtTokenUtil.generateToken(authentication);

		return new TokenDTO(token);
	}
}
