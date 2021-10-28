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
import com.example.myapplication.Models.Article;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView row;
    List<Article> list;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home,container,false);

        RecyclerView myrw = (RecyclerView) view.findViewById(R.id.row);
        ArticleAdapter articleAdapter = new ArticleAdapter(getContext(),list);
        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(getActivity());
        myrw.setLayoutManager(gridLayoutManager);
        myrw.setAdapter(articleAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = new ArrayList<>();
        list.add(new Article(R.drawable.img_1,"thai bang 1","thai bang","02/01/2000"));
        list.add(new Article(R.drawable.img_1,"thai bang 2","thai bang","02/04/2000"));
        list.add(new Article(R.drawable.img_1,"thai bang 3","thai bang","02/05/2000"));
        list.add(new Article(R.drawable.img_1,"thai bang 4","thai bang","02/06/2000"));
        list.add(new Article(R.drawable.img_1,"thai bang 5","thai bang","02/07/2000"));
        list.add(new Article(R.drawable.img_1,"thai bang 5","thai bang","02/07/2000"));
    }
}
