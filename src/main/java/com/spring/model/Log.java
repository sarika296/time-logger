package com.spring.model;

import java.text.SimpleDateFormat;  
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 

@Entity
@Table(name = "logs")
public class Log {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="username_fk")
	private String username;
	
	private String category;
	
	@Column(name="tag")
	private String tag;
	
	@Column(name="data_time")
	private String dateTime;
	
	@Column(name="duration")
	private int duration;
	
	@Column(name="log_details")
	private String log_details; 
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
    Date date = new Date();  
	
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getDateTime() {
		return formatter.format(date);
	}
	public void setDateTime(String string) {
		this.dateTime = string;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getLog_details() {
		return log_details;
	}
	public void setLog_details(String log_details) {
		this.log_details = log_details;
	}
}

