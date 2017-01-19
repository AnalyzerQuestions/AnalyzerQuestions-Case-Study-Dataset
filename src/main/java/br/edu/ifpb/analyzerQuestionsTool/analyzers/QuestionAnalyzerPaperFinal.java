package br.edu.ifpb.analyzerQuestionsTool.analyzers;

import java.util.List;

/**
 * 
 * @author franck
 *
 */
public class QuestionAnalyzerPaperFinal {

	private QuestionAnalyzerFinal qa;
	
	public QuestionAnalyzerPaperFinal() {
		qa = new QuestionAnalyzerFinal();
	}
	
	
	public Integer analyzerObjective(String description) {
		if(qa.questionUnique(description) == 1){
			if(qa.analyzerShortDescriptionQuestion(description) == 1){
				return 1;
			}
		}
		
		return 0;
	}
	
	public Integer analyzerClarity(String title, String description) {
		if(qa.analyzerCoherencyBodyAndTitle(title, description) == 1){
			if(qa.isEvidentProbleam(description) == 1){
				return 1;
			}
		}
		
		return 0;
	}
	
	public Integer analyzerUnderstandableDescription(String title, String description) {
		if(qa.analyzerShowExample(description) == 1){
			if(analyzerMuchCodeOrOnlyCode(description) == 1){
				return 1;
			}
		}
		
		return 0;
	}
	
	public Integer analyzerBeEducated(String description, List<String> comments) {
		if(qa.analyzerAvoidCreateDuplicateQuestion(comments) == 1){
			if(qa.analyzerDoNotCreateHomeworkQuestions(description) == 1){
				if(qa.includingGreetings(description) == 1){
					if(qa.analyzerUsingProperLanguage(description) == 1) {
						return 1;
					}
				}
			}
		}
		return 0;
	}
	
	public Integer analyzerMuchCodeOrOnlyCode(String description){
		if(qa.avoidingMuchCode(description) == 1){
			if(qa.avoidDescriptionWithCodeOnly(description) == 1){
				return 1;
			}
		}
		
		return 0;
	}
}

