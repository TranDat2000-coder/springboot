package com.example.quanlybanhang.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category_product")
public class CateProductEntity extends BaseEntity {
	
	@Column(name = "name", length = 40)
	private String name;

	@Column(name = "code")
	private String code;

	@Column(name = "thumbnail")
	private String thumbnail;	

	@Column(name = "content")
	private String content;

	@OneToMany(mappedBy = "category")
	private List<ProductEntity> product = new ArrayList<>();

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

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<ProductEntity> getProduct() {
		return product;
	}

	public void setProduct(List<ProductEntity> product) {
		this.product = product;
	}
	
	
}
