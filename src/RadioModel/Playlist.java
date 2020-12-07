package RadioModel;

import java.util.ArrayList;
import java.util.Collections;

public class Playlist {
    private ArrayList<Song> songs;

    public Playlist(){
        songs = new ArrayList<>();
    }
    public Playlist(Song song){
        songs = new ArrayList<>();
        songs.add(song);
    }
    public void addSong(Song song){
        songs.add(song);
    }
    public void deleteSong(int index){
        songs.remove(index);
    }
    public void swapSong(int song1, int song2){
        Collections.swap(songs, song1, song2);
    }
    public ArrayList<Song> getSongs() {
        return songs;
    }
}
