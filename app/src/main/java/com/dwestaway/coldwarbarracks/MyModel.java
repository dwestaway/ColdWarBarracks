package com.dwestaway.coldwarbarracks;

public class MyModel {

    String title;
    String description;
    int image;
    int stats;

    public MyModel(String title, String description, int image, int stats) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.stats = stats;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getStats() {
        return stats;
    }

    public void setStats(int stats) {
        this.stats = stats;
    }
}
