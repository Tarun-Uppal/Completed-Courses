package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Album {
    public ArrayList<Song> song = new ArrayList<Song>();
    private String name;
    private String artist;

    public Album() {

    }

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
    }

    public void addSong(String songName, double duration){
        if(findSong(songName)>=0){
            System.out.println("song already exists");
        }else{
            this.song.add(new Song(songName,duration));
        }
   }

    public void removeSong(String songName,double duration){
        if(findSong(songName)<0){
            System.out.println("Album does not exist");
        }else{
           this.song.add(new Song(songName,duration));
        }
    }

   public int findSong(String songName){
      return song.indexOf(songName);
   }

    public boolean printAlbum() {
        System.out.println("Album: " + name);
        System.out.println("Songs: ");
        for (int i = 0; i < song.size(); ++i) {
            System.out.println(song.get(i));
        }
        return false;
    }

    public boolean addSongToPlaylist(String songName,LinkedList<Song> playlist){
        int position = findSong(songName);
        if((position >= 0)&&(position<=song.size())){
            playlist.add(this.song.get(position));
            return true;
        }
        return false;
    }

    public boolean removeSongFromPlaylist(String songName,LinkedList<Song> playlist){
        int position = findSong(songName);
        if((position >= 0)&&(position<=song.size())){
            playlist.remove(this.song.get(position));
            return true;
        }
        return false;
    }


}
