package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.example.demo.entities.Playlist;

public class PlaylistRepository implements IPlaylistRepository {
    private Map<Integer, Playlist> playlistMap;
    int autoIncrement = 0;


    public PlaylistRepository() {
        this.playlistMap = new HashMap<Integer, Playlist>();
    }

    public PlaylistRepository(Map<Integer, Playlist> playlistMap) {
        this.playlistMap = playlistMap;
        this.autoIncrement = playlistMap.size();
    }

    @Override
    public Playlist save(Playlist entity) {
        if(entity.getId() == null) {
            autoIncrement++;
            Playlist p = new Playlist(autoIncrement, entity.getTitle(), entity.getSongs());
            playlistMap.put(p.getId(), p);
            return p;
        }
        playlistMap.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public void deleteById(Integer id) {
        if(!playlistMap.containsKey(id)) {
            throw new RuntimeException("PlayList with Id "+ id +" Not Found!!!");
        }
        playlistMap.remove(id);
    }

    @Override
    public List<Playlist> findAll() {
        if(playlistMap.isEmpty()) return new ArrayList<>();

        return playlistMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Playlist findById(Integer id) {
        return playlistMap.get(id);
    }

    @Override
    public Playlist findByTitle(String title) {
        return playlistMap.entrySet().stream()
                                    .map(e -> e.getValue())
                                    .filter(e -> e.getTitle().equals(title))
                                    .findFirst()
                                    .orElseThrow(() -> new RuntimeException("PlayList with Title "+ title+" Not Found!!!"));
    }
}
