package com.games.pieces;

import com.games.game.Output;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Player {
    private int health = 100;
    private ArrayList<String> inventory = new ArrayList<>();
    public String name;
    public String itemToGrab;



    public Player() {
        setName();
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

    public void setInventory(String item) {
        this.inventory.add(item);
    }

    public String getName() {
        return name;
    }

    public void setName() {
        Output.askName();
        Scanner input = new Scanner(System.in);
        this.name = input.nextLine();
    }

    public boolean playerHasWeapon(){
        for(String item : getInventory()){
            if(item.equals("weapon")){
                return true;
            }
        }
        return false;
    }
    public boolean playerHasShield(){
        for(String item : getInventory()){
            if(item.equals("shield")){
                return true;
            }
        }
        return false;
    }

    public String getItemToGrab() {
        return itemToGrab;
    }

    public void setItemToGrab(String itemToGrab) {
        this.itemToGrab = itemToGrab;
    }
}