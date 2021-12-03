package com.example.quanlybanhang.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "info")
public class InfoProductEntity extends BaseEntity {

	@Column(name = "company")
	private String company;
	
	@Column(name = "height")
	private Float height;
	
	@Column(name = "weight")
	private Float weight;
	
	@Column(name = "romphone")
	private Integer romPhone;
	
	@Column(name = "ramphone")
	private Integer ramPhone;
	
	@Column(name = "screensize")
	private Float screenSize;
	
	@Column(name = "systemversion")
	private String systemVersion;
	
	@Column(name = "chipset")
	private String chipset;
	
	@Column(name = "pinphone")
	private Integer pinPhone;
	
	@OneToOne(mappedBy = "info")
	private ProductEntity product;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Integer getRomPhone() {
		return romPhone;
	}

	public void setRomPhone(Integer romPhone) {
		this.romPhone = romPhone;
	}

	public Integer getRamPhone() {
		return ramPhone;
	}

	public void setRamPhone(Integer ramPhone) {
		this.ramPhone = ramPhone;
	}

	public Float getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(Float screenSize) {
		this.screenSize = screenSize;
	}

	public String getSystemVersion() {
		return systemVersion;
	}

	public void setSystemVersion(String systemVersion) {
		this.systemVersion = systemVersion;
	}

	public String getChipset() {
		return chipset;
	}

	public void setChipset(String chipset) {
		this.chipset = chipset;
	}

	public Integer getPinPhone() {
		return pinPhone;
	}

	public void setPinPhone(Integer pinPhone) {
		this.pinPhone = pinPhone;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}
	
	
}
