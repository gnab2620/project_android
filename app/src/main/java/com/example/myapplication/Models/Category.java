package com.example.myapplication.Models;

import java.io.Serializable;

public class Category implements Serializable {
    public int CategoryId;
    public String name;
    public int imageUrl;

    public Category(int categoryId, String name, int imageUrl) {
        CategoryId = categoryId;
        this.name = name;
        this.imageUrl = imageUrl;
    }


    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }
}
