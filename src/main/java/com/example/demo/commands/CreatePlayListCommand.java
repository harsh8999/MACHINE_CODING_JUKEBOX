package com.example.demo.commands;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.entities.Playlist;
import com.example.demo.services.IPlaylistService;

public class CreatePlayListCommand implements ICommand {

    private final IPlaylistService playlistService;

    public CreatePlayListCommand(IPlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // CREATE_PLAYLIST PLAYLIST_1 2 4 6 8
        String title = tokens.get(1);
        List<Integer> songIds = new ArrayList<>();
        for(int i = 2; i < tokens.size(); i++) {
            songIds.add(Integer.parseInt(tokens.get(i)));
        }
        Playlist playlist = playlistService.create(title, songIds);
        System.out.println(playlist);
    }
    
}
