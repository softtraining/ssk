package com.scc.softsystem.dao.interfaces;

import java.util.List;

import com.scc.softsystem.model.Schedule;

public interface IScheduleDAO {
	Schedule findById(Integer id);
	List<Schedule> findAll();
	void store(Schedule candidate);
	void delete(Schedule object);
}
