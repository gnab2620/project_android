package com.example.myapplication.activity;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.Models.Article;
import com.example.myapplication.R;
import com.example.myapplication.fragment.DetailFragment;

import java.util.Objects;

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
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
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

        getIntent().putExtra("complexObject", article);
        replaceFragment(new DetailFragment());


    }
    private void replaceFragment(Fragment fragment)
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame_detail,fragment);
        transaction.commit();
    }
}