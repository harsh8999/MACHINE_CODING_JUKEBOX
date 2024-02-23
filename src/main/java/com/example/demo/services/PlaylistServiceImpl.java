package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.entities.Playlist;
import com.example.demo.entities.Song;
import com.example.demo.repositories.IPlaylistRepository;
import com.example.demo.repositories.ISongRepository;

public class PlaylistServiceImpl implements IPlaylistService {

    private IPlaylistRepository playlistRepository;
    private ISongRepository songRepository;

    public PlaylistServiceImpl(IPlaylistRepository playlistRepository,
            ISongRepository songRepository) {
        this.playlistRepository = playlistRepository;
        this.songRepository = songRepository;
    }

    @Override
    public Playlist create(String playlistTitle, List<Integer> songIds) {
        List<Song> songs = new ArrayList<>();
        for(Integer id: songIds) {
            Song song = songRepository.findById(id); // if song not found than exception would be thrown...
            if(song == null) {
                throw new RuntimeException("Song with songId "+ id +" Not Found!!!");
            }
            songs.add(song);
        }
        Playlist playlist = new Playlist(null, playlistTitle, songs);
        return playlistRepository.save(playlist);
    }

    @Override
    public void delete(String playlistTitle) {
        Playlist playlist = playlistRepository.findByTitle(playlistTitle);
        playlistRepository.deleteById(playlist.getId());
    }

    @Override
    public Playlist addSong(String playlistTitle, Integer songId) {
        Playlist playlist = playlistRepository.findByTitle(playlistTitle);
        Song song = songRepository.findById(songId);
        playlist.addSong(song);
        return playlist;
    }

    @Override
    public Playlist deleteSong(String playlistTitle, Integer songIds) {
        Playlist playlist = playlistRepository.findByTitle(playlistTitle);
        Song song = songRepository.findById(songIds);
        playlist.deleteSong(song);
        return playlist;
    }

        
}
