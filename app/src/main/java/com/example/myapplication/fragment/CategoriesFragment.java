package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.ArticleAdapter;
import com.example.myapplication.Adapter.CategoryAdapter;
import com.example.myapplication.Models.Article;
import com.example.myapplication.Models.Category;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class CategoriesFragment extends Fragment {

    private RecyclerView row;
    List<Category> list;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_categories,container,false);

        RecyclerView myrw = (RecyclerView) view.findViewById(R.id.row_categories);
        CategoryAdapter articleAdapter = new CategoryAdapter(getContext(),list);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        myrw.setLayoutManager(gridLayoutManager);
        myrw.setAdapter(articleAdapter);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        list = new ArrayList<>();

        list.add(new Category(1,"Heath",R.drawable.linhlinh));
        list.add(new Category(2,"Heath1",R.drawable.linhlinh));
        list.add(new Category(3,"Heath2",R.drawable.linhlinh));
        list.add(new Category(4,"Heath3",R.drawable.linhlinh));

    }
}

