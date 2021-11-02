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

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Models.Category;
import com.example.myapplication.R;
import com.example.myapplication.activity.CategoryActivity;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {


    private Context context;
    private List<Category> listCategory;

    public CategoryAdapter(Context context, List<Category> listCategory) {
        this.context = context;
        this.listCategory = listCategory;
    }

    public CategoryAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Category> listCategory)
    {
        this.listCategory = listCategory;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category,parent,false);

        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        final Category category = listCategory.get(position);
        if (category==null)
        {
            return;

        }
        holder.imgCategory.setImageResource(category.imageUrl);
        holder.tvCategory.setText(category.name);
       holder.item_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGoToDetail(category);
            }
        });

    }
    private void onClickGoToDetail(Category category)
    {
        Intent intent = new Intent(context, CategoryActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_articles",category);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }
    @Override
    public int getItemCount() {
        if(listCategory !=null)
            return listCategory.size();
        return 0;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder
    {

        private ImageView imgCategory;
        private TextView tvCategory;
        private LinearLayout item_category;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            item_category = itemView.findViewById(R.id.item_category);
            imgCategory = itemView.findViewById(R.id.img_category);
            tvCategory = itemView.findViewById(R.id.name_category);

        }
    }
}
