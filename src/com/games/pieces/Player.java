package com.games.pieces;

import com.games.game.Output;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.reflect.Field;

public class Player {
    private ArrayList<String> inventory = new ArrayList<>();
    public String name;
    public String itemToGrab;
    public Color playerColor;
    public GameArea gameArea;
    public int playerPositionX, playerPositionY;
    public char playerChar;
    private int playerPrevPositionX, playerPrevPositionY;
    private static int health;


    public Player(char playerChar, Color playerColor, int startPositionX, int startPositionY, GameArea gameArea) {
        setName();
        setPlayerChar(playerChar);
        setPlayerColor(playerColor);
        setPlayerPositionX(startPositionX);
        setPlayerPositionY(startPositionY);
        this.gameArea = gameArea;
        setHealth(100);
    }
    public Color getPlayerColor() {
        return playerColor;
    }

    public void setPlayerColor(Color playerColor) {
        this.playerColor = playerColor;
    }

    public int getPlayerPositionX() {
        return playerPositionX;
    }

    public void setPlayerPositionX(int playerPositionX) {
        this.playerPositionX = playerPositionX;
    }

    public int getPrevX() {return playerPrevPositionX;}

    public int getPrevY() {return playerPrevPositionY;}

    public int getPlayerPositionY() {
        return playerPositionY;
    }

    public void setPlayerPositionY(int playerPositionY) {
        this.playerPositionY = playerPositionY;
    }

    public char getPlayerChar() {
        return playerChar;
    }

    public int getX() {return playerPositionX;}

    public int getY() {return playerPositionY;}

    public void setPlayerChar(char playerChar) {
        this.playerChar = playerChar;
    }

    public ArrayList<String> getInventory() {
        return inventory;
    }

    public void setInventory(String item) {
        this.inventory.add(item);
    }

    public void clearInventory(){
        inventory.clear();
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

    public void move(int dx, int dy)
    {
        playerPrevPositionX = playerPositionX;
        playerPrevPositionY = playerPositionY;
        playerPositionX += dx;
        playerPositionY += dy;
    }

    public static int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.gameArea.changeHUDValue("Player Health", String.valueOf(this.health), String.valueOf(health));
        this.health = health;
    }
}