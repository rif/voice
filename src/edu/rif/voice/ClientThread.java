package edu.rif.voice;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class ClientThread extends DefaultThread {
	private DefaultLine recLine = null;
	private ByteBuffer out = null;
	// byte[] abBuffer = new byte[DefaultLine.BUFFER];
	private DatagramChannel channel = null;

	public ClientThread(DatagramChannel channel, String host) {
		recLine = new RecordLine();
		this.channel = channel;
		out = ByteBuffer.allocate(DefaultLine.BUFFER);// 8
		try {
			SocketAddress remoteAddress = new InetSocketAddress(host, 37);
			channel.connect(remoteAddress);
			System.out.println("Client starting");
			start();
		} catch (IOException e) {
			System.err.println("Can't open inSocket!");
			System.exit(1);
		}
	}

	protected void infiniteCicle() throws IOException {
		byte[] abBuffer = new byte[DefaultLine.BUFFER];
		recLine.read(abBuffer, 0, DefaultLine.BUFFER);
		out.clear();
		out.put(abBuffer);
		out.flip();

		channel.write(out);
	}

	protected void cleanup() {
		recLine.close();
	}
}
