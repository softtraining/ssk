package com.scc.softsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scc.softsystem.dao.interfaces.IClinicDAO;
import com.scc.softsystem.dao.interfaces.IScheduleDAO;
import com.scc.softsystem.dao.interfaces.IUserDAO;
import com.scc.softsystem.model.User;
import com.scc.softsystem.model.json.UserJSON;
import com.scc.softsystem.services.interfaces.IUserService;

@Service
@Transactional
public class UserService implements IUserService {

	@Autowired
	IUserDAO userDAO;
	
	@Autowired
	IClinicDAO clinicDAO;
	
	@Autowired
	IScheduleDAO scheduleDAO;
	
	@Override
	public User findById(Integer id) {
		return userDAO.findById(id);
	}

	@Override
	public List<User> findAll() {
		return userDAO.findAll();
	}

	@Override
	public User findByLoginAndPassword(String login, String password) {
		return userDAO.findByLoginAndPassword(login, password).get(0);
	}

	@Override
	public void update(UserJSON candidate) {
		User user = userDAO.findById(candidate.getId());
		if(user != null)
		{
			user.setClinic(clinicDAO.findById(candidate.getClinicId()));
			user.setSchedule(scheduleDAO.findById(candidate.getScheduleId()));
			user.setFirstName(candidate.getFirstName());
			user.setLastName(candidate.getLastName());
			user.setLogin(candidate.getLogin());
			user.setPassword(candidate.getPassword());
			user.setUser(userDAO.findById(candidate.getDoctorId()));
		}
	}

	@Override
	public List<User> findByLogin(String login) {
		return userDAO.findByLoginAndPassword(login, "");
	}

}
