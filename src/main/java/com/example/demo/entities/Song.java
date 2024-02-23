package com.example.demo.entities;

public class Song {
    private Integer id;
    private String title;
    private String genre;
    private String album;
    private Artist artists;
    private Status status;

    public Song(Integer id, String title, String genre, String album, Artist artists) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.album = album;
        this.artists = artists;
        this.status = Status.STOPPED;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Artist getArtists() {
        return artists;
    }

    public void setArtists(Artist artists) {
        this.artists = artists;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Song [id=" + id + "]";
    }

}
