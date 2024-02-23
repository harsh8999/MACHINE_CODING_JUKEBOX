package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.example.demo.entities.Artist;

public class ArtistRepository implements IArtistRepository {

    private final Map<Integer,Artist> artistMap;
    private Integer autoIncrement = 1;

    public ArtistRepository() {
        this.artistMap = new HashMap<>();
    }

    @Override
    public Artist save(Artist entity) {
        Artist a = new Artist(autoIncrement, entity.getName());
        artistMap.put(autoIncrement, a);
        ++autoIncrement;
        return a;
    }

    @Override
    public void deleteById(Integer id) {
        artistMap.remove(id);
    }

    @Override
    public List<Artist> findAll() {
        return artistMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Artist findById(Integer id) {
        return artistMap.get(id);
    }
    
}
