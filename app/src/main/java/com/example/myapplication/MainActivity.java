package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.myapplication.Adapter.ArticleAdapter;
import com.example.myapplication.Models.Article;
import com.example.myapplication.fragment.CategoriesFragment;
import com.example.myapplication.fragment.FavoriteFragment;
import com.example.myapplication.fragment.HomeFragment;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private static  final int FRAGMENT_HOME = 0;
    private static  final int FRAGMENT_FAVORITE = 1;
    private static  final int FRAGMENT_CATEGORIES = 2;


    private  int _currentFragment = FRAGMENT_HOME;
    private DrawerLayout _drawerLayout;
    private Toolbar _toolbar;
    private RecyclerView row;
    private ArticleAdapter articleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         _toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(_toolbar);



        _drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this,_drawerLayout,_toolbar,
                R.string.nav_drawer_open,R.string.nav_drawer_close);

        _drawerLayout.addDrawerListener(toogle);
        toogle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        replaceFragment(new HomeFragment());
        //navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);

    }

    private List<Article> getListArticles() {
        List<Article> list = new ArrayList<>();

        list.add(new Article(R.mipmap.ic_launcher,"thai bang 1","thai bang","02/01/2000"));
        list.add(new Article(R.mipmap.ic_launcher,"thai bang 2","thai bang","02/04/2000"));
        list.add(new Article(R.mipmap.ic_launcher,"thai bang 3","thai bang","02/05/2000"));
        list.add(new Article(R.mipmap.ic_launcher,"thai bang 4","thai bang","02/06/2000"));
        list.add(new Article(R.mipmap.ic_launcher,"thai bang 5","thai bang","02/07/2000"));

        return  list;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_home)
        {

            if (_currentFragment != FRAGMENT_HOME)
            {
                replaceFragment(new HomeFragment());
                _toolbar.setTitle("Top Stories");
                _currentFragment=FRAGMENT_HOME;
            }
        }else if (id == R.id.nav_favorite)
        {

            if (_currentFragment != FRAGMENT_FAVORITE)
            {
                replaceFragment(new FavoriteFragment());
                _toolbar.setTitle("Favorite");
                _currentFragment=FRAGMENT_FAVORITE;
            }
        }else if (id == R.id.nav_categories)
        {
            if (_currentFragment != FRAGMENT_CATEGORIES)
            {
                replaceFragment(new CategoriesFragment());
                _toolbar.setTitle("Categories");
                _currentFragment=FRAGMENT_CATEGORIES;
            }
        }


        _drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (_drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            _drawerLayout.closeDrawer(GravityCompat.START);
        }else
        {
            super.onBackPressed();
        }
    }

    private void replaceFragment(Fragment fragment)
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame,fragment);
        transaction.commit();
    }


}