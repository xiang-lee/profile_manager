package com.pm.core.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "pm_user")	
public class User {
	private long id;
	private String name;
	private String email;
	private Set<Group> groups = new HashSet<Group>(0);
	
	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "pm_user_group", joinColumns = { 
			@JoinColumn(name = "user_id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "group_id", 
					nullable = false, updatable = false) })
	public Set<Group> getGroups() {
		return groups;
	}

	@Id
    @GeneratedValue
    @Column(name = "id")
	public long getId() {
		return id;
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
