/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * Classe aprimorada por RUAN GABRIEL G. BARROS - KOULIKOV SYSTEMS
 */
package system.controller;

import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

/**
 *
 * @author Koulikov
 */
public class CTRAudio {
    
    private static int openedTracks = 0;
    private static final int MAX_TRACKS = 50;
    
    private static synchronized void openTrack(Clip c) {
        c.start();
        ++openedTracks;
    }
    
    private static synchronized void closeTrack(Clip c) {
        c.close();
        --openedTracks;
    }
    
    public static void play(String filename) {
        if (openedTracks >= MAX_TRACKS) {
            return;
        }
        
        new Thread(() -> {
            Clip clip = null;
            try {
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(CTRAudio.class.getResource(filename));
                DataLine.Info info = new DataLine.Info(Clip.class, inputStream.getFormat());
                clip = (Clip) AudioSystem.getLine(info);
                clip.open(inputStream);
                openTrack(clip);
                
                while (!clip.isRunning()) {
                    Thread.sleep(100);
                }
                while (clip.isRunning()) {
                    Thread.sleep(100);
                }
                inputStream.close();
            } catch (Exception ex) {
                System.err.println(ex);
            } finally {
                if (clip != null) {
                    closeTrack(clip);
                }
            }
        }).start();
        
    }
}
