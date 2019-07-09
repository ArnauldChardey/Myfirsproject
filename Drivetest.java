package com.recherche.quizgame;


//import com.recherche.quizgame.generators.CapitalCityQuestionGenerator;
import com.recherche.quizgame.generators.MathQuestionsGenerator;

public class Drivetest {

	public static void main(String[] args) {
 Quiz quiz = new GUIQuiz(new MathQuestionsGenerator(2));
 
 quiz.star();
 quiz.displayResults();
	}

}
