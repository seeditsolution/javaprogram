package com.enti;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Note {

	@Id
	/*
	 * @GeneratedValue //we can also used this statement for auto_increement but in
	 * this case the value is start from index 0;
	 */	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	
	@Column(length=1500)
	private String content;
     
	private int rid;
	
    
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Note(String title, String content,int rid) {
		super();
		//this.id = id;
		this.title = title;
		this.content = content;
		this.rid = rid;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
