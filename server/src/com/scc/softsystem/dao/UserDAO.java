package com.scc.softsystem.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.scc.softsystem.dao.interfaces.IUserDAO;
import com.scc.softsystem.model.User;

@Repository
public class UserDAO extends BaseDAO<Integer, User>implements IUserDAO {

	@Override
	public User findById(Integer id) {
		return getByKey(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		Criteria criteria = createEntityCriteria();
		return (List<User>) criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllDoctors() {
		Criteria criteria = createEntityCriteria().add(Restrictions.isNotNull("user"));
		return (List<User>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByLoginAndPassword(String login, String password) {
		
		Criteria criteria = createEntityCriteria().add(Restrictions.eq("login", login));
		if (!password.isEmpty()) {
			criteria.add(Restrictions.eq("password", password));
		}
		return (List<User>) criteria.list();
	}

	@Override
	public void store(User candidate) {
		persist(candidate);
	}

}
