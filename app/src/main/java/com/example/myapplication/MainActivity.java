package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.myapplication.Adapter.ArticleAdapter;
import com.example.myapplication.fragment.CategoriesFragment;
import com.example.myapplication.fragment.FavoriteFragment;
import com.example.myapplication.fragment.HomeFragment;
import com.google.android.material.navigation.NavigationView;

import java.io.File;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private static  final int FRAGMENT_HOME = 0;
    private static  final int FRAGMENT_FAVORITE = 1;
    private static  final int FRAGMENT_CATEGORIES = 2;
    private static  boolean isFirstTime=true;
    private static  boolean isOnPageCategory = false;
    private static boolean isOnPageHome = false;
    private static boolean isOnPageFavorite = false;

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

        if (isFirstTime)
        {
            replaceFragment(new HomeFragment());
            isFirstTime = false;
            isOnPageHome = true;
        }
        else
        {
           if (isOnPageCategory)
           {
               replaceFragment(new CategoriesFragment());
               _toolbar.setTitle("Categories");
               _currentFragment=FRAGMENT_CATEGORIES;
               isOnPageCategory = false;
           }else
               if (isOnPageHome)
               {
                   replaceFragment(new HomeFragment());
                   _toolbar.setTitle("Top Stories");
                   _currentFragment=FRAGMENT_HOME;
                   isOnPageHome = false;
               }
               else if(isOnPageFavorite)
               {
                   replaceFragment(new FavoriteFragment());
                   _toolbar.setTitle("Favorite");
                   _currentFragment=FRAGMENT_FAVORITE;
                   isOnPageFavorite = false;
               }
        }

        //navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);

    }
    public void setOnPageCategory(boolean isOnPageCategory)
    {
        this.isOnPageCategory= isOnPageCategory;
    }
    public void setOnPageHome(boolean isOnPageHome)
    {
        this.isOnPageHome= isOnPageHome;
    }

    public void setOnPageFavorite(boolean isOnPageFavorite)
    {
        this.isOnPageFavorite= isOnPageFavorite;
    }
   /* private List<Article> getListArticles() {
        List<Article> list = new ArrayList<>();

        list.add(new Article(R.mipmap.ic_launcher,"Nhiều người dùng Instagram đang bỏ lỡ một tính năng cực kỳ thú vị này!","thai bang 1","02/01/2000"));
        list.add(new Article(R.mipmap.ic_launcher,"Hố nợ nần sâu thẳm chẳng khác gì Squid Game tại Hàn Quốc","thai bang 2","02/04/2000"));
        list.add(new Article(R.mipmap.ic_launcher,"Kinh hãi việc bố giết hại cả làng để trả thù cho con trai","thai bang 3","02/05/2000"));
        list.add(new Article(R.mipmap.ic_launcher,"Quán quân Olympia giàu có bậc nhất","thai bang 4","02/06/2000"));
        list.add(new Article(R.mipmap.ic_launcher,"tGiai thoại về những chiếc quan tài và những ngôi mộ dưới lòng Hồ Tây","thai bang 5","02/07/2000"));

        return  list;
    }*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu_home,menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        if (id == R.id.action_share)
        {
            ApplicationInfo api= getApplicationContext().getApplicationInfo();
            String apk = api.sourceDir;
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("application/vnd.android.package-archive");
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(apk)));
            startActivity(Intent.createChooser(intent,"Share"));
        }
        return true;
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
                isOnPageHome=true;
            }
        }else if (id == R.id.nav_favorite)
        {

            if (_currentFragment != FRAGMENT_FAVORITE)
            {
                replaceFragment(new FavoriteFragment());
                _toolbar.setTitle("Favorite");

                _currentFragment=FRAGMENT_FAVORITE;
                isOnPageFavorite = true;
            }
        }else if (id == R.id.nav_categories)
        {
            if (_currentFragment != FRAGMENT_CATEGORIES)
            {
                replaceFragment(new CategoriesFragment());
                _toolbar.setTitle("Categories");
                _currentFragment=FRAGMENT_CATEGORIES;
                isOnPageCategory = true;
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