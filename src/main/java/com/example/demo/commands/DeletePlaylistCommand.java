package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.IPlaylistService;

public class DeletePlaylistCommand implements ICommand {

    private IPlaylistService playlistService;

    public DeletePlaylistCommand(IPlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // DELETE_PLAYLIST PLAYLIST_1
        String title = tokens.get(1);
        playlistService.delete(title);
        // Playlist PLAYLIST_1 is deleted!
        System.out.println("Playlist "+title+" is deleted!");
    }
    
}
