package com.hcl.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.hcl.model.user.User;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
public class Tasks {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String taskname;
	private Date startdate;
	private Date enddate;
	private String description;
	private String severity;
	@ManyToOne
	private User user;

}
