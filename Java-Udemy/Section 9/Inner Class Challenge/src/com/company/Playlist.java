package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Playlist extends Album {

    private LinkedList<Song> playlist;

    public static int playNext(LinkedList<Song> playlist,int position){
        ListIterator<Song>listIterator = playlist.listIterator();
        if(playlist.size()==position){
            System.out.println("No song in playlist");
            return position;
        }else{
            System.out.println("Now Playing " + listIterator.next().toString());
            return position+=1;
        }
    }

    public static int playPrevious(LinkedList<Song> playlist,int position){
        ListIterator<Song>listIterator = playlist.listIterator();
        if(playlist.size()==0){
            System.out.println("No song in playlist");
            return position;
        }else{
            System.out.println("Now Playing " + listIterator.previous().toString());
            return position-=1;
        }
    }

    public static int replaySong(LinkedList<Song> playlist,int position){
        ListIterator<Song>listIterator = playlist.listIterator();
        if(playlist.size()==0){
            System.out.println("No song in playlist");
            return position;
        }
        System.out.println("Now Playing " + listIterator.toString());
        return position;
    }

    public static void printAllSongs(ArrayList<Song>print){
        ListIterator<Song>listIterator = print.listIterator();
        for (int i = 0;i<print.size();i++){
            System.out.println(print.get(i).printSong());
        }
    }

    public void printMenu(){
        System.out.println("0 - to print menu");
        System.out.println("1 - to play the next song");
        System.out.println("2 - to play the previous song");
        System.out.println("3 - to replay the song to a playlist");
        System.out.println("4 - to add a song to a playlist");
        System.out.println("5 - to remove a song from a playlist");
        System.out.println("6 - to exit");
    }

}
