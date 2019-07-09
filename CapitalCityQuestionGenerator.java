package com.recherche.quizgame.generators;
import java.util.ArrayList;
import java.util.Random;

import com.recherche.quizgame.Question;

public class CapitalCityQuestionGenerator extends QuestionsGenerator {
	
//	private int nbreQuestions;
public CapitalCityQuestionGenerator(int nbreQuestions){
		super(nbreQuestions);
		
	}
	
	
//	public int getNbreQuestion(){
//		return nbreQuestions;
//	}
	
	public ArrayList<Question> generate() {
		String[][] data = getData();

		if (nbreQuestions > data.length) {
			throw new IllegalArgumentException("Il n y a que\n" + data.length
					+ " question disponible");
		}

		ArrayList<Question> question = new ArrayList<>();
		int index;

		ArrayList<Integer> indexesAlreadyTaken = new ArrayList<>();

		// Scanner clavier = new Scanner(System.in);

		indexesAlreadyTaken.clear();
		for (int i = 0; i < nbreQuestions; i++) {
			do {
				Random random = new Random();
				index = random.nextInt(data.length);
			} while (indexesAlreadyTaken.contains(index));
			indexesAlreadyTaken.add(index);

			String pays = data[index][0];
			String capitale = data[index][1];
			String questionText = String.format(
					"Quelle est la capitale de ce pays :%s?\n", pays);
			question.add(new Question(questionText, capitale));
		}

		return question;
	}

	private static String[][] getData() {
		String[][] data = { { "Senegal", "Dakar" }, { "France", "Paris" },
				{ "Nigeria", "Abuja" }, { "Gabon", "libreville" },
				{ "Togo", "Lome" }, { "Allmagne", "Belin" },
				{ "Italie", "Rome" }, { "Monaco", "Manaco" },
				{ "Liberia", "Morovia" }, { "Perou", "Lima" },
				{ "Madagascar", "Antananarivo" } };
		return data;
	}

	 
	

}
