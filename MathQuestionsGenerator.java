package com.recherche.quizgame.generators;

import java.util.ArrayList;
import java.util.Random;

import com.recherche.quizgame.Question;

public class MathQuestionsGenerator  extends QuestionsGenerator {

	public MathQuestionsGenerator(int nbreQuestions) {
		super(nbreQuestions);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Question> generate() {
ArrayList<Question>questions = new ArrayList<>();
Random random = new Random();
char[] operators={'+','-','*','/'};

for (int i = 0; i < nbreQuestions; i++) {
	int nbre1 = random.nextInt(15);
	int nbre2 = random.nextInt(15)+1;
	char operator= operators[random.nextInt(operators.length)];
	String questionText = String.format("%d %c %d=?",nbre1,operator,nbre2);
	
	questions.add(new Question(questionText,calculate(operator,nbre1,nbre2)));
}
		return questions;
	}

	private String calculate(char operator, int nbre1, int nbre2) {
		String reponse = null;
		switch (operator) {
		case '+':
		reponse= String.valueOf(nbre1+ nbre2);
			
			break;
			
		case '-':
			reponse= String.valueOf(nbre1 - nbre2);
				
				break;	
		case '*':
			reponse= String.valueOf(nbre1 * nbre2);
				
				break;	
				
		case '/':
			reponse= String.valueOf(nbre1/nbre2);
				
				break;

		default:
			break;
		}
		return reponse;
	}

}
