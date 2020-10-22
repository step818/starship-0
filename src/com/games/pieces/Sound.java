package com.games.pieces;

import javax.sound.sampled.*;
import java.io.*;
import java.nio.file.Path;

public class Sound {
    Clip audioClip;
    public void playSound() throws FileNotFoundException, LineUnavailableException {
        try {
            File inputFile = new File(String.valueOf(Path.of("Sound","beep-07.wav")));
            //String soundFile = "Sound/beep-07.wav";
//            InputStream in = new FileInputStream(soundFile);

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(inputFile);
            audioClip = AudioSystem.getClip();
            audioClip.open(audioInputStream);
            audioClip.start();


            AudioSystem.getAudioFileTypes(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
    }
}
