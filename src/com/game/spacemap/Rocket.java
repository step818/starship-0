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
        height = 12;
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

        if(keyUp && keyDown || !keyUp && !keyDown) yspeed *= 0.8;
        else if(keyUp && !keyDown) yspeed --;
        else if(keyDown && !keyUp) yspeed ++;

        if(yspeed > 0 && yspeed < 0.75) yspeed = 0;
        if(yspeed < 0 && yspeed > -0.75) yspeed = 0;

        if(yspeed > 7) yspeed = 7;
        if(yspeed < -7) yspeed = -7;

        // Horizontal Collisions
        hitBox.x += xspeed;
        for(Wall wall: panel.walls) {
            if(hitBox.intersects(wall.hitBox)){
                hitBox.x -= xspeed;
                while(!wall.hitBox.intersects(hitBox)) hitBox.x += Math.signum(xspeed);
                hitBox.x -= Math.signum(xspeed);
                panel.cameraX += x - hitBox.x;
                xspeed = 0;
                hitBox.x = x;
            }
        }
        // Vertical Collisions
        hitBox.y += yspeed;
        for(Wall wall: panel.walls) {
            if(hitBox.intersects(wall.hitBox)){
                hitBox.y -= yspeed;
                while(!wall.hitBox.intersects(hitBox)) hitBox.y += Math.signum(yspeed);
                hitBox.y -= Math.signum(yspeed);
                yspeed = 0;
                y = hitBox.y;
            }
        }
        // The camera stays fixed on the rocket, while the background moves
        panel.cameraX -= xspeed;
        y += yspeed;

        hitBox.x = x;
        hitBox.y = y;

        // Die if you fly off the screen
        if(y > 640 || y < 0) panel.reset();
    }

    public void draw(Graphics2D gTwoD) {
        gTwoD.setColor(Color.red);
        gTwoD.fillRect(x, y, width, height);

    }
}
