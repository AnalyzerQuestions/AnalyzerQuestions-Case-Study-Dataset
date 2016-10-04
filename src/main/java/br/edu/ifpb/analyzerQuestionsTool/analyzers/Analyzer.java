package br.edu.ifpb.analyzerQuestionsTool.analyzers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.analyzerQuestionsTool.entities.Question;
import br.edu.ifpb.analyzerQuestionsTool.enumerations.Messages;

public class Analyzer implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<String> messages = new ArrayList<String>();
	private QuestionAnalyzerFinal questionAnalyzer;

	*//**
	 * 
	 * @param title
	 * @param description
	 *//*
	public void analyse(Question question) {
		messages.clear();

		questionAnalyzer = new QuestionAnalyzerFinal();

		this.analyseTitleCapitaLetters(question.getTitle());
		this.analyseTitleCapitaLettersPartially(question.getTitle());
		this.analyseUnderstandableTitle(question.getTitle(), question.getBody());
		this.analyseMediumSizeTitle(question.getTitle());
		this.analyseCoherencyBodyAndTitle(question.getTitle(), question.getBody());
		this.analyseUnderstandableDescription(question.getBody());
		this.analyseIncludingVocative(question.getBody());
		this.analyseShowingExample(question.getBody());
		this.analyseShortDescription(question.getBody());
		this.analyseLongDescription(question.getBody());
		this.analyseAvoidingMuchCode(question.getBody());
		this.analyseQuestionWithSingleProblem(question.getBody());
		
		
	}

	*//**
	 * 
	 * @param title
	 * @param description
	 * @return
	 *//*
	public void analyseUnderstandableTitle(String title, String description) {
		if (questionAnalyzer.understandableTitle(title, description) == 0)
			messages.add(Messages.TITULO_BEM_DEFINIDO.getMsg());
	}
	
	*//**
	 * 
	 * @param title
	 *//*
	public void analyseMediumSizeTitle(String title){
		if(questionAnalyzer.mediumSizeTitle(title) == 0)
			messages.add(Messages.MEDIO_SIZE_TITLE.getMsg());
		
	}

	*//**
	 * 
	 * @param title
	 * @return
	 *//*
	public void analyseTitleCapitaLetters(String title) {
		if (questionAnalyzer.titleCapitaLetters(title) == 0)
			messages.add(Messages.TITLE_CAPITA_LETTERS.getMsg());
	}
	
	*//**
	 * 
	 * @param title
	 *//*
	public void analyseTitleCapitaLettersPartially(String title){
		if(questionAnalyzer.titleCapitaLettersPartially(title) == 0)
			messages.add(Messages.TITLE_CAPITA_PARTIALLY_LETTERS.getMsg());
	}
	
	*//**
	 * 
	 * @param title
	 * @param description
	 *//*
	public void analyseCoherencyBodyAndTitle(String title, String description){
		if(questionAnalyzer.coherencyBodyAndTitle(title, description) == 0)
			messages.add(Messages.COERENCY_BODY_WITH_TITLE.getMsg());
	}
	
	*//**
	 * 
	 * @param description
	 *//*
	public void analyseUnderstandableDescription(String description){
		if(questionAnalyzer.understandableDescription(description) == 0)
			messages.add(Messages.UNDERSTANDABLE_DESCRIPTION.getMsg());
	}
	
	*//**
	 * 
	 * @param description
	 *//*
	public void analyseIncludingVocative(String description){
		if(questionAnalyzer.includingVocative(description) == 0)
			messages.add(Messages.INCLUDING_VOCATIVE.getMsg());
	}
	
	*//**
	 * 
	 * @param description
	 *//*
	public void analyseShowingExample(String description){
		if(questionAnalyzer.showingExample(description) == 0)
			messages.add(Messages.SHOW_EXAMPLE.getMsg());
	}
	
	*//**
	 * 
	 * @param description
	 *//*
	public void analyseShortDescription(String description){
		if(questionAnalyzer.shortDescription(description) == 0)
			messages.add(Messages.SHORT_DESCRIPTION.getMsg());
	}
	
	*//**
	 * 
	 * @param description
	 *//*
	public void analyseLongDescription(String description){
		if(questionAnalyzer.longDescription(description) == 0)
			messages.add(Messages.LONG_DESCRIPTION.getMsg());
	}
	
	*//**
	 * 
	 * @param description
	 *//*
	public void analyseAvoidingMuchCode(String description){
		if(questionAnalyzer.avoidingMuchCode(description) == 0)
			messages.add(Messages.AVOIDING_MUCH_CODE.getMsg());
	}
	
	*//**
	 * 
	 * @param description
	 *//*
	public void analyseAvoidDescriptionWithCodeOnly(String description){
		if(questionAnalyzer.avoidDescriptionWithCodeOnly(description) == 0)
			messages.add(Messages.AVOIDING_DESCRIPTION_WITH_CODE_ONLY.getMsg());
	}
	
	*//**
	 * 
	 * @param description
	 *//*
	public void analyseQuestionWithSingleProblem(String description){
		if(questionAnalyzer.questionWithSingleProblem(description) == 0)
			messages.add(Messages.QUESTION_WITH_SINGLE_PROBLEM.getMsg());
	}
	
	*//**
	 * 
	 * @param description
	 *//*
	public void analyseIncludingGreetings(String description){
		if(questionAnalyzer.includingGreetings(description) == 0)
			messages.add(Messages.INCLUDING_GREETINGS.getMsg());
	}
	
	*//**
	 * 
	 * @return
	 *//*
	public List<String> getMessages() {
		return messages;
	}

	
	 * 
	 
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	*//**
	 * 
	 * @return
	 *//*
	public QuestionAnalyzer getQuestionAnalyzer() {
		return questionAnalyzer;
	}

	*//**
	 * 
	 * @param questionAnalyzer
	 *//*
	public void setQuestionAnalyzer(QuestionAnalyzer questionAnalyzer) {
		this.questionAnalyzer = questionAnalyzer;
	}
	
	public static void main(String[] args) {
		Analyzer a = new Analyzer();
		Question q = new Question();
		q.setTitle("efrfr");
		q.setBody("rfrfr");
		a.analyse(q);
	}

}
