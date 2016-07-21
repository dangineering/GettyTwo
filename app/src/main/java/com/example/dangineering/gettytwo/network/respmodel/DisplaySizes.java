package com.example.dangineering.gettytwo.network.respmodel;

public class DisplaySizes
{
    private String is_watermarked;

    private String name;

    private String uri;

    public String getIs_watermarked ()
    {
        return is_watermarked;
    }

    public void setIs_watermarked (String is_watermarked)
    {
        this.is_watermarked = is_watermarked;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getUri ()
    {
        return uri;
    }

    public void setUri (String uri)
    {
        this.uri = uri;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [is_watermarked = "+is_watermarked+", name = "+name+", uri = "+uri+"]";
    }
}