package com.game.spacemap;

import javax.swing.*;
import java.awt.Toolkit;
import java.awt.Dimension;

public class SpaceMap {

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();

        frame.setSize(700, 700);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((int)(screenSize.getWidth()/2 - frame.getSize().getWidth()/2), (int)(screenSize.getHeight()/2 - frame.getSize().getHeight()/2));

        frame.setResizable(false);
        frame.setTitle("Starship");
        frame.setVisible(true);

        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
