package com.towerdefense.view.menu;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.lang.Runnable;
import java.util.Random;
/**
* @see http://www.anyexample.com/programming/java/java_play_wav_sound_file.xml
*/
public class SoundManager implements Runnable{
    static Class class__ = SoundManager.class;
    private final static int EXTERNAL_BUFFER_SIZE = 524288; // 128Kb
    private SourceDataLine auline = null;

    public boolean fin = false;
    
    static String sound;
    public SoundManager(String s){sound = s;}
    
    public void play(){
        new Thread(new SoundManager(sound)).start();
    }

    @Override
    public void run() {
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
            while (nBytesRead != -1) {
                System.out.println(fin);
                nBytesRead = audioInputStream.read(abData, 0, abData.length);
                if (nBytesRead >= 0){
                    auline.write(abData, 0, nBytesRead);
                }
                if(this.fin){
                    break;
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
