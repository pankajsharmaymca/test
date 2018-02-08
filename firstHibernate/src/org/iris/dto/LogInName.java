package org.iris.dto;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class LogInName implements Serializable{

	private int  id ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	private String emailid;
}
