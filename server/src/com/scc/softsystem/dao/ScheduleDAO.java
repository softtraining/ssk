package com.scc.softsystem.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.scc.softsystem.dao.interfaces.IScheduleDAO;
import com.scc.softsystem.model.Schedule;

@Repository
public class ScheduleDAO extends BaseDAO<Integer, Schedule> implements IScheduleDAO {

	@Override
	public Schedule findById(Integer id) {
		return getByKey(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Schedule> findAll() {
		Criteria criteria = createEntityCriteria();
		return (List<Schedule>)criteria.list();
	}

	@Override
	public void store(Schedule candidate) {
		persist(candidate);
	}

	@Override
	public void delete(Schedule object) {
		remove(object);
	}

}
