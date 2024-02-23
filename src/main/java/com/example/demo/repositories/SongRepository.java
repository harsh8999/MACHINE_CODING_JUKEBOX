package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.example.demo.entities.Song;

public class SongRepository implements ISongRepository {

    private Map<Integer, Song> songMap;
    private int autoIncrement = 0;

    public SongRepository() {
        this.songMap = new HashMap<Integer, Song>();
    }

    @Override
    public Song save(Song entity) {
        if(entity.getId() == null) {
            autoIncrement++;
            Song s = new Song(autoIncrement, entity.getTitle(), entity.getGenre(), entity.getAlbum(), entity.getArtists());
            songMap.put(s.getId(), s);
            return s;
        }
        songMap.put(entity.getId(), entity);
        return entity; 
    }

    @Override
    public void deleteById(Integer id) {
        songMap.remove(id);
    }

    @Override
    public List<Song> findAll() {
        if(songMap.isEmpty()) return new ArrayList<>();

        return songMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Song findById(Integer id) {
        return songMap.get(id);
    }

    @Override
    public Song findByTitle(String title) {
        return songMap.entrySet().stream()
                                    .map(e -> e.getValue())
                                    .filter(e -> e.getTitle().equals(title))
                                    .findFirst()
                                    .orElseThrow(() -> new RuntimeException("Song with song title "+ title+" Not Found!!!"));
    }
    
}
