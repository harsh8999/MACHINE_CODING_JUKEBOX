package com.example.demo.repositories;

import com.example.demo.entities.Player;
import com.example.demo.entities.Playlist;

public class PlayerRepository implements IPlayerRepository{
    private Player player;
    
    @Override
    public Player setPlayer(Playlist playlist) {
        player = new Player(playlist);
        return player;
    }

    @Override
    public Player getPlayer() {
        return player;
    }
}
