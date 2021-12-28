

package com.rebel.hiren.Beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "todo_table")
public class Todo 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int todoId;
	private String todoName;
	private String todoDescription;
	private String todoSdate;
	private String todoEdate;
	@ManyToOne
	private User user;
	
	public Todo() {}

	public Todo(String todoName, String todoDescription, String todoSdate, String todoEdate) {
		super();		
		this.todoName = todoName;
		this.todoDescription = todoDescription;
		this.todoSdate = todoSdate;
		this.todoEdate = todoEdate;
	}
	
	

	public Todo(int todoId, String todoName, String todoDescription, String todoSdate, String todoEdate) {
		super();
		this.todoId = todoId;
		this.todoName = todoName;
		this.todoDescription = todoDescription;
		this.todoSdate = todoSdate;
		this.todoEdate = todoEdate;
	}

	public int getTodoId() {
		return todoId;
	}

	public void setTodoId(int todoId) {
		this.todoId = todoId;
	}

	public String getTodoName() {
		return todoName;
	}

	public void setTodoName(String todoName) {
		this.todoName = todoName;
	}

	public String getTodoDescription() {
		return todoDescription;
	}

	public void setTodoDescription(String todoDescription) {
		this.todoDescription = todoDescription;
	}

	public String getTodoSdate() {
		return todoSdate;
	}

	public void setTodoSdate(String todoSdate) {
		this.todoSdate = todoSdate;
	}

	public String getTodoEdate() {
		return todoEdate;
	}

	public void setTodoEdate(String todoEdate) {
		this.todoEdate = todoEdate;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Todo [todoId=" + todoId + ", todoName=" + todoName + ", todoDescription=" + todoDescription
				+ ", todoSdate=" + todoSdate + ", todoEdate=" + todoEdate + "]";
	}
	
	
	
	
	
	

}
