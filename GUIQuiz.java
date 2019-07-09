package com.recherche.quizgame;

import javax.swing.JOptionPane;

import com.recherche.quizgame.generators.QuestionsGenerator;


public class GUIQuiz extends Quiz {

	public GUIQuiz(QuestionsGenerator generator) {
		super(generator);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void displayMessage(String Message) {
		JOptionPane.showMessageDialog(null, Message);
		
	}

	@Override
	public String retrieveAnswer(String prompt) {
		// TODO Auto-generated method stub
		return JOptionPane.showInputDialog(prompt);
	}

}
