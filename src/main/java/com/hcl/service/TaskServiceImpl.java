package com.hcl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.model.TaskRepo;
import com.hcl.model.Tasks;
import com.hcl.model.user.User;

@Service
public class TaskServiceImpl implements TaskService {
	@Autowired
	TaskRepo repo;

	@Override
	public Tasks saveOrUpdate(Tasks task) {

		return repo.save(task);
	}

	@Override
	public Optional<Tasks> findById(int taskid) {

		return repo.findById(taskid);
	}

	@Override
	public List<Tasks> getAllTasks() {
		return (List<Tasks>) repo.findAll();
	}

	@Override
	public List<Tasks> getAllTasksByUser(User user) {

		return repo.findAllByUser(user);
	}

	@Override
	public void deleteTask(Tasks task) {
		repo.delete(task);

	}

}
