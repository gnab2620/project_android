package com.example.myapplication.Models;

import java.io.Serializable;

public class Article implements Serializable {
    public int ArticlesID;
    public String title;
    public String author;
    public String post_on;

    public Article(int articlesID, String title, String author, String post_on) {
        ArticlesID = articlesID;
        this.title = title;
        this.author = author;
        this.post_on = post_on;
    }

    public int getArticlesID() {
        return ArticlesID;
    }

    public void setArticlesID(int articlesID) {
        ArticlesID = articlesID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPost_on() {
        return post_on;
    }

    public void setPost_on(String post_on) {
        this.post_on = post_on;
    }
}
