package com.example.dangineering.gettytwo.storage;

import android.content.Context;

import com.example.dangineering.gettytwo.data.ImageModel;
import com.example.dangineering.gettytwo.data.ImageRepository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class InternalCache {

    private Context context;

    public InternalCache(Context context) {
        this.context = context;
    }

    public void write(List<ImageModel> userModels) {
        File file;

        ObjectOutputStream objectOutputStream;
        try {
            file = new File(context.getCacheDir(), "MyCache");

            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(userModels);
            objectOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<ImageModel> getLastCachedImages() throws IOException {

        File file;

        List<ImageModel> userModels = new ArrayList<>();

        ObjectInputStream objectInputStream;
        try {
            file = new File(context.getCacheDir(), "MyCache");
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
            try {
                userModels.addAll((List<ImageModel>) objectInputStream.readObject());

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return userModels;

    }

}
