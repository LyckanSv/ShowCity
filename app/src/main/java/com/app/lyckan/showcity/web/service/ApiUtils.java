package com.app.lyckan.showcity.web.service;

public class ApiUtils {

    public static final String BASE_URL = "https://raw.githubusercontent.com/";

    public static SOService getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(SOService.class);
    }
}