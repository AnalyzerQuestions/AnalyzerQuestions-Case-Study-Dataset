package br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI.service;

import java.util.List;

import br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI.Response;
import br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI.StackExchangeSite;
import br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI.entities.types.Tag;

/**
 * 
 * @author franck
 *
 */
public class TagService extends Service{
	
	public TagService() {
		getAccess();
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public List<Tag> getTagsByName(String name){
		siteService = api.getSiteService(StackExchangeSite.STACK_OVERFLOW, "inname", name);
		Response<Tag> response = siteService.getTags();
		
		return response.getItems();
	}
	
	public static void main(String[] args) {
		TagService tagService = new TagService();
		System.out.println(tagService.getTagsByName("java"));
	}

}
