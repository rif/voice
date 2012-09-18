package edu.rif.voice;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class ServerThread extends DefaultThread {
	private DatagramSocket outSocket = null;
	private DefaultLine echoLine = null;
	private Converter converter = null;
	private ByteBuffer in = null;
	private DatagramChannel channel = null;

	public ServerThread(DatagramChannel channel) {
		super();
		converter = new PCMConverter();
		in = ByteBuffer.allocate(8192);
		this.channel = channel;
		
			System.out.println("Server started");
			//SocketAddress address = new InetSocketAddress(INPORT);
			//DatagramSocket socket = channel.socket();
			//socket.bind(address);
			echoLine = new EchoLine();
			start();
		
	}

	protected void infiniteCicle() throws IOException {
		in.clear();
		channel.receive(in);
		byte[] test = converter.convertReceivedBytes(in.array());
		echoLine.write(test, 0, test.length);
	}

	protected void cleanup() {
		outSocket.close();
		echoLine.close();
	}

	public DefaultLine getEchoLine() {
		return echoLine;
	}

	public javax.sound.sampled.FloatControl getVolCtrl() {
		return echoLine.getVolumeControl();
	}
}