package com.example.security.account;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements UserDetailsService {

	@Autowired
	private AccountRepository accountRep;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountRep.findByEmail(username);
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		return new User(account.getEmail(), account.getPassword(), authorities);
		
	/*	UserDetails userDetails = new UserDetails() {

			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				List<GrantedAuthority> authorities = new ArrayList<>();
				authorities.add(new  SimpleGrantedAuthority("ROLE_USER"));
				return authorities;
			}

			@Override
			public String getPassword() {
				return account.getPassword();
			}

			@Override
			public String getUsername() {
				return account.getEmail();
			}

			@Override
			public boolean isAccountNonExpired() {
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
				return true;
			}
			
		}; 
		return userDetails;
		*/
	}

	public Account save(Account account) {
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		return accountRep.save(account);
	}

	
}
