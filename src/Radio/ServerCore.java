package Radio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Date;
import RadioController.Handler;

public class ServerCore extends Thread{

    private int port;
    private boolean stop = false;

    ServerCore(int port){
        this.port = port;
        this.start();
        System.out.println("Server Started at port : "+port);
    }

    public void run() {
        try (ServerSocket ss = new ServerSocket(port)) {
            ss.setSoTimeout(10000);
            while (!stop) {
                try {
                    Socket s = ss.accept();
                    new Thread(new Handler(s)).start();
                } catch (SocketTimeoutException ignored) {

                }
            }
        } catch (IOException e) {
            System.out.println("Could not bind port " + port);
        }
    }

    public synchronized void finish() {
        stop = true;
        System.out.println("Server terminated at "+new Date());
    }
}