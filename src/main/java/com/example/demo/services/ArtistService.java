package com.example.demo.services;

import com.example.demo.entities.Artist;
import com.example.demo.repositories.IArtistRepository;

public class ArtistService implements IArtistService{

    private IArtistRepository artistRepository;

    public ArtistService(IArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public Artist addArtist(String name) {
        Artist artist = new Artist(null, name);
        return artistRepository.save(artist);
    }
    
}
