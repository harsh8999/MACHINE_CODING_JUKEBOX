package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Song;
import com.example.demo.services.ISongService;

public class ListSongCommand implements ICommand {

    private final ISongService songService;
    

    public ListSongCommand(ISongService songService) {
        this.songService = songService;
    }

    @Override
    public void invoke(List<String> tokens) {
        List<Song> songs = songService.getSongs();
        System.out.println(songs);
    }
}
