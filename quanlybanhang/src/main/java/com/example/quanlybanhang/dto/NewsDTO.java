package com.example.quanlybanhang.dto;

public class NewsDTO extends AbstractDTO<NewsDTO> {
	
	private String title;
	private String thumbnail;
	private String shortDesciption;
	private String content;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getShortDesciption() {
		return shortDesciption;
	}
	public void setShortDesciption(String shortDesciption) {
		this.shortDesciption = shortDesciption;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	
	
}
