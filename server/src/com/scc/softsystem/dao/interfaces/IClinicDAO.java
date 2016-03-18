package com.scc.softsystem.dao.interfaces;

import java.util.List;

import com.scc.softsystem.model.Clinic;

public interface IClinicDAO {
	Clinic findById(Integer id);
	List<Clinic> findAll();
}
