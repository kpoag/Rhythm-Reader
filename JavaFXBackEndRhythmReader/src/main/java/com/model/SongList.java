package com.model;

import java.util.ArrayList;
import java.util.List;

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

    public List<Song> filterByGenre(String genre) {
        return songs;

    }

    public List<Song> filterByArtist(String artist) {
        return songs;

    }

    public List<Song> sortAlphabetically() {
        return songs;

    }

    public List<Song> sortByInstrument() {
        return songs;

    }
    public List<Song> sortByPopularity() {
        return songs;

    }
    public boolean save() {
        return true;
    }
    
}
