package com.example.demo;

import com.example.demo.commands.AddSongCommand;
import com.example.demo.commands.AddSongToPlaylistCommand;
import com.example.demo.commands.CommandKeyword;
import com.example.demo.commands.CommandRegistry;
import com.example.demo.commands.CreateGreetingCommand;
import com.example.demo.commands.CreatePlayListCommand;
import com.example.demo.commands.DeletePlaylistCommand;
import com.example.demo.commands.DeleteSongFromPlaylistCommand;
import com.example.demo.commands.GetGreetingCommand;
import com.example.demo.commands.ListGreetingCommand;
import com.example.demo.commands.ListSongCommand;
import com.example.demo.commands.LoadPlaylistCommand;
import com.example.demo.commands.NextSongCommand;
import com.example.demo.commands.PlaySongCommand;
import com.example.demo.commands.PreviousSongCommand;
import com.example.demo.commands.StopSongCommand;
import com.example.demo.repositories.ArtistRepository;
import com.example.demo.repositories.GreetingRepository;
import com.example.demo.repositories.IArtistRepository;
import com.example.demo.repositories.IGreetingRepository;
import com.example.demo.repositories.IPlayerRepository;
import com.example.demo.repositories.IPlaylistRepository;
import com.example.demo.repositories.ISongRepository;
import com.example.demo.repositories.PlayerRepository;
import com.example.demo.repositories.PlaylistRepository;
import com.example.demo.repositories.SongRepository;
import com.example.demo.services.ArtistService;
import com.example.demo.services.GreetingService;
import com.example.demo.services.IArtistService;
import com.example.demo.services.IPlayerService;
import com.example.demo.services.IPlaylistService;
import com.example.demo.services.ISongService;
import com.example.demo.services.PlayerServiceImpl;
import com.example.demo.services.PlaylistServiceImpl;
import com.example.demo.services.SongServiceImpl;

public class Configuration {
            // Singleton Pattern
            //create an object of Single Configuration Object
            private static Configuration instance = new Configuration();

            //make the constructor private so that this class cannot be
            //instantiated
            private Configuration(){}

            //Get the only object available
            public static Configuration getInstance(){
                return instance;
            }

    		// Initialize repositories
            private final IGreetingRepository greetingRepository = new GreetingRepository();
            private final ISongRepository songRepository = new SongRepository();
            private final IPlaylistRepository playlistRepository = new PlaylistRepository();
            private final IPlayerRepository playerRepository = new PlayerRepository();
            private final IArtistRepository artistRepository = new ArtistRepository();
    
            // Initialize services
            private final GreetingService greetingService = new GreetingService(greetingRepository);
            private final ISongService songService = new SongServiceImpl(songRepository);
            private final IPlaylistService playlistService= new PlaylistServiceImpl(playlistRepository, songRepository);
            private final IPlayerService playerService = new PlayerServiceImpl(playerRepository, playlistRepository);
            private final IArtistService artistService = new ArtistService(artistRepository);

            // Initialize commands
            private final CreateGreetingCommand createGreetingCommand = new CreateGreetingCommand(greetingService);
            private final ListGreetingCommand listGreetingCommand = new ListGreetingCommand(greetingService);
            private final GetGreetingCommand  getGreetingCommand = new GetGreetingCommand(greetingService);
            private final AddSongCommand addSongCommand = new AddSongCommand(songService, artistService);
            private final ListSongCommand listSongCommand = new ListSongCommand(songService);
            private final CreatePlayListCommand createPlayListCommand = new CreatePlayListCommand(playlistService);
            private final LoadPlaylistCommand loadPlaylistCommand = new LoadPlaylistCommand(playerService) ;
            private final PlaySongCommand playSongCommand = new PlaySongCommand(playerService);
            private final NextSongCommand nextSongCommand = new NextSongCommand(playerService);
            private final PreviousSongCommand previousSongCommand = new PreviousSongCommand(playerService);
            private final StopSongCommand stopSongCommand = new StopSongCommand(playerService);
            private final DeletePlaylistCommand deletePlaylistCommand = new DeletePlaylistCommand(playlistService);
            private final AddSongToPlaylistCommand addSongToPlaylistCommand = new AddSongToPlaylistCommand(playlistService);
            private final DeleteSongFromPlaylistCommand deleteSongFromPlaylistCommand = new DeleteSongFromPlaylistCommand(playlistService);
            

            // Initialize commandRegistery
            private final CommandRegistry commandRegistry = new CommandRegistry();

            // Register commands 
            private void registerCommands(){
                commandRegistry.registerCommand(CommandKeyword.CREATE_GREETING_COMMAND.getName(),createGreetingCommand);
                commandRegistry.registerCommand(CommandKeyword.LIST_GREETING_COMMAND.getName(),listGreetingCommand);
                commandRegistry.registerCommand(CommandKeyword.GET_GREETING_COMMAND.getName(),getGreetingCommand);
                commandRegistry.registerCommand(CommandKeyword.ADD_SONG_COMMAND.getName(), addSongCommand);
                commandRegistry.registerCommand(CommandKeyword.LIST_SONGS_COMMAND.getName(), listSongCommand);
                commandRegistry.registerCommand(CommandKeyword.CREATE_PLAYLIST_COMMAND.getName(), createPlayListCommand);
                commandRegistry.registerCommand(CommandKeyword.LOAD_PLAYLIST_COMMAND.getName(), loadPlaylistCommand);
                commandRegistry.registerCommand(CommandKeyword.PLAY_SONG_COMMAND.getName(), playSongCommand);
                commandRegistry.registerCommand(CommandKeyword.NEXT_SONG_COMMAND.getName(), nextSongCommand);
                commandRegistry.registerCommand(CommandKeyword.PREVIOUS_SONG_COMMAND.getName(), previousSongCommand);
                commandRegistry.registerCommand(CommandKeyword.STOP_SONG_COMMAND.getName(), stopSongCommand);
                commandRegistry.registerCommand(CommandKeyword.DELETE_PLAYLIST_COMMAND.getName(), deletePlaylistCommand);
                commandRegistry.registerCommand(CommandKeyword.ADD_SONG_TO_PLAYLIST_COMMAND.getName(), addSongToPlaylistCommand);
                commandRegistry.registerCommand(CommandKeyword.DELETE_SONG_FROM_PLAYLIST_COMMAND.getName(), deleteSongFromPlaylistCommand);
                
            }
            
            public CommandRegistry getCommandRegistry(){
                registerCommands();
                return commandRegistry;
            }
}
