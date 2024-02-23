package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private Integer id;
    private String title;
    private List<Song> songs;
    

    public Playlist(Integer id, String title, List<Song> songs) {
        this.id = id;
        this.title = title;
        this.songs = songs != null ? songs : new ArrayList<>();
    }

    
    
    public Integer getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public List<Song> getSongs() {
        return songs;
    }


    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }



    public void addSong(Song song) {
        if(!songs.contains(song)) {
            songs.add(song);
        }
    }

    public void deleteSong(Song song) {
        songs.remove(song);
    }

    public void addSongs(List<Song> songs) {
        songs.stream()
                .distinct()
                .filter(song -> !this.songs.contains(song))
                .forEach(song -> this.songs.add(song));
    }

    public void removeSongs(List<Song> songs) {
        songs.stream()
                .distinct()
                .filter(song -> this.songs.contains(song))
                .forEach(song -> this.songs.remove(song));
    }



    @Override
    public String toString() {
        return "Playlist [id=" + id + "]";
    }
    
    
}
