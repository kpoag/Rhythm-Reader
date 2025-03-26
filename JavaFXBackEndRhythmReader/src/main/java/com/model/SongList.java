package com.model;

import java.util.ArrayList;

/**
 * The SongList class manages a list of songs, providing methods for filtering, adding, 
 * and sorting songs based on different criteria. It implements a Singleton pattern to 
 * ensure a single instance of the list.
 */
public class SongList {

    private ArrayList<Song> songs;

    private static SongList instance;

    private SongList() {
        songs = DataLoader.loadSongs();
    }

    /**
     * Returns the single instance of the SongList.
     *
     * @return the instance of SongList
     */
    public static SongList getInstance(){
        if (instance == null) {
            instance = new SongList();
        }
        return instance;
    }

    /**
     * Adds a song to the list.
     *
     * @param song the song to be added
     * @return true if the song was added successfully
     */
    public boolean addSong(Song song) {
        return songs.add(song);
    }

    /**
     * Filters songs by genre.
     *
     * @param genre the genre to filter by
     * @return a list of songs matching the genre
     */
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

    /**
     * Filters songs by artist.
     *
     * @param artist the artist to filter by
     * @return a list of songs matching the artist
     */
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

    /**
     * Sorts the songs alphabetically.
     *
     * @return the list of songs sorted alphabetically
     */
    public ArrayList<Song> sortAlphabetically() {
        return songs;
    }

    /**
     * Sorts the songs by instrument.
     *
     * @return the list of songs sorted by instrument
     */
    public ArrayList<Song> sortByInstrument() {
        return songs;
    }

    /**
     * Sorts the songs by popularity.
     *
     * @return the list of songs sorted by popularity
     */
    public ArrayList<Song> sortByPopularity() {
        return songs;
    }

    /**
     * Returns the list of all songs.
     *
     * @return the list of songs
     */
    public ArrayList<Song> getSongs() {
        return songs;
    }

    /**
     * Saves the current song list (implementation placeholder).
     *
     * @return true if the save operation is successful
     */
    public boolean save() {
        return true;
    }

    /**
     * Saves the songs to a persistent storage.
     *
     * @return true if the songs are saved successfully
     */
    public boolean saveSongs() {
        return DataWriter.saveSongs();
    }
}
