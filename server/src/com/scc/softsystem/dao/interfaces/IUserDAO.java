package com.scc.softsystem.dao.interfaces;

import java.util.List;

import com.scc.softsystem.model.User;

public interface IUserDAO {
	User findById(Integer id);
	List<User> findAll();
	List<User> findAllDoctors();
	List<User> findByLoginAndPassword(String login, String password);
	void store(User candidate);
}
