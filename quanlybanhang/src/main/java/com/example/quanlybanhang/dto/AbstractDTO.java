package com.example.quanlybanhang.dto;

import java.util.Date;

public class AbstractDTO<T> {

	private Long id;
	private Date createDate;
	private Date modifiedDate;
	private String createBy;
	private String modifiledBy;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getModifiledBy() {
		return modifiledBy;
	}
	public void setModifiledBy(String modifiledBy) {
		this.modifiledBy = modifiledBy;
	}
	
	
}
