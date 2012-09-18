package edu.rif.voice;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.DatagramPacket;


class ServerThread extends Thread implements DefaultThread {
	private DatagramSocket outSocket = null;
	private byte[] buf = new byte[BUFFER];
	private DatagramPacket dp = null;
	private DefaultLine echoLine = null;

	
	public ServerThread(){
		super();
		try {
			System.out.println("Server started");
			outSocket = new DatagramSocket(INPORT);
			dp = new DatagramPacket(buf, buf.length);
			echoLine = new EchoLine();
			start();
		} catch(SocketException e) {
	      	System.err.println("Can't open outSocket!");     		
		}
	}
	
	void infiniteCicle() throws IOException {
			outSocket.receive(dp);
			Converter converter = new PCMConverter();
   			byte[] test = converter.convertReceivedBytes(dp.getData());
   			//System.out.println ("Received: " + test.length + " BUFFER: " + BUFFER);
   			//byte[] test = dp.getData();
   			echoLine.write(test,0,test.length);
	}

public void run() {
	while (!stopped) {
		try {
			infiniteCicle();
		} catch (IOException e) {
			System.err.println("Communication error");
			e.printStackTrace();
		}
	}
	outSocket.close();
	echoLine = null;
}

	private boolean stopped = false;

/**
 * Insert the method's description here.
 * Creation date: (03.08.2001 19:28:47)
 * @return edu.rif.voice.DefaultLine
 */
public DefaultLine getEchoLine() {
	return echoLine;
}

/**
 * Insert the method's description here.
 * Creation date: (03.08.2001 19:39:32)
 * @return javax.sound.sampled.FloatControl
 */
public javax.sound.sampled.FloatControl getVolCtrl() {
	return echoLine.getVolumeControl();
}

/**
 * Insert the method's description here.
 * Creation date: (03.08.2001 18:44:36)
 * @param state boolean
 */
public void setStopped(boolean state) {
	stopped = state;
}
}