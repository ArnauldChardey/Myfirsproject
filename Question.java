package com.recherche.quizgame;

public class Question {
	private String text;
	private String reponse;
	
	public Question( String text, String reponse){
	this.text= text;
	this.reponse= reponse;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
	

}
