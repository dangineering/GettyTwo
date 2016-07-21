package com.example.dangineering.gettytwo.presentation.view;

import android.content.Context;

import com.example.dangineering.gettytwo.presentation.viewmodel.ImageViewModel;

import java.util.List;

public interface ModelListView {

    void add(List<ImageViewModel> imageViewModelList);
    void showError();
    Context getContext();

}
