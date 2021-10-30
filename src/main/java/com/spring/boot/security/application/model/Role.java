package com.spring.boot.security.application.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ROLE")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String roleName;

	@ManyToMany(mappedBy = "roles")
	private Set<User> users;

	public Role() {
		System.out.println("Role() default constructor : Role class >>>>>>>>>>>>> ");
	}

	public Role(String roleName) {
		System.out.println("Role(roleName) 1 -arg constructor : Role class >>>>>>>>>>>>> ");
		this.roleName = roleName;
	}

	public Role(Long id) {
		System.out.println("Role(id) 1 -arg constructor : Role class >>>>>>>>>>>>> ");
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Role(String roleName, Set<User> users) {
		super();
		System.out.println("Role(roleName,Set<User>) 2 -args constructor : Role class >>>>>>>>>>>>> ");
		this.roleName = roleName;
		this.users = users;
	}

}
