package com.ibm.casestudy.accountlogin.service;

import java.util.Optional;

import com.ibm.casestudy.accountlogin.model.User;

public interface UserService {

	Optional<User> findByUsername(String username);

	Optional<User> findByEmail(String email);

	User saveUser(User user);

}
