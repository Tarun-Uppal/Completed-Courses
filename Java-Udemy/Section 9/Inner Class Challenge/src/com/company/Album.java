package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;

    public Album() {

    }

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
    }

    public boolean addSongToPlaylist(String songName,LinkedList<Song> playlist){
        int position = SongList.findSong(songName,SongList.song);
        if((position >= 0)&&(position<=SongList.song.size())){
            playlist.add(SongList.song.get(position));
            return true;
        }
        return false;
    }

    public boolean removeSongFromPlaylist(String songName,LinkedList<Song> playlist){
        int position = SongList.findSong(songName,SongList.song);
        if((position >= 0)&&(position < SongList.song.size())){
            playlist.remove(SongList.song.get(position));
            return true;
        }
        return false;
    }
    public void addSong(String songName, double duration){
        if(SongList.findSong(songName,SongList.song)>=0){
            System.out.println("song already exists");
        }else{
            SongList.song.add(new Song(songName,duration));
        }
   }

    public void removeSong(String songName,double duration){
        if(SongList.findSong(songName,SongList.song)<0){
            System.out.println("Album does not exist");
        }else{
           SongList.song.add(new Song(songName,duration));
        }
    }


    public boolean printAlbum() {
        System.out.println("Album: " + name);
        System.out.println("Songs: ");
        for (int i = 0; i < SongList.song.size(); ++i) {
            System.out.println(SongList.song.get(i));
        }
        return false;
    }




    private static class SongList{
        public static ArrayList<Song> song = new ArrayList<Song>();



        public static int findSong(String songName,ArrayList<Song>song){
            return song.indexOf(songName);
        }
    }

}
