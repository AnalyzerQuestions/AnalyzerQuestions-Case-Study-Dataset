package br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI;

import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;
import br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI.entities.types.Filter;
import br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI.entities.types.Site;

public interface StackExchange {


    @POST("/filters/create")
    Response<Filter> createFilter(@Query("unsafe") boolean unsafe);


    @GET("/filters/{filters}")
    Response<Filter> getFilters(@Path("filters") String filters);


    @GET("/errors")
    Response<Error> getErrors();


    @GET("/errors")
    Response<Error> getErrors(@Query("page") int page, @Query("pagesize") int pagesize);


    @GET("/errors/{id}")
    void getError(@Path("id") int id);



    @GET("/sites")
    Response<Site> getSites();

    @GET("/sites")
    Response<Site> getSites(@Query("page") Integer page, @Query("pagesize") Integer pagesize);

}
