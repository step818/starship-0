package com.games.pieces;

import asciiPanel.AsciiPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class GameArea extends JFrame implements KeyListener, MouseListener{
    private Rectangle gameScreenRec;
    private Rectangle mapScreenRec;
    private AsciiPanel terminal;
    //private AsciiCamera camera;
    private Queue<InputEvent> inputQueue;
    public static HashMap<String, Point> HUDItems = new HashMap<>();

    public GameArea(Rectangle gameAreaRec, Rectangle mapAreaRec) {
        gameScreenRec = gameAreaRec;
        mapScreenRec = mapAreaRec;
        inputQueue = new LinkedList<>();
        terminal = new AsciiPanel(this.gameScreenRec.width, this.gameScreenRec.height);
        super.add(terminal);
        super.addKeyListener(this);
        super.addMouseListener(this);
        super.setSize(this.gameScreenRec.width*9, this.gameScreenRec.height*16);
        super.setVisible(true);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.repaint();

        loadHUDItems();
        createGameArea();
        createHUD();
    }

    private void createGameArea() {
        //this creates the end borders
        //it ensures the 4 borders have solid borders
        for (int x = 0; x < gameScreenRec.width; x++)
        {
            terminal.write(' ', x, gameScreenRec.height-3, Color.black, Color.white);
            terminal.write(' ', x, 0, Color.black, Color.white);
        }

        for (int y = 0; y < gameScreenRec.height; y++)
        {
            terminal.write(' ', gameScreenRec.width-3, y, Color.black, Color.white);
            terminal.write(' ', 0, y, Color.black, Color.white);
        }

        for(int k = 4; k <= 7; k ++)
        {
            for (int x = 8; x < gameScreenRec.width-10; x++){
                terminal.write(' ', x, gameScreenRec.height - k, Color.yellow, Color.blue);
            }
        }
    }

    private void createHUD() {
        Point point;
        for (String strKey :this.HUDItems.keySet()) {
            point = HUDItems.get(strKey);
            terminal.write(strKey, ((int) point.getX()), ((int) point.getY()), Color.yellow, Color.blue);
            //x += playerHealth.length() - 1;
        }
    }

    private void loadHUDItems() {
        this.HUDItems.put("Player Health", new Point(10, 17));
        this.HUDItems.put("Last Move", new Point(32, 17));
        this.HUDItems.put("Starship Health", new Point(10, 19));
        this.HUDItems.put("Fuel Level", new Point(32, 19));
    }

    public void changeHUDValue(String strKey, String strPrevValue, String strNewValue)
    {
        Point point = HUDItems.get(strKey);
        terminal.write(String.format("%1$" + (strPrevValue.length() + 1) + "s", " "), ((int) point.getX()) + strKey.length() + 1, ((int) point.getY()), Color.white, Color.blue);
        terminal.write(strNewValue, ((int) point.getX()) + strKey.length() + 1, ((int) point.getY()), Color.white, Color.blue);
    }

    public Point GetCameraOrigin(int xfocus, int yfocus)
    {
        int spx = Math.max(0, Math.min(xfocus - gameScreenRec.width / 2, mapScreenRec.width - gameScreenRec.width));
        int spy = Math.max(0, Math.min(yfocus - gameScreenRec.height / 2, mapScreenRec.height - gameScreenRec.height));
        return new Point(spx, spy);
    }

    public void pointCameraAt(Player player1, int xfocus, int yfocus) {

        Point origin = GetCameraOrigin(xfocus, yfocus);
        /*
        for (int y = 0; y < gameScreenRec.height; y++)
        {
            terminal.write(' ', gameScreenRec.width-3, y, Color.black, Color.white);
            terminal.write(' ', 0, y, Color.black, Color.white);
        }

        */

        /*
        for (int x = 0; x < gameScreenRec.width; x++)
        {
            for (int y = 0; y < gameScreenRec.height; y++)
            {
                terminal.write('.', x, y, Color.white, Color.black);
            }
        }
         */

        int spx;
        int spy;

        spx = player1.getX() - origin.x;
        spy = player1.getY() - origin.y;

        terminal.write(' ', player1.getPrevX(), player1.getPrevY(), Color.black, Color.black);
        if ((spx >= 0 && spx < gameScreenRec.width) && (spy >= 0 && spy < gameScreenRec.height)) {
            terminal.write(player1.getPlayerChar(), spx, spy, player1.getPlayerColor(), Color.black);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        inputQueue.add(e);
    }

//    public void drawDynamicLegend(Rectangle gameViewArea, World world, Map<String, Map<String, String>> tileData, Map<String, Map<String, String>> creatureData) {
//        int x = 5;
//        int y = gameViewArea.height;
//        char glyph;
//
//        for (String tileType : world.getTileTypesInArea(gameViewArea)) {
//            glyph = tileData.get(tileType).get("glyph").charAt(0);
//            terminal.write(glyph + "   " + tileType, x, y);
//            y += 1;
//
//            if (y == gameViewArea.height+2) {
//                x += 15;
//                y = gameViewArea.height;
//            }
//        }
//
//        for (String creatureType : world.getCreatureTypesInArea(gameViewArea)) {
//            glyph = creatureData.get(creatureType).get("glyph").charAt(0);
//            terminal.write(glyph + "   " + creatureType, x, y);
//            y += 1;
//
//            if (y == gameViewArea.height+5) {
//                x += 15;
//                y = gameViewArea.height;
//            }
//        }
//    }


    public InputEvent getNextInput() {
        if(inputQueue.isEmpty() == false)
            return inputQueue.poll();
        else
            return null;
    }

    public void refresh() {
        terminal.repaint();
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