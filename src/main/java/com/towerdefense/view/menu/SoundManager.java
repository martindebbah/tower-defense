package com.towerdefense.view.menu;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.lang.Runnable;
import java.util.concurrent.atomic.AtomicBoolean;
/**
* @see http://www.anyexample.com/programming/java/java_play_wav_sound_file.xml
*/
public class SoundManager implements Runnable{
    static Class class__ = SoundManager.class;
    private final static int EXTERNAL_BUFFER_SIZE = 524288; // 128Kb
    private final AtomicBoolean running = new AtomicBoolean(false);
    private SourceDataLine auline = null;
    private Thread worker;
    private int status;

    public boolean fin = false;
    
    static String sound;
    //public SoundManager(String s){sound = s;}
    
    public void play(int status){
        this.status = status;
        switch(status){
            case 0:
                sound = "src/main/resources/sound/victory.wav"; // musique victoire
                break;
            case 1:
                sound = "src/main/resources/sound/defeat.wav"; // musique defaite
                break;
            case 2:
                sound = "src/main/resources/sound/su.wav"; // musique intro
                break;
            case 3:
                sound = "src/main/resources/sound/goblin_true.wav"; // son basicEnemy
                break;

        }
        worker = new Thread(this);
        worker.start();
    }

    @Override
    public void run() {
        running.set(true);
        while (running.get()) {
            try {
                if(status <= 2) Thread.sleep(100);
                if(status == 3) Thread.sleep(3000);
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.println(
                  "Thread was interrupted, Failed to complete operation");
            }
                File soundFile = new File(sound);
                if (!soundFile.exists()) { 
                    System.err.println("Wave file not found: " + sound);
                    return;
                } 
                
                AudioInputStream audioInputStream = null;
                try {
                    audioInputStream = AudioSystem.getAudioInputStream(soundFile);
                } catch (UnsupportedAudioFileException e1) {
                    e1.printStackTrace();
                    return;
                } catch (IOException e1) {
                    e1.printStackTrace();
                    return;
                }
                AudioFormat format = audioInputStream.getFormat();
                DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

                try {
                    auline = (SourceDataLine) AudioSystem.getLine(info);
                    auline.open(format);
                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }

                if (auline.isControlSupported(FloatControl.Type.PAN)) {
                    FloatControl pan = (FloatControl) auline.getControl(FloatControl.Type.PAN);
                }
                int nBytesRead = 0;
                auline.start();
                byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];
                            try {
                    while (nBytesRead != -1 && running.get()) {
                        nBytesRead = audioInputStream.read(abData, 0, abData.length);
                        if (nBytesRead >= 0){
                            auline.write(abData, 0, nBytesRead);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                } finally {
                    auline.drain();
                    auline.close();
                }
         }
    }

    public void stop() {
        running.set(false);
        //System.out.println(running.get()+" : "+sound);
    }

    public boolean isRunning() {
        return running.get();
    }
  
}
