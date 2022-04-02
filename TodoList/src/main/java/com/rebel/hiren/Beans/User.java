package com.rebel.hiren.Beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user_table")
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uId;
	private String uName;
	private String uSurname;
	@Column(name="uemail" ,unique=true)
	private String uEmail;
	private String uPass;
	private String hashPass;
	@Column(columnDefinition = "int default 0")
	private int status;
	@OneToMany(mappedBy = "user")
	private List<Todo> todoList = new ArrayList<>();
	
	
	public User() {}
	
	

	public User(int uId, String uName, String uSurname, String uEmail, String uPass, String hashPass) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.uSurname = uSurname;
		this.uEmail = uEmail;
		this.uPass = uPass;
		this.hashPass = hashPass;
	}



	public User(String uName, String uSurname, String uEmail, String uPass, String hashPass) {
		super();		
		this.uName = uName;
		this.uSurname = uSurname;
		this.uEmail = uEmail;
		this.uPass = uPass;
		this.hashPass = hashPass;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuSurname() {
		return uSurname;
	}

	public void setuSurname(String uSurname) {
		this.uSurname = uSurname;
	}

	public String getuEmail() {
		return uEmail;
	}

	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}

	public String getuPass() {
		return uPass;
	}

	public void setuPass(String uPass) {
		this.uPass = uPass;
	}
	
	public String getHashPass() {
		return hashPass;
	}

	public void setHashPass(String hashPass) {
		this.hashPass = hashPass;
	}

	public List<Todo> getTodoList() {
		return todoList;
	}

	public void setTodoList(List<Todo> todoList) {
		this.todoList = todoList;
	}
	
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [uId=" + uId + ", uName=" + uName + ", uSurname=" + uSurname + ", uEmail=" + uEmail + ", uPass="
				+ uPass + "]";
	}
	
	
	
	
	

}
