package com.game.spacemap;


import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;

public class Rocket {
    GamePanel panel;
    int x;
    int y;
    int width;
    int height;

    double xspeed;
    double yspeed;

    Rectangle hitBox;

    boolean keyLeft;
    boolean keyRight;
    boolean keyUp;
    boolean keyDown;

    public Rocket(int x, int y, GamePanel panel) {
        this.panel = panel;
        this.x = x;
        this.y = y;

        width = 25;
        height = 50;
        hitBox = new Rectangle(x, y, width, height);
    }

    public void set() {
        if(keyLeft && keyRight || !keyLeft && !keyRight) xspeed *= 0.8;
        else if(keyLeft && !keyRight) xspeed --;
        else if(keyRight && !keyLeft) xspeed ++;

        if(xspeed > 0 && xspeed < 0.75) xspeed = 0;
        if(xspeed < 0 && xspeed > -0.75) xspeed = 0;

        if(xspeed > 7) xspeed = 7;
        if(xspeed < -7) xspeed = -7;

        x += xspeed;
        y += yspeed;

        hitBox.x = x;
        hitBox.y = y;
    }

    public void draw(Graphics2D gTwoD) {
        gTwoD.setColor(Color.black);
        gTwoD.fillRect(x, y, width, height);
    }
}
