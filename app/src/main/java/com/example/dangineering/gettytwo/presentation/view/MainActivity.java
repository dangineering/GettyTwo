package com.example.dangineering.gettytwo.presentation.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dangineering.gettytwo.R;
import com.example.dangineering.gettytwo.presentation.presenter.ModelListPresenter;
import com.example.dangineering.gettytwo.presentation.recycler.ModelAdapter;
import com.example.dangineering.gettytwo.presentation.viewmodel.ImageViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ModelListView {

    // ui items
    RecyclerView recyclerView;
    ModelAdapter modelAdapter;
    EditText editText;
    Button btn;

    // presenter
    ModelListPresenter modelListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        modelListPresenter = new ModelListPresenter(this);
        initUi();
    }


    private void initUi() {
        //recycler
        recyclerView = (RecyclerView) findViewById(R.id.list);
        modelAdapter = new ModelAdapter(new ModelAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ImageViewModel i) {
                launchActivity(i);

            }
        });
        recyclerView.setAdapter(modelAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        editText = (EditText) findViewById(R.id.edit_text);
        btn = (Button) findViewById(R.id.search_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = editText.getText().toString();
                if (!s.isEmpty()) {
                    modelListPresenter.search(s);
                }
            }
        });

    }

    private void launchActivity(ImageViewModel i) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.URL_KEY, i.getUrl());
        intent.putExtra(DetailActivity.TITLE_KEY, i.getTitle());

        startActivity(intent);
    }

    @Override
    public void add(List<ImageViewModel> imageViewModelList) {
        modelAdapter.setData(imageViewModelList);
    }

    @Override
    public void showError() {
        Toast.makeText(this, R.string.error, Toast.LENGTH_LONG).show();
    }

    @Override
    public Context getContext() {
        return this;
    }
}
