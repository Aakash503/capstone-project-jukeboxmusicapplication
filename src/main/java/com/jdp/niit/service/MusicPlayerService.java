package com.jdp.niit.service;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class MusicPlayerService {
    public void play(String songPath) {
        // 2. a file object that contains our song
        File songFile = new File(songPath);
        try {
            // 3. an object of the AudioInputStream class
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(songFile);
            // 4. get a clip object from the AudioSystem
            Clip clip = AudioSystem.getClip();
            // 5. use the clip object to open the audio input stream
            clip.open(audioInputStream);
            // 6. set a loop for the sound file
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            // 7. start the sound file
            clip.start();

            System.out.println("select option");
            System.out.println("1. Pause a song");
            System.out.println("2. Play song in loop");

            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    clip.close();
                    System.out.println("song paused");
                    break;

                case 2:
                    System.out.println("Enter the count in which you want to play song in loop");
                    int count = scanner.nextInt();
                    clip.loop(count);
                    break;
                case 3:
                    System.out.println("EXIT");
                    break;
                default:
                    System.out.println("invalid choice");

            }

            // 8. pause the current thread for the time the song is being played
            long songDurationInMilliseconds = clip.getMicrosecondLength() / 1000L;
            Thread.sleep(songDurationInMilliseconds);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException exception) {
            System.err.println(exception.getMessage());
            exception.printStackTrace();
        } catch (InterruptedException e) {
            System.err.println("song thread was interrupted");
            Thread.currentThread().interrupt();
        }
    }
}