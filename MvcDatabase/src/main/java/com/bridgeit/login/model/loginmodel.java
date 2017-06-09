package com.bridgeit.login.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="login")
public class loginmodel implements Serializable {
	
	@Id
	@GenericGenerator(name="any",strategy="increment")
	@GeneratedValue(generator="any")
	int id;
	
	@Column(name="user")
	String user;
	@Column(name="password")
	String password;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "loginmodel [id=" + id + ", user=" + user + ", password=" + password + "]";
	}
}
