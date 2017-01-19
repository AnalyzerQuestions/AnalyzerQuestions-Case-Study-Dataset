package br.edu.ifpb.analyzerQuestionsTool.stackExchangeAPI;

import retrofit.ErrorHandler;
import retrofit.RetrofitError;

public class StackExchangeErrorHandler implements ErrorHandler {

    public Throwable handleError(RetrofitError error) {
        return error;
    }

}
