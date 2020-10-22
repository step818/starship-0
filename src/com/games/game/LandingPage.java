package com.games.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class LandingPage extends JFrame implements ActionListener {

    /**
     * A JButton that checks if the user wants to play.
     */
    private JButton playButton;
    /**
     * A JButton that checks if the user wants to quit.
     */
    private JButton quitButton;
    /**
     * A JLabel that displays the title of the game.
     */
    //private JLabel title;
    /**
     * A JLabel that contains the menu background image.
     */
    private JLabel background;
    /**
     * The <code>Game</code> object to be communicated with.
     */
    //private Game game;

    /**
     * Creates and displays the menu.
     *
     * @param game the <code>Game</code> object to be
     * communicated with
     */
    public LandingPage() {
        super("Starship Landing Page");
        //this.game = game;
        createMenuFrame();
        //playBackgroundMusic(-4.0f);
    }

    /**
     * Creates the Menu JFrame.
     */
    private void createMenuFrame() {
        setPreferredSize(new Dimension(700, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // -------------- Background image -------------- \\
        background = new JLabel(new ImageIcon("src/images/Starship.png"));
        background.setSize(new Dimension(700, 500));
        setContentPane(background);
        setLayout(new GridBagLayout());

        // ----------- GridBagConstraints ----------- \\
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(15, 40, 15, 40);
        c.gridwidth = GridBagConstraints.REMAINDER;

        // ----------------- Buttons ---------------- \\
        playButton = new JButton(new ImageIcon("src/images/StarshipPLAY.png"));
        quitButton = new JButton("Quit Game");
        //playButton.setIcon(game.getAssets().getPlayButtonIcon());
        playButton.setBorderPainted(false);
        playButton.setBorder(null);
        //quitButton.setIcon(game.getAssets().getQuitButtonIcon());
        quitButton.setBorderPainted(false);
        quitButton.setBorder(null);

        playButton.addActionListener(this);
        playButton.setActionCommand("play");
        quitButton.addActionListener(this);
        quitButton.setActionCommand("quit");

        // ------------- Title Label ---------------- \\
//        title = new JLabel();
//        title.setIcon(game.getAssets().getTitleIcon());
//        title.setFont(new Font("", Font.BOLD, 80));
//        title.setBorder(new LineBorder(Color.BLACK));
//        title.setBackground(Color.BLUE);
//        title.setForeground(Color.BLACK);
//
//        add(title, c);
        add(playButton, c);
        add(quitButton, c);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Plays the menu background music with a specified volume.
     *
     * @param volume a float representing how loud the music should be played
     */
//    private void playBackgroundMusic(float volume) {
//        game.getAssets().getMenuBgMusic().play(volume);
//    }

    /**
     * This method is called every time an action is
     * performed. Used to check for button presses.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "play") {
            System.out.println("lets play");
//            game.setCurrentState("init game");
//            game.getAssets().getMenuBgMusic().stop();
//            dispose();
        } else {
//            game.getAssets().getMenuBgMusic().stop();
//            game.stop();
            System.out.println("it's not working");
            dispose();
        }
    }

}