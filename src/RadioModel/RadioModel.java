package RadioModel;

import java.util.ArrayList;

public class RadioModel {

    private static Playlist playlist = new Playlist();
    private static ArrayList<ModelObserver> observers = new ArrayList<>();

    public static synchronized void ajouterStream(Song song){
        playlist.addSong(song);
        notifyObservers();
    }
    public static synchronized void supprimerStream(int index){
        playlist.deleteSong(index);
        notifyObservers();
    }
    public static synchronized void deplacerStream(int song1, int song2){
        playlist.swapSong(song1,song2);
    }

    public static synchronized Playlist getStream(){
        return playlist;
    }

    //Observing and notifying observers methods
    public static void registerObserver(ModelObserver observer){
        observers.add(observer);
    }

    public void unRegisterObserver(ModelObserver observer){
        observers.add(observer);
    }

    public static void notifyObservers(){
        for(ModelObserver observer : observers){
            observer.update(playlist);
        }
    }

}
