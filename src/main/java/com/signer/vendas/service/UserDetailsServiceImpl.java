package com.signer.vendas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.signer.vendas.domain.Cliente;
import com.signer.vendas.repository.ClienteRepository;
import com.signer.vendas.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private ClienteRepository repo;

	@Override
	public UserDetails loadUserByUsername(String Login) throws UsernameNotFoundException {

		Cliente cli = repo.findByLogin(Login);
		if (cli == null) {
			throw new UsernameNotFoundException(Login);
		}
		// usando login ao lugar de email
		return new UserSS(cli.getId(), cli.getLogin(), cli.getSenha(), cli.getPerfis());
	}

}
