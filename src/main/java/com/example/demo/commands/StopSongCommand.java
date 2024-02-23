package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Song;
import com.example.demo.services.IPlayerService;

public class StopSongCommand implements ICommand {

    private IPlayerService playerService;
    

    public StopSongCommand(IPlayerService playerService) {
        this.playerService = playerService;
    }


    @Override
    public void invoke(List<String> tokens) {
        // PLAY_SONG
        Song song = playerService.stopSong();
        // Song [id=2] is playing!
        System.out.println(song + " is " + song.getStatus().getStatus() + "!");
    }
}
    