package br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI.service;

import java.util.List;

import br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI.Response;
import br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI.StackExchangeSite;
import br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI.entities.types.Question;

public class QuestionService extends Service{
	
	public QuestionService() {
		getAccess();
	}
	
	public List<Question> getQuestionsByTag(String tag){
		siteService = api.getSiteService(StackExchangeSite.STACK_OVERFLOW, tag);
		Response<Question> response = siteService.getQuestions();		
		return response.getItems();
	}
	
	public static void main(String[] args) {
		QuestionService qs =  new QuestionService();
		System.out.println(qs.getQuestionsByTag("java"));
	}


}
