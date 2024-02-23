package com.example.demo.repositories;

import com.example.demo.entities.Player;
import com.example.demo.entities.Playlist;

public interface IPlayerRepository {
    Player setPlayer(Playlist playlist);
    Player getPlayer();
}
