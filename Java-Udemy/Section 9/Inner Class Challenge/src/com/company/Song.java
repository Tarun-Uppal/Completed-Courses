package com.company;

public class Song {
    private String SongName ;
    private Double Duration ;

    public Song(String songName, double duration) {
        SongName = songName;
        Duration = duration;
    }

    public String getSongName() {
        return SongName;
    }

    public String printSong(){
        return "Song: " + SongName + " Duration: " + Duration;
    }

    public String toString(){
        return this.SongName + ": " + this.Duration;
    }
}
