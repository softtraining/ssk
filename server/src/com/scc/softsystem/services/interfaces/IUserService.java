package com.scc.softsystem.services.interfaces;

import java.util.List;

import com.scc.softsystem.model.User;
import com.scc.softsystem.model.json.UserJSON;
import com.scc.softsystem.model.json.VisitJSON;

public interface IUserService {
	User findById(Integer id);
	List<User> findAll();
	List<User> findByLogin(String login);
	List<User> findAllPatientsForDoctor(Integer doctorId);
	List<User> findAllDoctors();
	User findByLoginAndPassword(String login, String password);
	boolean addNewVisit(VisitJSON newVisit);
	void update(UserJSON candidate);
}
