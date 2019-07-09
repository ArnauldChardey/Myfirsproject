package com.recherche.quizgame.generators;

import java.util.ArrayList;

import com.recherche.quizgame.Question;

 abstract public class QuestionsGenerator {
	  protected int nbreQuestions;
	  
public QuestionsGenerator(int nbreQuestions){
	this.nbreQuestions = nbreQuestions;
}
 abstract public ArrayList<Question>generate()throws Exception;
 
public int getNbreQuestion(){
	return nbreQuestions;
}

}
