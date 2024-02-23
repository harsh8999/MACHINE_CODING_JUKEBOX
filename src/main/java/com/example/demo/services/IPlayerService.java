package com.example.demo.services;

import com.example.demo.entities.Playlist;
import com.example.demo.entities.Song;

public interface IPlayerService {
    Playlist loadPlaylist(String playlistTitle);
    Song playSong();
    Song playNextSong();
    Song playPrevSong();
    Song stopSong();
}
