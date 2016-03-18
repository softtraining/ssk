package com.scc.softsystem.services.interfaces;

import java.util.List;

import com.scc.softsystem.model.User;
import com.scc.softsystem.model.json.UserJSON;

public interface IUserService {
	User findById(Integer id);
	List<User> findAll();
	List<User> findByLogin(String login);
	User findByLoginAndPassword(String login, String password);
	void update(UserJSON candidate);
}
