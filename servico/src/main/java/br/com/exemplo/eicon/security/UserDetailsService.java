package br.com.exemplo.eicon.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailsService {
	
	UserDetails loadUserByUsername(String login, String senha) throws UsernameNotFoundException;
}
