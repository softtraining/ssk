package com.scc.softsystem.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.scc.softsystem.dao.interfaces.IClinicDAO;
import com.scc.softsystem.model.Clinic;

@Repository
public class ClinicDAO extends BaseDAO<Integer, Clinic> implements IClinicDAO {

	@Override
	public Clinic findById(Integer id) {
		return getByKey(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Clinic> findAll() {
		Criteria criteria = createEntityCriteria();
		return (List<Clinic>)criteria.list();
	}
}
