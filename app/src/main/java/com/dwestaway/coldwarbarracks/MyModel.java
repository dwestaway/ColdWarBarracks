package com.dwestaway.coldwarbarracks;

public class MyModel {

    String title;
    String description;
    String damage;
    int image;
    int stats;

    public MyModel(String title, String description, String damage, int image, int stats) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.stats = stats;
        this.damage = damage;
    }

    public String getTitle() {
        return title;
    }


    public String getDescription() {
        return description;
    }


    public int getImage() {
        return image;
    }


    public int getStats() {
        return stats;
    }

    public String getDamage() {
        return damage;
    }
}
