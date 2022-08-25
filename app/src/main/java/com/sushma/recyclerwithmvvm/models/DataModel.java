package com.sushma.recyclerwithmvvm.models;

public class DataModel {

    private String name;
    private int image;

    public DataModel() {
    }

    public DataModel(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
