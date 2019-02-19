package com.shile;

import com.shile.model.Artist;
import com.shile.model.DataSource;
import com.shile.model.SongArtist;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args){
        DataSource dataSource = new DataSource();
        if (!dataSource.open()){
            System.out.println("can't open datasource");
            return;
        }

//        List<Artist> artists = dataSource.queryArtists(5);
//        if (artists == null) {
//            System.out.println("No artists");
//            return;
//        }
//        for (Artist artist : artists) {
//            System.out.println("ID = " + artist.getId() + ",Name = " + artist.getName());
//        }
//
//        List<String> albumsForArtist =
//                dataSource.queryAlbumsForArtist("Pink Floyd",DataSource.ORDER_BY_DESC);
//        for (String album : albumsForArtist){
//            System.out.println(album);
//        }
        List<SongArtist> songArtists = dataSource.queryArtistForSong("Hold Me",DataSource.ORDER_BY_ASC);
        if (songArtists.isEmpty()) {
            System.out.println("Couldn't find the artist for the song");
            return;
        }

        for (SongArtist songArtist : songArtists) {
            System.out.println("\nArtists = " + songArtist.getArtistName() +
                                "\nAlbum = " + songArtist.getAlbumName() +
                                "\nTrack = " + songArtist.getTrack());
        }

        dataSource.getSongsMetaData();

        int songCount = dataSource.getCount(DataSource.TABLE_SONGS);
        System.out.println("Number of songs: " +songCount);

        dataSource.createViewForSongArtists();

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter a song tile ");
//        String title = scanner.nextLine();
//
//        songArtists = dataSource.querySongInfoView(title);
//        if (songArtists.isEmpty()) {
//            System.out.println("Couldn't find the artist for the song");
//        }
//        for (SongArtist songArtist : songArtists) {
//            System.out.println("\nFROM VIEW :  \nArtist name = " + songArtist.getArtistName() +
//                    "\nAlbum name = " + songArtist.getAlbumName() +
//                    "\nTrack number = " + songArtist.getTrack());
//        }

        dataSource.insertSong("fuck police", "GNU", "NOPE", 1);

        dataSource.close();
    }
}
