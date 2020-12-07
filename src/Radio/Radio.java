package Radio;

import DisplayServer.Display;

import java.io.IOException;

public class Radio {
    private static final int PORT = 1234;
    private static String nomRadio = "Radio Internet";
    private static String url = "http://localhost:"+PORT;
    private static int listeners = 0;
    private static ServerCore serverCore;
    public enum state {
        Running, Stopped
    }
    private static state radioState = state.Stopped;

    private static void newRadio(String name, String url) {
        if(name != null && !name.equals("")){
            Radio.nomRadio = name;
        }
        if(url != null && !url.equals("")){
            Radio.url = url;
        }
        serverCore = new ServerCore(PORT);
    }
    public static void newRadio(String name)  {
        newRadio(name, url);
    }

    public static int getListeners() {
        return listeners;
    }

    public static String getNomRadio() {
        return nomRadio;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String address){
        url = address;
    }

    public static state getRadioState() {
        return radioState;
    }

    public static void incListeners() {
        Radio.listeners++;
        Display.updateVisitors();
    }
    public static void decListeners(){
        Radio.listeners--;
        Display.updateVisitors();
    }

    public static void setRadioState(state radioState) {
        Radio.radioState = radioState;
    }

    public static void closeRadio() {
        serverCore.finish();
    }
}
