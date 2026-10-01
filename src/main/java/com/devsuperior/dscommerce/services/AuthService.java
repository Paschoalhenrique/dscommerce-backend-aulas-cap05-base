package com.devsuperior.dscommerce.services;

import com.devsuperior.dscommerce.dto.TokenDTO;
import com.devsuperior.dscommerce.config.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	// Método usado pela AuthController
	public TokenDTO authenticate(String username, String password) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(username, password)
		);

		String token = jwtTokenUtil.generateToken(authentication);
		return new TokenDTO(token);
	}

	// Método usado pelo OrderService
	public void validateSelfOrAdmin(Long userId) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication == null || !authentication.isAuthenticated()) {
			throw new RuntimeException("Acesso negado");
		}

		String username = authentication.getName();

		boolean isAdmin = authentication.getAuthorities().stream()
				.anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));

		if (!isAdmin && !username.equals(userId.toString())) {
			throw new RuntimeException("Acesso negado");
		}
	}
}
