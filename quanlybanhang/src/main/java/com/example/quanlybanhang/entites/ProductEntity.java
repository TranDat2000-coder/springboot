package com.example.quanlybanhang.entites;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class ProductEntity extends BaseEntity {
	
	@Column(name = "name", length = 40)
	private String name;
	
	@Column(name = "thumbnail")
	private String thumbnail;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "pricesale")
	private Double priceSale;
	
	@Column(name = "description", columnDefinition = "TEXT")
	private String description;
	
	@Column(name = "shortdescription", columnDefinition = "TEXT")
	private String shortDescription;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
    private CateProductEntity category;
	
	@OneToOne
	@JoinColumn(name = "infoid")
	private InfoProductEntity info;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}


	public Double getPriceSale() {
		return priceSale;
	}

	public void setPriceSale(Double priceSale) {
		this.priceSale = priceSale;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public CateProductEntity getCategory() {
		return category;
	}

	public void setCategory(CateProductEntity category) {
		this.category = category;
	}

	public InfoProductEntity getInfo() {
		return info;
	}

	public void setInfo(InfoProductEntity info) {
		this.info = info;
	}
	
	
	
	
	
}
