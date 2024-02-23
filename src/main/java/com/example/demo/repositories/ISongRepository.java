package com.example.demo.repositories;

import com.example.demo.entities.Song;

public interface ISongRepository extends ICRUDRepository<Song, Integer> {
    Song findByTitle(String title);
}
