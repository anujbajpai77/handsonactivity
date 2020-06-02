package com.ibm.activity.accountloginservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ibm.activity.accountloginservice.domain.User;
import com.ibm.activity.accountloginservice.dto.MyUserDetails;
import com.ibm.activity.accountloginservice.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// return new MyUserDetails(username);
		Optional<User> user = userRepository.findByUsername(userName);
		user.orElseThrow(() -> new UsernameNotFoundException("Not Found User" + userName));
		return user.map(MyUserDetails::new).get();

	}
}
