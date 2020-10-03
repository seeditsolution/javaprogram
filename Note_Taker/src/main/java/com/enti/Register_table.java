package com.enti;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Register_table {

	@Id
	/*
	 * @GeneratedValue //we can also used this statement for auto_increement but in
	 * this case the value is start from index 0;
	 */	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length=50)
	private String name;
	
	@Column(length=50)
	private String email;
	
	@Column(length=50)
	private String login_id;
	
	@Column(length=50)
	private String  password;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Register_table() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Register_table(String name, String email, String login_id, String password) {
		super();
		//this.id = new Random().nextInt(100);
		this.name = name;
		this.email = email;
		this.login_id = login_id;
		this.password = password;
	}
	
	
}
