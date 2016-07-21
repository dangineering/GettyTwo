package com.example.dangineering.gettytwo.network.respmodel;

public class Resp {

    private Images[] images;

    private String result_count;

    public Images[] getImages ()
    {
        return images;
    }

    public void setImages (Images[] images)
    {
        this.images = images;
    }

    public String getResult_count ()
    {
        return result_count;
    }

    public void setResult_count (String result_count)
    {
        this.result_count = result_count;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [images = "+images+", result_count = "+result_count+"]";
    }
}
