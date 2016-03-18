package com.scc.softsystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scc.softsystem.model.Clinic;
import com.scc.softsystem.services.interfaces.IClinicService;


@RestController
@RequestMapping(value = "/clinic")
public class ClinicController {
	
	@Autowired
	IClinicService clinicService;
	
	@RequestMapping(value = "/", method= RequestMethod.GET)
	public ResponseEntity<List<Clinic>> findAllDoctors()
	{
		return new ResponseEntity<List<Clinic>>(clinicService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}")
	public ResponseEntity<Clinic> findById(@PathVariable(value = "id") Integer clinicId)
	{
		return new ResponseEntity<Clinic>(clinicService.findById(clinicId), HttpStatus.OK);
	}
	
}
