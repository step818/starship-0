package com.games.game;


import com.games.pieces.GameArea;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class LandingPage extends JFrame implements ActionListener {

    private Game game;
     //A JButton that checks if the user wants to play.
    private JButton playButton;
    //A JButton that checks if the user wants to quit.
    private JButton quitButton;
    //A JLabel that contains the menu background image.
    private JLabel background;

    //Creates and displays the menu

    public LandingPage() {
        super("Starship Landing Page");
        createMenuFrame();
    }


     //Creates the Menu JFrame.

    private void createMenuFrame() {
        setPreferredSize(new Dimension(700, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Background image
        background = new JLabel(new ImageIcon("src/images/Starship.png"));
        background.setSize(new Dimension(700, 500));
        setContentPane(background);
        setLayout(new GridBagLayout());

        // GridBagConstraints
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(15, 40, 15, 40);
        c.gridwidth = GridBagConstraints.REMAINDER;

        //Buttons
        playButton = new JButton(new ImageIcon("src/images/StarshipPLAY.png"));
        playButton.setPreferredSize(new Dimension(300, 80));
        playButton.setContentAreaFilled(false);
        playButton.setBorderPainted(false);

        quitButton = new JButton("Quit Game");


        playButton.addActionListener(this);
        playButton.setActionCommand("play");
        quitButton.addActionListener(this);
        quitButton.setActionCommand("quit");

        add(playButton, c);
        add(quitButton, c);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    //This method is called every time an action is
     //performed. Used to check for button presses.

    @Override
    //close landing page
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "play") {
            //System.out.println("lets play");
            setVisible(false);
            dispose();
            try {
                game.begin(80,24);
                game.gameArea.revalidate();
                game.gameArea.repaint();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            } catch (LineUnavailableException lineUnavailableException) {
                lineUnavailableException.printStackTrace();
            }
        } else {
            //System.out.println("it's not working");
            System.exit(0);

        }
    }
}