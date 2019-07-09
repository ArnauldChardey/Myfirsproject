package com.recherche.quizgame;

import com.recherche.quizgame.generators.QuestionsGenerator;
import com.recherche.quizgame.utils.TimeConverteur;

//import java.util.ArrayList;
//import java.util.Random;
//import java.util.Scanner;

public  abstract class Quiz {
	private QuestionsGenerator generator ;
	private int score;
	private long timeElapsed;
	private boolean done = false;
	//private int nbreQuestions;
	//Scanner clavier = new Scanner(System.in);
	//private static final int NUMBER_OF_Question = 11;
	
	
	public Quiz(QuestionsGenerator generator) {
		this.generator =generator;
		
	}
	
	abstract public void displayMessage(String Message);
		
	
	abstract public String retrieveAnswer(String prompt);
	
	

	public void star() {
		try {
			long startTime = System.currentTimeMillis();
			for (Question question : generator.generate()) {
				String userAnswer = retrieveAnswer(question.getText());
//				String userAnswer = clavier.nextLine();
				if (userAnswer.equalsIgnoreCase(question.getReponse())) {
					score++;
					displayMessage("BONNE REPONSE ! FELICITATION!!!");
				} else {
					
					displayMessage("OOPS! MAUVAISE REPONSE:\nLa bonne reponse etait:"
							+ question.getReponse());
				}

			}
			done= true;
			long endTime = System.currentTimeMillis();
			timeElapsed = endTime - startTime;
		} catch (Exception e) {
			done= false;
			System.out.println(e.getMessage());
		}
	}

//	private int getTimeElapsedInSeconds(long timeInMilliseconds) {
//
//		return (int) (timeInMilliseconds / 1000);
//	}

	public void displayResults() {
		
		if(done){
			displayScore();
			displayTimeElapsed();
		}
//		System.out.printf("Votre score final est de %d/%d\n", score,
//				NUMBER_OF_Question);

//		System.out
//				.printf("Il vous a fallu environ %d secondes pour repondre aux %d questions.\n",
//						getTimeElapsedInSeconds(timeElapsed),
//						NUMBER_OF_Question);
	}
	
	private void displayTimeElapsed(){
		
		displayMessage(String.format("Il vous a fallu environ %d secondes pour repondre aux %d questions.\n",
			TimeConverteur.toSeconds(timeElapsed),
			generator.getNbreQuestion()));
		
	}
	private void displayScore(){
		
		displayMessage(String.format ("Votre score final est de %d/%d\n", score,
				generator.getNbreQuestion()));
		
	}

//	public ArrayList<Question> generate(int nbreQuestion) {
//		String[][] data = getData();
//
//		if (nbreQuestion > data.length) {
//			throw new IllegalArgumentException("Il n y a que\n" + data.length
//					+ " question disponible");
//		}
//
//		ArrayList<Question> question = new ArrayList<>();
//		int index;
//
//		ArrayList<Integer> indexesAlreadyTaken = new ArrayList<>();
//
//		// Scanner clavier = new Scanner(System.in);
//
//		indexesAlreadyTaken.clear();
//		for (int i = 0; i < nbreQuestion; i++) {
//			do {
//				Random random = new Random();
//				index = random.nextInt(data.length);
//			} while (indexesAlreadyTaken.contains(index));
//			indexesAlreadyTaken.add(index);
//
//			String pays = data[index][0];
//			String capitale = data[index][1];
//			String questionText = String.format(
//					"Quelle est la capitale de ce pays :%s?\n", pays);
//			question.add(new Question(questionText, capitale));
//		}
//
//		return question;
//	}
//
//	private static String[][] getData() {
//		String[][] data = { { "Senegal", "Dakar" }, { "France", "Paris" },
//				{ "Nigeria", "Abuja" }, { "Gabon", "libreville" },
//				{ "Togo", "Lome" }, { "Allmagne", "Belin" },
//				{ "Italie", "Rome" }, { "Monaco", "Manaco" },
//				{ "Liberia", "Morovia" }, { "Perou", "Lima" },
//				{ "Madagascar", "Antananarivo" } };
//		return data;
//	}

}
