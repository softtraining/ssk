package com.scc.softsystem.services.interfaces;

import java.util.List;

import com.scc.softsystem.model.Clinic;

public interface IClinicService {
	
	Clinic findById(Integer id);
	List<Clinic> findAll();
}
