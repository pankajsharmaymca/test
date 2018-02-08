package org.iris.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table ( name="USER_DETAILS")
public class UserDetails {
	//@Id @GeneratedValue(strategy=GenerationType.AUTO)
	//private int userId ;
	@EmbeddedId
	private LogInName userId ;
	@Transient
	private String userName;
	@Temporal(TemporalType.TIME)
	private Date joinedDate;
	@Embedded
	@AttributeOverrides({
	@AttributeOverride( name="street", column=@Column(name="HOME_STREET")),
	@AttributeOverride( name ="city" , column=@Column(name="Home_city")),
	@AttributeOverride( name ="state" , column=@Column(name="Home_state")),
	@AttributeOverride( name ="pincode" , column=@Column(name="Home_pincode")),
	
	})
	private Address homeAddress;
	@ElementCollection
	@JoinTable(name="USER_ADDRESS" ,
	joinColumns= {@JoinColumn(name="ABC"),@JoinColumn(name="pqr")}
	)
	private Set<Address> listofAddress = new HashSet();
	
	
	public Set<Address> getListofAddress() {
		return listofAddress;
	}
	public void setListofAddress(Set<Address> listofAddress) {
		this.listofAddress = listofAddress;
	}
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getWorkAddress() {
		return workAddress;
	}
	public void setWorkAddress(Address workAddress) {
		this.workAddress = workAddress;
	}
	@Embedded
	private Address workAddress;
	
	@Lob
	private String description;
	
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
	
	public LogInName getUserId() {
		return userId;
	}
	public void setUserId(LogInName userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
