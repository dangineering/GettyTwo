package com.example.dangineering.gettytwo.presentation.presenter;

import com.example.dangineering.gettytwo.data.ImageModel;
import com.example.dangineering.gettytwo.data.ImageRepository;
import com.example.dangineering.gettytwo.data.ImageRepositoryImpl;
import com.example.dangineering.gettytwo.domain.GetImages;
import com.example.dangineering.gettytwo.executor.InteractorExecutor;
import com.example.dangineering.gettytwo.executor.InteractorExecutorImpl;
import com.example.dangineering.gettytwo.executor.MainThreadExecutor;
import com.example.dangineering.gettytwo.executor.MainThreadExecutorImpl;
import com.example.dangineering.gettytwo.presentation.view.ModelListView;
import com.example.dangineering.gettytwo.presentation.viewmodel.ImageViewModel;

import java.util.ArrayList;
import java.util.List;

public class ModelListPresenter {

    // interactor;
    GetImages getImages;

    ModelListView modelListView;

    public ModelListPresenter(ModelListView view) {

        this.modelListView = view;
        init();
    }

    private void init() {
        // TODO: ADD DI

        InteractorExecutor interactorExecutor = new InteractorExecutorImpl();

        MainThreadExecutor mainThreadExecutor = new MainThreadExecutorImpl();

        ImageRepository imageRepository = new ImageRepositoryImpl(modelListView.getContext());

        getImages = new GetImages(interactorExecutor, mainThreadExecutor, imageRepository);

        fetchCache();

    }

    private void fetchCache() {
        getImages.execute(new GetImages.Callback() {
            @Override
            public void onResult(List<ImageModel> images) {
                modelListView.add(convert(images));
            }

            @Override
            public void onError() {
                modelListView.showError();
            }
        });
    }

    public void setView(ModelListView modelListView) {
        this.modelListView = modelListView;
    }


    public void search(String query) {
        getImages.execute(query, new GetImages.Callback() {
            @Override
            public void onResult(List<ImageModel> images) {
                modelListView.add(convert(images));
            }

            @Override
            public void onError() {
                modelListView.showError();
            }
        });
    }

    private List<ImageViewModel> convert(List<ImageModel> images) {

        List<ImageViewModel> res = new ArrayList<>();

        if (images != null) {
            for (ImageModel i : images) {
                res.add(new ImageViewModel(i.getUrl(), i.getTitle()));
            }
        }
        return res;
    }



}
