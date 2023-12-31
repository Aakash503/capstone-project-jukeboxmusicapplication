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

            long clipPause = 0;
            int choice;

            do {
                System.out.println("Select option");
                System.out.println("1. Play in loop");
                System.out.println("2. Pause the song");
                System.out.println("3. Resume the song");
                System.out.println("4. Restart the song");
                System.out.println("5. Exit");
                Scanner scanner = new Scanner(System.in);
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        // Play song in loop
                        System.out.println("Enter no. of times you want to play this song in loop");
                        int index = scanner.nextInt();
                        clip.loop(index);
                        break;
                    case 2:
                        clipPause = clip.getMicrosecondPosition();
                        clip.stop();
                        System.out.println("Song paused");
                        break;
                    case 3: {
                        clip.setMicrosecondPosition(clipPause);
                        clip.start();
                        System.out.println("Song Resume");
                        break;
                    }
                    case 4: {
                        clip.setMicrosecondPosition(0);
                        clip.start();
                        System.out.println("Song Restarted");
                        break;
                    }

                    case 5: {
                        System.out.println("exit");
                        break;
                    }
                    default:
                        System.out.println("Invalid option");
                }
            } while (choice != 5);

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