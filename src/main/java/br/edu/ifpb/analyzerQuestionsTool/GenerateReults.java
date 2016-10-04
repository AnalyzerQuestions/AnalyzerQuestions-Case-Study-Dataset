package br.edu.ifpb.analyzerQuestionsTool;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.analyzerQuestionsTool.analyzers.QuestionAnalyzerImpl;
import br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI.entities.pojos.QuestionPojo;
import br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI.entities.types.Question;

public class GenerateReults {
	
	private QuestionAnalyzerImpl analyzer;
	
	
	public GenerateReults() {
		analyzer = new QuestionAnalyzerImpl();
	}
	
	public List<QuestionPojo> generate(List<Question> questions){
		
		List<QuestionPojo> questionPojos = new ArrayList<QuestionPojo>();
		
		for (Question question : questions) {
			QuestionPojo qp = new QuestionPojo();
			qp.setColumnQuestion(question);
			qp.setColumnUnderstandableTitle(analyzer.understandableTitle(question.getTitle(), question.getBodyMarkdown()));
			qp.setColumnMediumSizeTitle(analyzer.mediumSizeTitle(question.getTitle()));
			qp.setColumnTitleCapitaLetters(analyzer.mediumSizeTitle(question.getTitle()));
			qp.setColumnTitleCapitaLettersPartially(analyzer.mediumSizeTitle(question.getTitle()));
			qp.setColumnCoherencyBodyAndTitle(analyzer.coherencyBodyAndTitle(question.getTitle(), question.getBodyMarkdown()));
			qp.setColumnUnderstandableDescription(analyzer.understandableDescription(question.getBodyMarkdown()));
			qp.setColumnIncludingVocative(analyzer.includingVocative(question.getBodyMarkdown()));
			qp.setColumnShortDescription(analyzer.shortDescription(question.getBodyMarkdown()));
			qp.setColumnLongDescription(analyzer.longDescription(question.getBodyMarkdown()));
			qp.setColumnShowingExample(analyzer.showingExample(question.getBodyMarkdown()));
			qp.setColumnAvoidingMuchCode(analyzer.avoidingMuchCode(question.getBodyMarkdown()));
			qp.setColumnAvoidDescriptionWithCodeOnly(analyzer.avoidDescriptionWithCodeOnly(question.getBodyMarkdown()));
			qp.setColumnQuestionWithSingleProblem(analyzer.questionWithSingleProblem(question.getBodyMarkdown()));
			qp.setColumnIncludingGreetings(analyzer.includingGreetings(question.getBodyMarkdown()));
			qp.setColumnObviatingDemandingLanguage(analyzer.obviatingDemandingLanguage(question.getBodyMarkdown()));
			qp.setColumnUsingProperLanguage(analyzer.usingProperLanguage(question.getBodyMarkdown()));
			qp.setColumnAvoidingCreatingFactoidQuestions(analyzer.avoidingCreatingFactoidQuestions(question.getBodyMarkdown()));
			qp.setColumnDoNotCreateHomeworkQuestions(analyzer.doNotCreateHomeworkQuestions(question.getBodyMarkdown()));
			//qp.setColumncontainsLog(analyzer.containsLog(question.getBodyMarkdown()));
			
			questionPojos.add(qp);
		}
		
		return questionPojos;
	}

}
