package com.scc.softsystem.services.interfaces;

import com.scc.softsystem.model.User;

public interface IAuthService {
	User logIn(String login, String password);
}
