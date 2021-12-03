package com.example.quanlybanhang.entites;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class RoleEntity extends BaseEntity {

	@Column(name = "name")
	private String name;
	
	@Column(name = "code")
	private String code;
	
	@ManyToMany(mappedBy = "roles")
	private List<UserEntity> users = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

	
	
	
}
