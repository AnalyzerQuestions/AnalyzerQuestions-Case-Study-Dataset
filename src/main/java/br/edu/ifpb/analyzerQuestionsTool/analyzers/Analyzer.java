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

	public void analyse(Question question) {
		messages.clear();

		questionAnalyzer = new QuestionAnalyzerFinal();

		this.analyseUnderstandableTitle(question.getTitle(), question.getBody());
		this.analyseCoherencyBodyAndTitle(question.getTitle(), question.getBody());
		this.analyzerObjective(question.getBody());
		this.analyzerClarity(question.getTitle(), question.getBody());
		this.analyseShowingExample(question.getBody());
		this.analyzerUnderstandableDescription(question.getTitle(), question.getBody());
		this.analyzerDetailAboutContext(question.getBody());
		this.analyzerBeEducated(question.getBody());
		this.analyzerUsingProperLanguage(question.getBody());
		
		this.analyzerShortDescriptionQuestion(question.getBody());
		this.analyzerDoNotCreateHomeworkQuestions(question.getBody());
		
		
	}

	public void analyseUnderstandableTitle(String title, String description) {
		if (questionAnalyzer.analyzerUnderstandableTitle(title, description) == 0)
			messages.add(Messages.TITULO_BEM_DEFINIDO.getMsg());
	}
	
	
	public void analyseCoherencyBodyAndTitle(String title, String description){
		if(questionAnalyzer.analyzerCoherencyBodyAndTitle(title, description) == 0)
			messages.add(Messages.COERENCY_BODY_WITH_TITLE.getMsg());
	}
	
	public void analyzerObjective(String description){
		if(questionAnalyzer.analyzerObjective(description) == 0)
			messages.add(Messages.UNDERSTANDABLE_DESCRIPTION.getMsg());
	}
	
	public void analyzerClarity(String title, String description){
		if(questionAnalyzer.analyzerClarity(title, description) == 0)
			messages.add(Messages.INCLUDING_VOCATIVE.getMsg());
	}
	
	public void analyseShowingExample(String description){
		if(questionAnalyzer.analyzerShowExample(description) == 0)
			messages.add(Messages.SHOW_EXAMPLE.getMsg());
	}
	
	
	public void analyzerUnderstandableDescription(String title, String description){
		if(questionAnalyzer.analyzerUnderstandableDescription(title, description) == 0)
			messages.add(Messages.LONG_DESCRIPTION.getMsg());
	}
	
	public void analyzerDetailAboutContext(String description){
		if(questionAnalyzer.analyzerDetailAboutContext(description) == 0)
			messages.add(Messages.AVOIDING_MUCH_CODE.getMsg());
	}
	
	public void analyzerBeEducated(String description){
		if(questionAnalyzer.analyzerBeEducated(description) == 0)
			messages.add(Messages.INCLUDING_GREETINGS.getMsg());
	}
	
	public void analyzerUsingProperLanguage(String description){
		if(questionAnalyzer.analyzerUsingProperLanguage(description) == 0)
			messages.add(Messages.INCLUDING_GREETINGS.getMsg());
	}
	
	public void analyzerShortDescriptionQuestion(String description){
		if(questionAnalyzer.analyzerShortDescriptionQuestion(description) == 0)
			messages.add(Messages.INCLUDING_GREETINGS.getMsg());
	}
	
	public void analyzerDoNotCreateHomeworkQuestions(String description){
		if(questionAnalyzer.analyzerDoNotCreateHomeworkQuestions(description) == 0)
			messages.add(Messages.INCLUDING_GREETINGS.getMsg());
	}
	
	public List<String> getMessages() {
		return messages;
	}

	
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public QuestionAnalyzerFinal getQuestionAnalyzer() {
		return questionAnalyzer;
	}

	public void setQuestionAnalyzer(QuestionAnalyzerFinal questionAnalyzer) {
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
