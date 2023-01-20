package com.models;

public class NoteData {
	
	private long userId;
	private String title;
	private String note;
	
	public long getId() {
		return userId;
	}
	public void setId(long id) {
		this.userId = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
