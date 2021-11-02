package com.example.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.MainActivity;
import com.example.myapplication.Models.Article;
import com.example.myapplication.Models.Category;
import com.example.myapplication.R;
import com.example.myapplication.fragment.CategoriesFragment;
import com.example.myapplication.fragment.CategoryDetailFragment;
import com.example.myapplication.fragment.DetailFragment;

import java.util.Objects;

public class CategoryActivity extends AppCompatActivity {

    private DrawerLayout _drawerLayout;
    private Toolbar _toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_category);
        _toolbar = findViewById(R.id.toolbar_category);

        _toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        setSupportActionBar(_toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        _toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                //replaceFragment(new CategoriesFragment());
            }
        });

        Bundle bundle = getIntent().getExtras();
        if (bundle==null)
        {
            return;
        }
        Category category = (Category) bundle.get("object_articles");
        _toolbar.setTitle(category.name);
        getIntent().putExtra("complexObject", category);


        replaceFragment(new CategoryDetailFragment());

    }
    private void replaceFragment(Fragment fragment)
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_detail_category,fragment);
        transaction.commit();
    }
}
