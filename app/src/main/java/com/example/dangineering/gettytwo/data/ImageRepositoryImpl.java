package com.example.dangineering.gettytwo.data;

import android.content.Context;

import com.example.dangineering.gettytwo.network.GettyAPIRepo;
import com.example.dangineering.gettytwo.storage.InternalCache;

import java.io.IOException;
import java.util.List;

public class ImageRepositoryImpl implements ImageRepository {


    GettyAPIRepo gettyAPIRepo;
    InternalCache cache;

    public ImageRepositoryImpl(Context context) {

        gettyAPIRepo = new GettyAPIRepo();
        cache = new InternalCache(context);
    }

    @Override
    public List<ImageModel> getImages(String query) throws IOException {

        List<ImageModel> api = gettyAPIRepo.getImages(query);
        cache.write(api);
        return api;

    }

    @Override
    public List<ImageModel> getLastCachedImages() throws IOException {
        return cache.getLastCachedImages();
    }
}
