package com.model;

import java.util.ArrayList;

public class SongList {

    private ArrayList<Song> songs;

    private static SongList instance;

    private SongList() {
        songs = new ArrayList<>();
    } 
    
    public static SongList getInstance(){
        if (instance == null) {
            instance = new SongList();
        }
        return instance;
    }

    public boolean addSong(Song song) {
        return songs.add(song);
    }

    public ArrayList<Song> filterByGenre(String genre) {
        return songs;

    }

    public ArrayList<Song> filterByArtist(String artist) {
        return songs;

    }

    public ArrayList<Song> sortAlphabetically() {
        return songs;

    }

    public ArrayList<Song> sortByInstrument() {
        return songs;

    }
    public ArrayList<Song> sortByPopularity() {
        return songs;

    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public boolean save() {
        return true;
    }
    
}
