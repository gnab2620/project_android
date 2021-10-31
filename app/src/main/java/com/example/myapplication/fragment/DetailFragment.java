package com.example.myapplication.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.ArticleAdapter;
import com.example.myapplication.Models.Article;
import com.example.myapplication.R;

public class DetailFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_detail,container,false);
        Intent i = getActivity().getIntent();
        Article article = (Article) i.getSerializableExtra("complexObject");


        TextView ragment_detail_title = (TextView) view.findViewById(R.id.fragment_detail_title);
        ragment_detail_title.setText(article.title);
        TextView fragment_author_name = (TextView) view.findViewById(R.id.fragment_author_name);
        fragment_author_name.setText(article.author);
        TextView fragment_post_on = (TextView) view.findViewById(R.id.fragment_post_on);
        fragment_post_on.setText(article.post_on);

        return view;
    }
}
