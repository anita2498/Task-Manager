package com.hcl.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.model.user.User;
@Repository
public interface TaskRepo extends CrudRepository<Tasks, Integer> {
	List <Tasks>findAllByUser(User user);
}
