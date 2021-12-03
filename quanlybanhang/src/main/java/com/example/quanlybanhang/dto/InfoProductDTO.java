package com.example.quanlybanhang.dto;

public class InfoProductDTO extends AbstractDTO<InfoProductDTO> {

	private String company;
	private Float height;
	private Float weight;
	private Integer romPhone;
	private Integer ramPhone;
	private Float screenSize;
	private String systemVersion;
	private String chipset;
	private Integer pinPhone;
	
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
	
	
	

}
