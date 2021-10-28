package com.example.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Models.Article;
import com.example.myapplication.R;
import com.example.myapplication.activity.DetailActivity;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticlesViewHolder> {

    private List<Article> list;
    private Context context;
    public ArticleAdapter(Context context, List<Article> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ArticlesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item,parent,false);
        ArticlesViewHolder articleAdapter = new ArticlesViewHolder(view);

        return articleAdapter;
    }

    @Override
    public void onBindViewHolder(@NonNull ArticlesViewHolder holder, int position) {
        final Article article = list.get(position);
        if (article == null)
            return;
        holder.imgView.setImageResource(article.ArticlesID);
        holder.txtTitle.setText(article.getAuthor());
        holder.txtAuthor.setText(article.author);

        holder.item_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGoToDetail(article);
            }
        });
    }
    private void onClickGoToDetail(Article article)
    {
        Intent intent = new Intent(context, DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_articles",article);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        if (list!=null)
            return list.size();
        return 0;
    }

    public class ArticlesViewHolder extends RecyclerView.ViewHolder
    {

        private ImageView imgView;
        private TextView txtTitle;
        private TextView txtAuthor;
        private LinearLayout item_layout;

        public ArticlesViewHolder(@NonNull View itemView) {
            super(itemView);
            item_layout = (LinearLayout) itemView.findViewById(R.id.layout_item);
            imgView = itemView.findViewById(R.id.image);
            txtTitle = itemView.findViewById(R.id.textView2);
            txtAuthor = itemView.findViewById(R.id.textView3);
        }
    }
}
