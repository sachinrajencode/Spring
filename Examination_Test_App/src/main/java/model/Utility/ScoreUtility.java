package model.Utility;

import java.util.List;

import model.entity.Question;

public class ScoreUtility {

	public static int calculateScore(List<Question>  questions,List<String>  answers) 
	{
		int score = 0;
	   for(int i = 0;i<questions.size();i++) {
		Question question = questions.get(i);
		String answer = answers.get(i);
		
		if(question.getAnswer().equalsIgnoreCase(answer)) {
			score++;
		}
				
	   }
	   return score;
	}
}
