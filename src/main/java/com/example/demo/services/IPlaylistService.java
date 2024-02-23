package com.example.demo.services;

import java.util.List;
import com.example.demo.entities.Playlist;

public interface IPlaylistService {
    Playlist create(String playlistTitle, List<Integer> songIds);
    void delete(String playlistTitle);
    Playlist addSong(String playlistTitle, Integer songIds);
    Playlist deleteSong(String playlistTitle, Integer songIds);
}
