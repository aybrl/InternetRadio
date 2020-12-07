package DisplayServer;

import Radio.Radio;
import RadioModel.*;
import java.io.IOException;
import java.util.ArrayList;

public class DisplayController {

    void addSong(String string){
        RadioModel.ajouterStream(new Song(string));
        System.out.println(string);
    }
    void deleteSong(int index){
        RadioModel.supprimerStream(index);
    }
    public void upMoveSong(int index){
        RadioModel.deplacerStream(index, index+1);
    }
    void stopServer(){
        Radio.setRadioState(Radio.state.Stopped);
        Radio.closeRadio();
    }
    void runServer(String name) {
        Radio.newRadio(name);
        Radio.setRadioState(Radio.state.Running);
    }

}
