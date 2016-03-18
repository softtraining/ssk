package com.scc.softsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scc.softsystem.model.User;
import com.scc.softsystem.services.interfaces.IAuthService;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

	@Autowired
	IAuthService authService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<User> logIn(@RequestBody String login,
			@RequestBody String password) {
		return new ResponseEntity<User>(authService.logIn(login, password), HttpStatus.OK);
	}

}
