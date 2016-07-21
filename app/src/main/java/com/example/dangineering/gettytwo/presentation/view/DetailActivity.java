package com.example.dangineering.gettytwo.presentation.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dangineering.gettytwo.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class DetailActivity extends Activity implements DetailView {

    public static final String URL_KEY = "url";
    public static final String TITLE_KEY = "title";

    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageView = (ImageView) findViewById(R.id.detail_img);
        textView = (TextView) findViewById(R.id.detail_txt);


        Picasso.with(this).load(getIntent().getStringExtra(URL_KEY)).into(imageView);
        textView.setText(getIntent().getStringExtra(TITLE_KEY));
    }
}
