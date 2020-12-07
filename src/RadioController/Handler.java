package RadioController;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

import RadioProtocol.RadioInput;
import RadioProtocol.RadioOutput;
import RadioProtocol.ShoutProtocol;



public class Handler extends Thread  implements ShoutProtocol{

	private final Socket s;
	private RadioOutput radioOutput;
	private boolean stop = false;
	private static final int CONNECTION_TIMEOUT = 5000;
	private static final int SOCKET_BUFFER_SIZE = 65536;

	public Handler(Socket s) throws SocketException {
		this.s = s;
		s.setSoTimeout(CONNECTION_TIMEOUT);
		s.setSendBufferSize(SOCKET_BUFFER_SIZE);
		this.setDaemon(true);
		this.setPriority(6);
	}

	public void run() {
		try  {
			radioOutput = new RadioOutput(s.getOutputStream());
			RadioInput radioInput = new RadioInput(s.getInputStream(), this);
			radioInput.DoRun();
		} catch (IOException ex) {
			if (!stop) {
				finish();
			}
		}
	}

	public void sendHeader(boolean meta) {
		radioOutput.sendHeader(meta);
	}

	public void sendStream(boolean meta) throws IOException {
		radioOutput.sendStream(meta);

	}

	private synchronized void finish(){
		if (!stop) {
			stop = true;
			try {
				s.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void shutdownRequested() {
		System.out.println("An user has left the streaming");
	}
}
