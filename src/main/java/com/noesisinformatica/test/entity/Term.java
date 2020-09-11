package com.noesisinformatica.test.entity;



public class Term {

	@Override
	public String toString() {
		return "Term [userId=" + userId + ", term=" + term + "]";
	}
	int userId;
	String term;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
}
