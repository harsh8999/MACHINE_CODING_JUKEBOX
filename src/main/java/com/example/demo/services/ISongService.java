package com.example.demo.services;

import java.util.List;
import com.example.demo.entities.Artist;
import com.example.demo.entities.Song;

public interface ISongService {
    Song createSong(String title, String genre, String album, Artist artists);
    List<Song> getSongs();
}
