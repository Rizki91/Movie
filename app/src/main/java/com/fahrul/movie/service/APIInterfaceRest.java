package com.fahrul.movie.service;

import com.fahrul.movie.model.MovieModel;
import com.fahrul.movie.model.SearchList;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterfaceRest {

//    @GET("/")
//    Call<SearchResponse> searchByTitle(@Query("s") String title);

    @GET(".")
    Call<SearchList> getSearch(@Query("s") String q, @Query("apikey") String apiid);

}
