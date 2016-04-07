package com.scc.softsystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scc.softsystem.model.User;
import com.scc.softsystem.model.json.VisitJSON;
import com.scc.softsystem.services.interfaces.IUserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@RequestMapping(value = "/", method= RequestMethod.GET)
	public ResponseEntity<List<User>> findAllDoctors()
	{
		return new ResponseEntity<List<User>>(userService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable(value = "id") Integer userId)
	{
		return new ResponseEntity<User>(userService.findById(userId), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getDoctors", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllDoctors()
	{
		return new ResponseEntity<List<User>>(userService.findAllDoctors(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getByLogin/{login}", method = RequestMethod.POST)
	public ResponseEntity<List<User>> getByLogin(@PathVariable(value = "login") String userLogin)
	{
		return new ResponseEntity<List<User>>(userService.findByLogin(userLogin), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addVisit", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> addVisitForUser(@RequestBody VisitJSON newVisit)
	{
		if(userService.addNewVisit(newVisit))
		{
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
}
