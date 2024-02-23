package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.IPlayerService;

public class LoadPlaylistCommand implements ICommand {

    private IPlayerService playerService;

    public LoadPlaylistCommand(IPlayerService playerService) {
        this.playerService = playerService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // LOAD_PLAYLIST PLAYLIST_1
        String playlistTitle = tokens.get(1);
        playerService.loadPlaylist(playlistTitle);
        // Playlist PLAYLIST_1 is loaded!
        System.out.println("Playlist "+ playlistTitle +" is loaded!");
    }
}
