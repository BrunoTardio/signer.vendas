package com.signer.vendas.service;

import org.springframework.security.core.context.SecurityContextHolder;

import com.signer.vendas.security.UserSS;



public class UserService {
	
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}
}
