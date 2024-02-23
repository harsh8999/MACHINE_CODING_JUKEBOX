package com.example.demo.services;

import java.util.List;
import com.example.demo.entities.Artist;
import com.example.demo.entities.Song;
import com.example.demo.repositories.ISongRepository;

public class SongServiceImpl implements ISongService{
    private ISongRepository songRepository;

    
    public SongServiceImpl(ISongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public Song createSong(String title, String genre, 
            String album, Artist artists) {
        Song song = new Song(null, title, genre, album, artists);
        return this.songRepository.save(song);
    }

    @Override
    public List<Song> getSongs() {
        return songRepository.findAll();
    }

}
