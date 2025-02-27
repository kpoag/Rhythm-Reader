package com.model;

import com.rhythmreader.*;

import java.lang.Thread;


public class MusicPlayer {


    public void playSong() {
        try {
            playMeasure1and2();
            Thread.sleep(300);
            playMeasure4();
            Thread.sleep(300);
            playMeasure5();
            Thread.sleep(300);
            playMeasure6();
            Thread.sleep(300);
            playMeasure7();
            Thread.sleep(300);
            playMeasure8();
            Thread.sleep(300);
            playMeasure9();
            Thread.sleep(300);

        }
        catch(Exception e){
            System.out.println(e);
        }
    }



private void playMeasure1and2() {
    Music.playNote("E");
    Music.playNote("D");
    Music.playNote("C");
    Music.playNote("D");
    Music.playNote("E");
    Music.playNote("E");
    Music.playNote("E");
}
private void playMeasure4() {
    Music.playNote("D");
    Music.playNote("D");
    Music.playNote("D");
}
private void playMeasure5() {
    Music.playNote("E");
    Music.playNote("G");
    Music.playNote("G");
}
private void playMeasure6(){
    Music.playNote("E");
    Music.playNote("D");
    Music.playNote("C");
    Music.playNote("D");
}
private void playMeasure7(){
    Music.playNote("E");
    Music.playNote("E");
    Music.playNote("E");
    Music.playNote("E");
}
private void playMeasure8(){
    Music.playNote("D");
    Music.playNote("D");
    Music.playNote("E");
    Music.playNote("D");
}
private void playMeasure9(){
    Music.playNote("C");
}



    public static void main(String[] args){
        MusicPlayer player = new MusicPlayer();
        player.playSong();
    }
    
}
