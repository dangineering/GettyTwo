package com.example.dangineering.gettytwo.network.respmodel;

public class Images {

    private String asset_family;

    private String id;

    private String title;

    private String collection_id;

    private String collection_code;

    private String caption;

    private String collection_name;

    private DisplaySizes[] display_sizes;

    private String license_model;



    public String getAsset_family ()
    {
        return asset_family;
    }

    public void setAsset_family (String asset_family)
    {
        this.asset_family = asset_family;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getCollection_id ()
    {
        return collection_id;
    }

    public void setCollection_id (String collection_id)
    {
        this.collection_id = collection_id;
    }

    public String getCollection_code ()
    {
        return collection_code;
    }

    public void setCollection_code (String collection_code)
    {
        this.collection_code = collection_code;
    }

    public String getCaption ()
    {
        return caption;
    }

    public void setCaption (String caption)
    {
        this.caption = caption;
    }

    public String getCollection_name ()
    {
        return collection_name;
    }

    public void setCollection_name (String collection_name)
    {
        this.collection_name = collection_name;
    }


    public String getLicense_model ()
    {
        return license_model;
    }

    public void setLicense_model (String license_model)
    {
        this.license_model = license_model;
    }


    @Override
    public String toString()
    {
        return "ClassPojo [asset_family = "+asset_family+", id = "+id+", title = "+title+", collection_id = "+collection_id+", collection_code = "+collection_code+", caption = "+caption+", collection_name = "+collection_name+", max_dimensions = "+", license_model = "+license_model+", display_sizes = "+"]";
    }

    public DisplaySizes[] getDisplay_sizes() {
        return display_sizes;
    }

    public void setDisplay_sizes(DisplaySizes[] display_sizes) {
        this.display_sizes = display_sizes;
    }
}
