package com.example.dangineering.gettytwo.network;

import android.media.Image;

import com.example.dangineering.gettytwo.data.ImageModel;
import com.example.dangineering.gettytwo.data.ImageRepository;
import com.example.dangineering.gettytwo.network.respmodel.Images;
import com.example.dangineering.gettytwo.network.respmodel.Resp;
import com.example.dangineering.gettytwo.presentation.view.ModelListView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class GettyAPIRepo implements ImageRepository {
    String apiKey = "nbe4gxpc8jfqr6xvr6j4dh7b";
    String BASE_URL = "https://api.gettyimages.com/v3/";

    GettyService gettyService;
    ModelListView view;

    public GettyAPIRepo() {
        initRetrofit();
    }

    private void initRetrofit() {

        OkHttpClient okhttp = new OkHttpClient().newBuilder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();

                        // Request customization: add request headers
                        Request.Builder requestBuilder = original.newBuilder()
                                .header("Api-Key", apiKey); // <-- this is the important line

                        Request request = requestBuilder.build();
                        return chain.proceed(request);
                    }
                })
                .build();

        //gson
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();


        // create retrofit object with intercepter
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okhttp)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        // create service
        gettyService = retrofit.create(GettyService.class);

    }


    @Override
    public List<ImageModel> getImages(String query) throws IOException {
        Call<Resp> resp = gettyService.search(query);

        try {
            Resp r = resp.execute().body();
            return convert(r);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException();
        }

    }

    private List<ImageModel> convert(Resp r){
        List<ImageModel> ims = new ArrayList<>();
        if (r != null) {
            for (Images i : r.getImages()) {
                ims.add(new ImageModel(i.getDisplay_sizes()[0].getUri(), i.getTitle()));
            }
        }
        return ims;
    }
}
