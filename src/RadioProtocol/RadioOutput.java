package RadioProtocol;

import RadioModel.ModelObserver;
import RadioModel.Playlist;
import RadioModel.RadioModel;
import RadioModel.Song;
import Utils.StringPadding;
import java.io.*;



public class RadioOutput implements ShoutProtocol, ModelObserver {
    private PrintWriter os;
    private OutputStream streamClient;
    private Playlist radioPlaylist = RadioModel.getStream();
    protected static final int OUTPUT_BUFFER_SIZE = 64192;

    public RadioOutput(OutputStream out) {
        this.streamClient = out;
        os = new PrintWriter(streamClient, true);
    }

    public void sendHeader(boolean metaRequested){
        String meta = (metaRequested) ? "icy-metaint: 64192\r\n" :"";
        os.println("HTTP/1.0 200 OK\r\n"
                +"icy-notice1:  Welcome to Internet Radio"
                +"icy-name: Internet Radio\r\n"
                + "icy-genre: Pop\r\n"
                + "icy-url: http://localhost:1234\r\n"
                + "content-type: audio/mpeg\r\n"
                + "icy-pub: 1\r\n"
                + meta
                + "icy-br: 128\r\n"
                + "\r\n");
    }

    public byte[] sendTitle(String title,String url) {

        String header;
        String heading ="StreamTitle='"+title+"';StreamUrl='"+url+"';";
        byte [] headingBytes = heading.getBytes();
        int NumberOfBlocks = ((headingBytes.length - 1) / 16) + 1;
        int toPad = NumberOfBlocks*16 - headingBytes.length;
        header =  NumberOfBlocks + heading;
        String finalStr = header + StringPadding.padding(toPad);
        return finalStr.getBytes();
    }
    public void sendStream(Boolean meta) throws IOException {

        for(Song song : radioPlaylist.getSongs()){
            byte[] buffer = new byte[OUTPUT_BUFFER_SIZE];

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(song.getSongData());
            int count,countMeta=-1;
            while((count = byteArrayInputStream.read(buffer)) != -1){
                System.out.println(count);
                if(meta) {
                    if(count >= OUTPUT_BUFFER_SIZE ) {
                        streamClient.write(buffer, 0,OUTPUT_BUFFER_SIZE);
                        if(countMeta<3) {
                            streamClient.write(sendTitle(song.getName(),"musique"));
                            countMeta++;
                        }else {
                            byte b  = 0x00 ;
                            streamClient.write(b);
                        }

                    } else {
                        streamClient.write(buffer, 0, count );
                    }
                }else {
                    streamClient.write(buffer, 0, count);
                }

            }
            streamClient.flush();
        }
        System.out.println("fini");
    }

    //  }

    @Override
    public void update(Playlist playlist) {
        radioPlaylist = playlist;
    }
}
