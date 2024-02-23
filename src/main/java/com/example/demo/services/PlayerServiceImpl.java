package com.example.demo.services;

import com.example.demo.dataStructure.Node;
import com.example.demo.entities.Player;
import com.example.demo.entities.Playlist;
import com.example.demo.entities.Song;
import com.example.demo.entities.Status;
import com.example.demo.repositories.IPlayerRepository;
import com.example.demo.repositories.IPlaylistRepository;

public class PlayerServiceImpl implements IPlayerService {

    private IPlayerRepository playerRepository;
    private IPlaylistRepository playlistRepository;

    private Node currSongPlaying; // CDLL


    public PlayerServiceImpl(IPlayerRepository playerRepository,
            IPlaylistRepository playlistRepository) {
        this.playerRepository = playerRepository;
        this.playlistRepository = playlistRepository;
        this.currSongPlaying = null;
    }

    @Override
    public Playlist loadPlaylist(String playlistTitle) {
        Playlist playlist = playlistRepository.findByTitle(playlistTitle);
        if(playlist == null) {
            throw new RuntimeException("Playlist with Title "+playlistTitle+" Not Found!!!");
        }
        Player player = playerRepository.setPlayer(playlist);
        currSongPlaying = null;
        return player.getPlaylist();
    }

    @Override
    public Song playSong() {
        Player player = playerRepository.getPlayer();
        // if current song is playing and we do play song command than song should pause
        if(currSongPlaying != null && currSongPlaying.song.getStatus() == Status.PLAYING) {
            currSongPlaying.song.setStatus(Status.PAUSED);
            return currSongPlaying.song;
        }
        // if song was stopped and played again
        if(currSongPlaying != null && currSongPlaying.song != player.getHeadOfSongsCDLL().song) {
            currSongPlaying.song.setStatus(Status.PLAYING);
            return currSongPlaying.song;
        }
        currSongPlaying = player.getHeadOfSongsCDLL();
        player.songStack.push(currSongPlaying);
        Song songPlaying = player.songStack.peek().song;
        songPlaying.setStatus(Status.PLAYING);
        return songPlaying;
    }



    @Override
    public Song playNextSong() {
        Player player = playerRepository.getPlayer();
        currSongPlaying.song.setStatus(Status.STOPPED); // stop current song
        // load next song
        currSongPlaying = currSongPlaying.next; 
        player.songStack.push(currSongPlaying);
        // play song
        Song songPlaying = player.songStack.peek().song;
        songPlaying.setStatus(Status.PLAYING);
        return songPlaying;
    }

    @Override
    public Song playPrevSong() {
        Player player = playerRepository.getPlayer();
        currSongPlaying.song.setStatus(Status.STOPPED); // stop current song
        player.songStack.pop();  // remove the current playing song
        if(player.songStack.isEmpty()) {
            currSongPlaying = currSongPlaying.previous;
            player.songStack.push(currSongPlaying);
        } else {
            currSongPlaying = player.songStack.peek(); // move current pointer to the playing song
        }
        Song songPlaying = player.songStack.peek().song;
        songPlaying.setStatus(Status.PLAYING);
        return songPlaying;
    }

    @Override
    public Song stopSong() {
        currSongPlaying.song.setStatus(Status.STOPPED); // stop current song
        return currSongPlaying.song;
    }

        
}
