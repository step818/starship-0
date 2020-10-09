package com.games.pieces;

import com.games.game.Output;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Player {
    private static int health = 100;
    private static ArrayList<String> inventory = new ArrayList<>();
    public static String name;
    public String itemToGrab;



    public Player() {
        setName();
    }

    public static int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public static ArrayList<String> getInventory() {
        return inventory;
    }

    public void setInventory(String item) {
        this.inventory.add(item);
    }

    public static String getName() {
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
