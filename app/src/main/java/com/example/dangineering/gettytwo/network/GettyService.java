package com.example.dangineering.gettytwo.network;

import com.example.dangineering.gettytwo.network.respmodel.Response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GettyService {

    @GET("search/images")
    Call<Response> search(@Query("phrase") String q);
}
