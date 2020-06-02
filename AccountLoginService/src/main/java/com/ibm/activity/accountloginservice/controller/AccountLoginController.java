package com.ibm.activity.accountloginservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loginservice")
public class AccountLoginController {

	@Value("Secured Login")
	private String message;

	@GetMapping("/")
	public String open() {
		return "You are general user";
	}
	
	@GetMapping("/msg")
	public String getMsg() {
		return this.message;
	}

	@GetMapping("/superuser")
	public String superUser() {
		return "Hello Super User";
	}
}
