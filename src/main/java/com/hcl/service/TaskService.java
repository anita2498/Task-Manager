package com.hcl.service;

import java.util.List;
import java.util.Optional;

import com.hcl.model.Tasks;
import com.hcl.model.user.User;


public interface TaskService {

	public Tasks saveOrUpdate(Tasks task);
	public Optional<Tasks> findById(int taskid);
	public List<Tasks> getAllTasks();
	public List<Tasks> getAllTasksByUser(User user);
	public void deleteTask(Tasks task);
	
}
