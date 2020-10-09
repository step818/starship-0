package com.games.pieces;
//import java.awt.*;
import com.games.game.Output;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.util.ArrayList;
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
    private int dx, dy;

    public Player(int x, int y, int width, int height, int dx, int dy ) {
        setBounds(x,y,width,height);
        this.dx = dx;
        this.dy = dy;
    }

      public void tick() {
       this.x += dx;
       this.y += dy;
    }

    public void draw(Graphics g) {
       g.fillRect(this.x, this.y, this.width, this.height);

    }
    public void setDx(int dx) {
        this.dx =dx;

    }
    public void setDy(int dy) {
        this.dy =dy;
    }
     */


    public Player() {
        setName();
        setInventory();

    }
    public void update() {

    }

    public static int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        health = health;
    }

    public static ArrayList<String> getInventory() {
        return inventory;
    }

    public void setInventory() {

        inventory = new ArrayList<String>();
    }


    public static String getName() {

        return name;
    }

    public void setName() {
        Output.askName();
        Scanner input = new Scanner(System.in);
        name = input.nextLine();
    }

    public String getItemToGrab() {
        return itemToGrab;
    }

    public void setItemToGrab(String itemToGrab) {
        this.itemToGrab = itemToGrab;
    }

  /*  public void KeyPressed(KeyEvent e) {
        int Key = e.getKeyCode();

        if (Key == KeyEvent.VK_W) {
            moveY = -2;
        } else if (Key == KeyEvent.VK_S) {
            moveY = 2;
        } else if (Key == KeyEvent.VK_A) {
            moveX = -2;
        } else if (Key == KeyEvent.VK_D) {
            moveX = 2;
        }
    }

    public void KeyReleased(KeyEvent e) {
        int Key = e.getKeyCode();

        if (Key == KeyEvent.VK_W) {
            moveY = 0;
        } else if (Key == KeyEvent.VK_S) {
            moveY = 0;
        } else if (Key == KeyEvent.VK_A) {
            moveX = 0;
        } else if (Key == KeyEvent.VK_D) {
            moveX = 0;
*/
}