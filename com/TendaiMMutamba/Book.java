package com.TendaiMMutamba;

import java.io.Serializable;

public class Book implements Serializable {
    public String mTitle;
    private String mAuthor;
    public boolean mInStock;

    public Book(String title, String author) {
        mTitle = title;
        mAuthor = author;
        mInStock = true;


    }
    public String getTitle() {
        return mTitle;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public boolean isInStock() {
        return mInStock;
    }

    public void setInStock(boolean inStock) {
        mInStock = inStock;
    }
}