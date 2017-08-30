package com.app.lyckan.showcity.web.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SOService {

    @GET("/LyckanSv/jsonTest/master/ShowCity/newSubscribed.json")
    Call<SOSubscribedResponse> getAnswers();

    @GET("/LyckanSv/jsonTest/master/ShowCity/newSubscribed.json")
    Call<SOSubscribedResponse> getAnswers(@Query("tagged") String tags);
}
