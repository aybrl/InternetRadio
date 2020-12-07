package RadioProtocol;

import RadioController.Handler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class RadioInput {
	private InputStream in;
	private Handler handler;
	private boolean stop = false;
	private Map<String, String> header = new  HashMap<>();

	public RadioInput(InputStream in, Handler handler){
		this.in = in;
		this.handler = handler;
	}
	public void DoRun() throws IOException {
		try (BufferedReader is = new BufferedReader(new InputStreamReader(in))) {
			String line;
			while (!stop) {
				line = is.readLine();
				if(line == null || line.equals("\r\n\r\n")){
					handler.shutdownRequested();
					break;
				}

				if(line.length() == 0) {
					if(header.get("Icy-MetaData") == null) {
						handler.sendHeader(false);
						handler.sendStream(false);
					} else {
						handler.sendHeader(true);
						handler.sendStream(true);
					}


				}
				String[] parts = line.split(":");
				if(parts.length != 1) {
					header.put(parts[0],parts[1]);
				}
				System.out.println(line);
			}
		}
	}
}


