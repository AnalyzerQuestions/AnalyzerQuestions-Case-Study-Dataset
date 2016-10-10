package br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI;

import retrofit.http.GET;
import br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI.entities.types.Question;
import br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI.entities.types.Tag;
import br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI.entities.types.User;
import br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI.service.TagService;

public interface StackExchangeSite {

    public static final String STACK_OVERFLOW = "pt.stackoverflow";

    @GET("/users")
    Response<User> getUsers();

    @GET("/me")
    Response<User> getUser();
    
    @GET("/questions")
    Response<Question> getQuestions();
    
    @GET("/search")
    Response<Question> search();
    
    @GET("/tags")
    Response<Tag> getTags();

}	
