package com.example.dangineering.gettytwo.data;

import java.io.IOException;
import java.util.List;

public interface ImageRepository {

    List<ImageModel> getImages(String query) throws IOException;

    List<ImageModel> getLastCachedImages() throws IOException;
}
