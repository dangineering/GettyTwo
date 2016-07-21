package com.example.dangineering.gettytwo.network;

import com.example.dangineering.gettytwo.network.respmodel.Resp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GettyService {

    @GET("search/images")
    Call<Resp> search(@Query("phrase") String q);
}
