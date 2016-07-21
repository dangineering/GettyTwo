package com.example.dangineering.gettytwo.domain;

import com.example.dangineering.gettytwo.data.ImageModel;
import com.example.dangineering.gettytwo.data.ImageRepository;
import com.example.dangineering.gettytwo.executor.InteractorExecutor;
import com.example.dangineering.gettytwo.executor.MainThreadExecutor;

import java.util.List;

public class GetImages extends AbstractInteractor {
    Callback callback;
    public interface Callback{
        void onResult(List<ImageModel> images);
        void onError();

    }

    String query;

    ImageRepository imageRepository;

    public GetImages(InteractorExecutor interactorExecutor, MainThreadExecutor mainThreadExecutor, ImageRepository imageRepository) {
        super(interactorExecutor, mainThreadExecutor);
        this.imageRepository = imageRepository;
    }

    public void execute(String query, Callback callback) {
        this.query = query;
        this.callback = callback;

        getInteractorExecutor().run(this);
    }

    @Override
    public void run() {

        try {
            final List<ImageModel> i = imageRepository.getImages(query);
            getMainThreadExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    callback.onResult(i);
                }
            });
        } catch (Exception e) {
            getMainThreadExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    callback.onError();
                }
            });
        }


    }
}
