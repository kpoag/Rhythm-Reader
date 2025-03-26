package com.model;

import java.util.ArrayList;

public class SongList {

    private ArrayList<Song> songs;

    private static SongList instance;

    private SongList() {
        songs = DataLoader.loadSongs();
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
        if (genre == null || genre.isEmpty()) {
            return new ArrayList<>(songs);
        }
        ArrayList<Song> filteredSongs = new ArrayList<>();
        for (Song song : songs) {
            if (genre.equalsIgnoreCase(song.getGenre().toString())) {
                filteredSongs.add(song);
            }
        }
        return filteredSongs;
    }
        

    public ArrayList<Song> filterByArtist(String artist) {
        if (artist == null || artist.isEmpty()) {
            return new ArrayList<>(songs);
        }
        
        ArrayList<Song> filteredSongs = new ArrayList<>();
        for (Song song : songs) {
            if (artist.equalsIgnoreCase(song.getArtist())) {
                filteredSongs.add(song);
            }
        }
        return filteredSongs;
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

    public boolean saveSongs() {
        return DataWriter.saveSongs();
    }
    
}
