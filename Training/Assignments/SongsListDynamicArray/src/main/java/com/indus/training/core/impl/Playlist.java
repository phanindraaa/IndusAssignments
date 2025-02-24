package com.indus.training.core.impl;

import com.indus.training.core.svc.IPlaylist;

import java.util.Arrays;

public class Playlist implements IPlaylist {

    static String[] playlistArray;
    public static int MaxSongs = 5;
    public int initialSize;    
    int songCount = 0;
    public int remaining;

    public Playlist(int initialSize) {
        playlistArray = new String[initialSize];
        this.initialSize = initialSize;
        this.remaining = initialSize;
    }

    // Implementing the addSongs method from ISongsPlaylist
    @Override
    public void addSongs(String[] newSongs) throws ArrayIndexOutOfBoundsException{
//        try {
    		
            int number = newSongs.length;
            if (number >= MaxSongs) {
            	throw new ArrayIndexOutOfBoundsException("Max songs can be added is 11");
            }
            
            // Check if the array needs resizing
            if (number > remaining) {
                // Resize the array and copy existing elements
                String[] newArr = new String[songCount + number];
                System.arraycopy(playlistArray, 0, newArr, 0, playlistArray.length);
                playlistArray = newArr;
                remaining = number;
            }
            
            // Add new songs to the playlist
            for (int i = 0; i < number; i++) {
                playlistArray[songCount] = newSongs[i];
                songCount++;
            }
            remaining -= number; // Update remaining space
            
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("Array outside of its bounds.");
        }

    // Implementing the sortSongs method from ISongsPlaylist
    @Override
    public void sortSongs() {
        try {
            Arrays.sort(playlistArray, 0, songCount); // Sort only the filled portion of the array
        } catch (Exception e) {
            System.out.println("Error while sorting the songs");
        }
    }

    // Implementing the getSongs method from ISongsPlaylist
    @Override
    public String getSongs() {
        return Arrays.toString(Arrays.copyOfRange(playlistArray, 0, songCount));
    }
    
    // Implementing the getPlaylistArraySize method from ISongsPlaylist
    @Override
    public int getPlaylistArraySize() {
        return playlistArray.length;
    }
    
    // Main method for demonstration
    public static void main(String[] args) {
        try {
            Playlist playlist = new Playlist(5);
            playlist.addSongs(new String[]{"Song A", "Song B"});
            playlist.addSongs(new String[]{"Song D", "Song C", "Song E", "Song X", "Song Y", "Song Z"});
            playlist.addSongs(new String[]{"Song F", "Song G"});
            System.out.println("Songs: " + playlist.getSongs());
            playlist.sortSongs();
            System.out.println("Sorted Songs: " + playlist.getSongs());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
