package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Playlist;
import com.example.demo.services.IPlaylistService;

public class AddSongToPlaylistCommand implements ICommand {

    private final IPlaylistService playlistService;
    

    public AddSongToPlaylistCommand(IPlaylistService playlistService) {
        this.playlistService = playlistService;
    }


    @Override
    public void invoke(List<String> tokens) {
        // ADD_SONG Song_1 Artist_1 Album_1 Genre_1
        String playlistTitle = tokens.get(1);
        Integer songId = Integer.parseInt(tokens.get(2));
        Playlist playlist = playlistService.addSong(playlistTitle, songId);
        // Playlist PLAYLIST_2 is revised with [Song [id=1], Song [id=3], Song [id=5], Song [id=7], Song [id=9], Song [id=8]]
        System.out.println("Playlist "+ playlistTitle + " is revised with " + playlist.getSongs());
    }
    
}
