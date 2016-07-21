package com.example.dangineering.gettytwo.data;

import android.content.Context;
import android.media.Image;

import com.example.dangineering.gettytwo.network.GettyAPIRepo;
import com.example.dangineering.gettytwo.storage.InternalCache;

import java.io.IOException;
import java.util.List;

public class ImageRepositoryImpl implements ImageRepository {


    ImageRepository gettyAPIRepo;
    InternalCache cache;

    public ImageRepositoryImpl(Context context) {

        gettyAPIRepo = new GettyAPIRepo();
        cache = new InternalCache(context);
    }

    @Override
    public List<ImageModel> getImages(String query) throws IOException {
        List<ImageModel> res = cache.getImagesLast();

        if (res.isEmpty()) {
            List<ImageModel> api = gettyAPIRepo.getImages(query);
            cache.write(api);
            return api;
        }

        return res;
    }
}
