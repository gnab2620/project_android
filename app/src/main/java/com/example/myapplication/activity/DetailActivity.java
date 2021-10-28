package com.example.myapplication.activity;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.Models.Article;
import com.example.myapplication.R;

public class DetailActivity extends AppCompatActivity {

    private DrawerLayout _drawerLayout;
    private Toolbar _toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        _toolbar = findViewById(R.id.toolbar);

        _toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        setSupportActionBar(_toolbar);
        _toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
        Bundle bundle = getIntent().getExtras();
        if (bundle==null)
        {
            return;
        }
        Article article = (Article) bundle.get("object_articles");
        //TextView tv = findViewById(R.id.tv_name_detail);
        //tv.setText(article.title);
    }
}