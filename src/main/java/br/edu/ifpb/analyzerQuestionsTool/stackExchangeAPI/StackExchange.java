package br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI;

import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;
import br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI.entities.types.Filter;

public interface StackExchange {


    @POST("/filters/create")
    Response<Filter> createFilter(@Query("unsafe") boolean unsafe);


    @GET("/filters/{filters}")
    Response<Filter> getFilters(@Path("filters") String filters);


    @GET("/errors")
    Response<Error> getErrors();

}
