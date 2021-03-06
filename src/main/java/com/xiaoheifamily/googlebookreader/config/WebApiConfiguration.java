package com.xiaoheifamily.googlebookreader.config;

import com.xiaoheifamily.googlebookreader.webapi.GoogleBookApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class WebApiConfiguration {

    private static final String GoogleApiBaseUrl = "https://www.googleapis.com/";

    @Bean
    public GoogleBookApi googleBookApi() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GoogleApiBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(GoogleBookApi.class);
    }
}