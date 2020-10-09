package com.games.pieces;

import com.games.game.Output;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Player{
    //private int health = 100;
    //private ArrayList<String> inventory;
    //public String name;
    public String itemToGrab;
    public Color playerColor;
    public int playerPositionX, playerPositionY;
    public char playerChar;
    private static ArrayList<String> inventory;
    private static int health = 100;
    public static String name;

    public Player(char playerChar, String playerColor, int startPositionX, int startPositionY) {
        //setName();
        setInventory();
        playerPositionX = startPositionX;
        playerPositionY = startPositionY;
        this.playerChar = playerChar;
        this.playerColor = stringToColor(playerColor);
    }

    public char getPlayerChar() {return this.playerChar;}
    public Color getPlayerColor() {return this.playerColor;}
    public int getX() {return playerPositionX;}
    public int getY() {return playerPositionY;}

    private static Color stringToColor(String colorString) {
        Color color;
        try {
            Field field = Color.class.getField(colorString);
            color = (Color)field.get(null);
        } catch (Exception e) {
            color = null; // Not defined
        }
        return color;
    }

    public void move(int dx, int dy)
    {
        playerPositionX += dx;
        playerPositionY += dy;
    }

    /*
    public class Player extends Rectangle{
    private static int health = 100;
    private static ArrayList<String> inventory;
    public static String name;
    public String itemToGrab;

    public Player() {
        setName();
    }

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
