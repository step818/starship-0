package com.games.pieces;

import com.games.game.Output;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private int health = 100;
    private ArrayList<String> inventory;
    public String name;
    public String itemToGrab;

    public Player() {
        setName();
        setInventory();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public ArrayList<String> getInventory() {
        return inventory;
    }

    public void setInventory() {
        this.inventory = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public void setName() {
        Output.askName();
        Scanner input = new Scanner(System.in);
        this.name = input.nextLine();
    }

    public String getItemToGrab() {
        return itemToGrab;
    }

    public void setItemToGrab(String itemToGrab) {
        this.itemToGrab = itemToGrab;
    }
}
