package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Artist;
import com.example.demo.entities.Song;
import com.example.demo.services.IArtistService;
import com.example.demo.services.ISongService;

public class AddSongCommand implements ICommand {

    private final ISongService songService;
    private final IArtistService artistService;

    public AddSongCommand(ISongService songService, IArtistService artistService) {
        this.songService = songService;
        this.artistService = artistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // ADD_SONG Song_1 Artist_1 Album_1 Genre_1
        String title = tokens.get(1);
        String artistName = tokens.get(2);
        String album = tokens.get(3);
        String genre = tokens.get(4);
        Artist artist = artistService.addArtist(artistName);
        Song song = songService.createSong(title, genre, album, artist);
        System.out.println(song);
    }
    
}
