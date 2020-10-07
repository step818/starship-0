package com.games.pieces;

import java.util.ArrayList;

public class Planet {

    private String name;
    private ArrayList<String> resources;

    public Planet(String name, ArrayList<String> resources) {
        setName(name);
        setResources(resources);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getResources() {
        return resources;
    }

    public void setResources(ArrayList<String> resources) {
        this.resources = resources;
    }
}
