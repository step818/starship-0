package com.games.pieces;

import asciiPanel.AsciiPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GameArea extends JFrame implements KeyListener, MouseListener{
    private Rectangle gameScreenRec;
    private Rectangle mapScreenRec;
    private AsciiPanel panel;
    //private AsciiCamera camera;
    private Queue<InputEvent> inputQueue;

    private ArrayList<Asteroid> asteroids = new ArrayList<>();
    private int updateMonsters;
    public GameArea(Rectangle gameAreaRec, Rectangle mapAreaRec) {
        gameScreenRec = gameAreaRec;
        mapScreenRec = mapAreaRec;
        inputQueue = new LinkedList<>();
        panel = new AsciiPanel(this.gameScreenRec.width, this.gameScreenRec.height);
        super.add(panel);
        super.addKeyListener(this);
        super.addMouseListener(this);
        super.setSize(this.gameScreenRec.width*9, this.gameScreenRec.height*16);
        super.setVisible(true);
        super.setResizable(false);
        super.setTitle("Starship");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //instantiate asteroids through method call
        drawAsteroids();
        // instantiate aliens through method call
//        drawAliens();
        super.repaint();
    }

    // distance from x and y to begin writing/printing from
    public Point GetCameraOrigin(int xfocus, int yfocus) {
        int spx = Math.max(0, Math.min(xfocus - gameScreenRec.width / 2, mapScreenRec.width - gameScreenRec.width));
        int spy = Math.max(0, Math.min(yfocus - gameScreenRec.height / 2, mapScreenRec.height - gameScreenRec.height));
        return new Point(spx, spy);
    }

    public void pointCameraAt(Starship player1, int xfocus, int yfocus) {
        // paint the board with '.' to show where the player can move to
        Point origin = GetCameraOrigin(xfocus, yfocus);
        for (int x = 0; x < gameScreenRec.width; x++){
            for (int y = 0; y < gameScreenRec.height; y++){
                panel.write('.', x, y, Color.white, Color.black);
            }
        }

        // write out the asteroids on the panel
        for(Asteroid asteroid: asteroids) {
            panel.write('A', asteroid.getX(), asteroid.getY(), Color.lightGray, Color.black);
        }
        if(updateMonsters >= 100) {
            floatAsteroids();
        }

        for(Asteroid asteroid: asteroids) {
            if(player1.getxPos()==(asteroid.getX()) && player1.getyPos()==(asteroid.getY())) {
                System.out.println("CRASH!");
                player1.takenDamage(1);
                System.out.println(player1.getHealth());
                // then player1.takenDamage(20);
            }
        }
        //the distance from the left(x) and top(y) to begin writing from
        int spx;
        int spy;

        spx = player1.getxPos() - origin.x;
        spy = player1.getyPos() - origin.y;

        if ((spx >= 0 && spx < gameScreenRec.width) && (spy >= 0 && spy < gameScreenRec.height)) {
            panel.write('@', spx, spy, Color.red, Color.black);
        }
    }

    public void drawAsteroids() {
        int x = 79;
        for(int i = 4; i < 24; i = i + 4) {
            asteroids.add(new Asteroid("large", x, i));
            x -= 4;
        }
    }

    public void floatAsteroids() {
            for(Asteroid asteroid: asteroids) {
                asteroid.setX(asteroid.getX()-1);
                if(asteroid.getX() == (0)) {
                    asteroid.setX(79);
                }
            }
            updateMonsters = 0;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        inputQueue.add(e);
    }


    public InputEvent getNextInput() {
        if(!inputQueue.isEmpty())
            return inputQueue.poll();
        else
            return null;
    }

    public void refresh() {
        updateMonsters++;
        panel.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {
        inputQueue.add(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}
}