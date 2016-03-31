package com.scc.softsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scc.softsystem.dao.interfaces.IUserDAO;
import com.scc.softsystem.model.User;
import com.scc.softsystem.services.interfaces.IAuthService;

@Service
@Transactional
public class AuthService implements IAuthService {

	@Autowired
	IUserDAO userDAO;

	@Override
	public User logIn(String login, String password) {
		User user = new User();
		if (userDAO.findByLoginAndPassword(login, password).size() > 0) {
			user = userDAO.findByLoginAndPassword(login, password).get(0);
			if (user != null) {
				return user;
			}
		}

		return null;
	}

}
