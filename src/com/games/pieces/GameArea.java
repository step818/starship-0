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
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.repaint();
    }

    // distance from x and y to begin writing/printing from
    public Point GetCameraOrigin(int xfocus, int yfocus)
    {
        int spx = Math.max(0, Math.min(xfocus - gameScreenRec.width / 2, mapScreenRec.width - gameScreenRec.width));
        int spy = Math.max(0, Math.min(yfocus - gameScreenRec.height / 2, mapScreenRec.height - gameScreenRec.height));
        return new Point(spx, spy);
    }

    public void pointCameraAt(Player player1, int xfocus, int yfocus) {
        // paint the board with '.' to show where the player can move to
        Point origin = GetCameraOrigin(xfocus, yfocus);
        for (int x = 0; x < gameScreenRec.width; x++){
            for (int y = 0; y < gameScreenRec.height; y++){
                panel.write('.', x, y, Color.white, Color.black);
            }
        }
        //instantiate asteroids through method call
        drawAsteroids();
        // write out the asteroids on the panel
        for(Asteroid asteroid: asteroids) {
            panel.write('A', asteroid.getX(), asteroid.getY(), Color.lightGray, Color.black);
        }
        // instantiate aliens through method call
//        drawAliens();
        for(Asteroid asteroid: asteroids) {
            if(player1.getPlayerPositionX()==(asteroid.getX()) && player1.getPlayerPositionY()==(asteroid.getY())) {
                System.out.println("CRASH!");
                // TODO: in order to lower rocket health, you need to update the Starship class being passed in instead of the Player
                // then player1.takenDamage(20);
            }
        }
        int spx;
        int spy;

        spx = player1.getPlayerPositionX() - origin.x;
        spy = player1.getPlayerPositionY() - origin.y;

        if ((spx >= 0 && spx < gameScreenRec.width) && (spy >= 0 && spy < gameScreenRec.height)) {
            panel.write(player1.getPlayerChar(), spx, spy, player1.getPlayerColor(), Color.black);
        }
    }

    public void drawAsteroids() {
        for(int i = 4; i < 17; i = i + 4) {
            asteroids.add(new Asteroid("large", i, 6));
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        inputQueue.add(e);
    }


    public InputEvent getNextInput() {
        if(inputQueue.isEmpty() == false)
            return inputQueue.poll();
        else
            return null;
    }

    public void refresh() {
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