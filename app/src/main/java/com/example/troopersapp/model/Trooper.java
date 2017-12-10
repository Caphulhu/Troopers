package com.example.troopersapp.model;

import java.io.Serializable;

/**
 * Created by lslopes on 18/11/2017.
 */

public class Trooper implements Serializable {

    private int id;
    private String name;
    private String description;
    private String imageUrl;
    private Affiliation affiliation;

    public Trooper(int id, String name, String imageUrl, String description, Affiliation affiliation) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
        this.affiliation = affiliation;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Affiliation getAffiliation() {
        return affiliation;
    }
}
