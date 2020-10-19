package com.games.pieces;

import java.awt.*;
import java.util.ArrayList;

public class Planet {

    private String name;
    private ArrayList<String> resources;
    private int x, y;
    private Color color;
    private Character symbol;

    public Planet(String name, ArrayList<String> resources) {
        setName(name);
        setResources(resources);
    }

    public Planet(String name, ArrayList<String> resources, int x, int y, Color color, Character symbol) {
        setName(name);
        setResources(resources);
        setX(x);
        setY(y);
        setColor(color);
        setSymbol(symbol);
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Character getSymbol() {
        return symbol;
    }

    public void setSymbol(Character symbol) {
        this.symbol = symbol;
    }
}
