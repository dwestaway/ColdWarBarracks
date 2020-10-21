package com.example.coldwarbarracks;

public class MyModel {

    String description;
    int image;
    int stats;

    public MyModel(String description, int image, int stats) {
        this.description = description;
        this.image = image;
        this.stats = stats;
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
