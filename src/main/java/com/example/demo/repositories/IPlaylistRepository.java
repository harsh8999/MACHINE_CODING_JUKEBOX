package com.example.demo.repositories;

import com.example.demo.entities.Playlist;

public interface IPlaylistRepository extends ICRUDRepository<Playlist, Integer>{
    Playlist findByTitle(String title);
}
