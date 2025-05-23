package com.sb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.sb.entity.Users;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private userService userservice;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Users users = userservice.findByName(username);
		if (users != null) {

			return User.builder().username(users.getUserName()).password(users.getPassword())
					.roles(users.getRoles().toArray(new String[0])).build();
		} else {
			throw new UsernameNotFoundException("user was not get" + username);
		}

	}

}
