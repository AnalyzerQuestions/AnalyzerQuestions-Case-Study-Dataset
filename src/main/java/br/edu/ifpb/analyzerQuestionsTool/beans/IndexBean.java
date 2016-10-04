package br.edu.ifpb.analyzerQuestionsTool.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifpb.analyzerQuestionsTool.analyzers.Analyzer;
import br.edu.ifpb.analyzerQuestionsTool.entities.Question;

@ManagedBean
@ViewScoped
public class IndexBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Analyzer analyzer = new Analyzer();

	private List<String> messages = new ArrayList<String>();

	private Question question = new Question();

	public void submit() {
		System.out.println(question+ " ...................................................");
		analyzer.analyse(question);
		messages = analyzer.getMessages();
		System.out.println(messages);
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}
