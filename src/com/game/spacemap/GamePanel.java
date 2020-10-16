package com.game.spacemap;

import com.games.game.Game;
import com.games.pieces.Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Graphics;

public class GamePanel extends javax.swing.JPanel implements ActionListener {

    Rocket player;
    ArrayList<Wall> walls = new ArrayList<>();
    Timer gameTimer;

    public GamePanel() {
        player = new Rocket(400, 300, this);

        makeWalls();

        gameTimer = new Timer();
        gameTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                player.set();
                repaint();
            }
        }, 0, 17);
    }

    public void makeWalls() {
        for(int i = 50; i < 650; i += 50) {
            walls.add(new Wall(i, 600, 50, 50));
        }
        walls.add(new Wall(50, 550, 50, 50));
        walls.add(new Wall(50, 500, 50, 50));
    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D gtd = (Graphics2D) g;

        player.draw(gtd);
        for(Wall wall : walls) wall.draw(gtd);
    }




    void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'a') player.keyLeft = true;
        if(e.getKeyChar() == 'w') player.keyUp = true;
        if(e.getKeyChar() == 's') player.keyDown = true;
        if(e.getKeyChar() == 'd') player.keyRight = true;
    }

    void keyReleased(KeyEvent e) {
        if(e.getKeyChar() == 'a') player.keyLeft = false;
        if(e.getKeyChar() == 'w') player.keyUp = false;
        if(e.getKeyChar() == 's') player.keyDown = false;
        if(e.getKeyChar() == 'd') player.keyRight = false;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
