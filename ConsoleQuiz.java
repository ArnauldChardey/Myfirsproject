package com.recherche.quizgame;

import java.util.Scanner;

import com.recherche.quizgame.generators.QuestionsGenerator;

public class ConsoleQuiz extends Quiz {
	Scanner clavier = new Scanner( System.in);

	public ConsoleQuiz(QuestionsGenerator generator) {
		super(generator);
		
	}

	@Override
	public void displayMessage(String Message) {
		System.out.println(Message);
		
	}

	@Override
	public String retrieveAnswer(String prompt) {
		displayMessage(prompt);
		return clavier.nextLine();
	}
	
}
