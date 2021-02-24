package com.hcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.model.Tasks;
import com.hcl.model.user.User;
import com.hcl.model.user.UserRepo;
import com.hcl.service.TaskServiceImpl;

@Controller
//@RequestMapping("user")
public class UserController {
	@Autowired
	TaskServiceImpl service;
	@Autowired
	UserRepo repo;

	static User user;

	@GetMapping("/login")
	public String login() {
		return "user/login";

	}

	@GetMapping("/logout")
	public String logout() {
		return "user/login";

	}

	@GetMapping("/register")
	public String registration() {

		return "user/registration";
	}

	// method to add a user to the database
	@PostMapping("/register")
	public String admin(@RequestParam(name = "username") String username, @RequestParam(name = "pwd") String pwd,
			@RequestParam(name = "role") String role) {

		user = new User();
		user.setUsername(username);
		user.setRole(role);
		user.setPwd(pwd);
		repo.save(user);
		return "user/login";
	}

	// Once the user is authenticated at login, using spring security, the welcome
	// page is displayed with the options
	@GetMapping("/")
	public String welcome(ModelMap model) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUserName = authentication.getName();

			user = repo.findByUsername(currentUserName).get();
		}
		model.put("msg", "Hello " + user.getUsername());
		return "task/welcome";
	}

	// gets the userid of the logged in user
	@GetMapping("/create")
	public String create(ModelMap model) {
		model.put("userid", user.getUserid());
		return "task/create";
	}

	// can create a task and on submission takes you to display page
	@PostMapping("/create")
	public String createTask(@ModelAttribute("task") Tasks task, ModelMap model) {
		task.setUser(user);
		task.setUser(user);
		service.saveOrUpdate(task);
		System.out.println(task.toString());
		model.put("tasks", service.getAllTasksByUser(user));
		return "task/display";

		/*
		 * } catch (Exception e) { return "task/error1"; }
		 */

	}

	// user can click the delete button from the welcome page and be taken to the
	// display page where they can select a task to delete
	@GetMapping("/deletefromwelcome")
	public String deletefromwelcome(ModelMap model) {
		model.put("msg", "Select task to delete");
		model.put("tasks", service.getAllTasksByUser(user));
		return "task/display";
	}

	// the user is required to select a task that needs to be deleted to proceed
	// with the operation and the same task id is noted
	@PostMapping("/delete")
	public String delete(@RequestParam(name = "selected", required = false) String id, ModelMap model, Tasks task) {
		if (id == null) {
			model.put("msg", "Please select a task to delete");
			if (!service.getAllTasksByUser(user).isEmpty()) {

				model.put("tasks", service.getAllTasksByUser(user));
			} else {
				model.put("msg", "No tasks created");
			}

			return "task/display";
		}

		System.out.println(id);
		model.put("task", service.findById(Integer.parseInt(id)).get());
		return "task/delete";
	}

	// asks the user for confirmation and deletes the task
	@PostMapping("/deleteconf")
	public String deleteconf(@RequestParam(name = "task.id") String id, ModelMap model) {
		System.out.println(service.findById(Integer.parseInt(id)).get());
		service.deleteTask(service.findById(Integer.parseInt(id)).get());
		model.put("msg", "Task deleted successfully");
		return "task/welcome";
	}

	// is to display the tasks
	@GetMapping("/display")
	public String display(ModelMap model) {
		if (!service.getAllTasksByUser(user).isEmpty()) {

			model.put("tasks", service.getAllTasksByUser(user));
		} else {
			model.put("msg", "No tasks created");
		}

		return "task/display";
	}

	// to update from the welcome page, the user is take to the display page to
	// carry out the update operation
	@GetMapping("/updatefromwelcome")
	public String updatefromwelcome(ModelMap model) {
		model.put("msg", "Select task to update");
		model.put("tasks", service.getAllTasksByUser(user));
		return "task/display";
	}

	// the user is required to select a task that needs to be updated to proceed
	// with the operation and the same task id is noted
	@PostMapping("/update")
	public String update(@RequestParam(name = "selected", required = false) String id, ModelMap model, Tasks task) {
		if (id == null) {
			model.put("msg", "Please select an option to update");
			if (!service.getAllTasksByUser(user).isEmpty()) {

				model.put("tasks", service.getAllTasksByUser(user));
			} else {
				model.put("msg", "No tasks created");
			}

			return "task/display";
		}

		System.out.println(id);
		model.put("task", service.findById(Integer.parseInt(id)).get());
		return "task/update";
	}

	// asks the user for confirmation and updates the task
	@PostMapping("/updateconf")
	public String updateconf(@ModelAttribute("task") Tasks task, ModelMap model) {
		task.setUser(user);
		System.out.println(task.toString());
		model.put("msg", "task updated");
		service.saveOrUpdate(task);
		model.put("tasks", service.getAllTasksByUser(user));
		return "task/display";

	}
}
