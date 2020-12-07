package RadioModel;

import java.io.*;

public class Song {
    private byte[] songData;
    private String name;

    public Song(String path, String name){
        this.songData = songToData(path);
        this.name = name;
    }

    //Constructor for the musics without a name ;)
    public Song(String path){
        this(path,"Untitled");
    }

    public byte[] getSongData() {
        return songData;
    }

    public String getName() {
        return name;
    }

    private byte[] songToData(String path) {
        try {
            //Creating the input stream from the giving path
            DataInputStream musicStream = new DataInputStream(new FileInputStream(new File(path)));
            //Reading the data from the Input Stream and convert it into a Byte Array
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = musicStream.read(buffer)) > 0) {
                baos.write(buffer, 0, bytesRead);
            }
            //Returning the music's data in binary format
            return baos.toByteArray();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
            return null;
        }
    }
}
