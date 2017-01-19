package br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI.service;

import br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI.StackExchangeApi;
import br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI.StackExchangeSite;

/**
 * 
 * @author franck
 *
 */
public abstract class Service {
	
	protected static final String ACCESS_TOKEN = "KJi1v7aNWJ8aziMts2QEmQ((";
	
	protected static final String ACCESS_KEY = "gkTDYoP(Ar3ZGk64jkudSg))";
	
	protected StackExchangeApi api;
	
	protected StackExchangeSite siteService;
	
	
	protected void getAccess(){
		api = new StackExchangeApi(ACCESS_TOKEN);
		api.authorize(ACCESS_KEY);

	}

}
