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
		
		return repo.findById (taskid);
	}

	@Override
	public List<Tasks> getAllTasks() {
	// List <Tasks> tasks =(List<Tasks>) repo.findAll();
		/*
		 * String out= "<table style=\"width:75%\">\r\n" + "  <tr>\r\n" +
		 * "    <th>ID</th>\r\n" + "    <th>Task Name</th>\r\n" +
		 * "    <th>Start Date</th>\r\n" + "    <th>End Date</th>\r\n" +
		 * "    <th>Description</th>\r\n" + "    <th>User id</th>\r\n" + "  </tr>";
		 * for(Tasks task:tasks) { out +="<tr>\r\n" +
		 * "    <td>"+task.getId()+"</td>\r\n" + "    <td>"+task.getTaskname()
		 * +"</td>\r\n" + "    <td>"+task.getStartdate()+"</td>\r\n" +
		 * "    <td>"+task.getEnddate()+"</td>\r\n" + "    <td>"+task.getDescription()
		 * +"</td>\r\n" + "    <td>"+task.getUserId()+"</td>\r\n" + "  </tr>";
		 * 
		 * } out +="</table>";
		 */	return (List<Tasks>) repo.findAll();
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
