package com.spring.boot.model;

public class Book {
	private String id;

	private String title;

	private String author;

	private String detail;

	private String releaseDate;

	public Book() {
	}

	public Book(String id, String title, String author, String releaseDate) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.releaseDate = releaseDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public String toString() {
		return "Book{" + "id='" + id + '\'' + ", title='" + title + '\'' + ", author='" + author + '\'' + ", releaseDate='" + releaseDate + '\'' + '}';
	}
}
