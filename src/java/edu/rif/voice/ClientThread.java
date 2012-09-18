package edu.rif.voice;


import java.net.InetAddress;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.DatagramPacket;
import java.io.IOException;


class ClientThread extends Thread implements DefaultThread {
    private InetAddress hostAddress = null;
    private DatagramSocket inSocket = null;
    private DefaultLine recLine = null;
    private byte[] buf = new byte[BUFFER];
    byte[] abBuffer = new byte[BUFFER];

    public ClientThread(String host) {        
        recLine = new RecordLine();               
        try {
            inSocket = new DatagramSocket();

            hostAddress = InetAddress.getByName(host);            
            System.out.println("Client starting");
            start();             
        }
        catch (SocketException e) {
            System.err.println("Can't open inSocket!");
            System.exit(1);
        }
        catch (UnknownHostException uhe) {
            System.err.println("Cannot find host");
            System.exit(1);
        }
    }
    void infiniteCicle() throws IOException {
        abBuffer = new byte[BUFFER];        
        int nBytesRead = recLine.read(abBuffer, 0, BUFFER);        

        //System.out.println ("Sended: " + buffy.length + " BUFFER: " + BUFFER);
        inSocket.send(new DatagramPacket(abBuffer, abBuffer.length, hostAddress, INPORT));
    }

    public void run() {
        while (!stopped) {
            try {
                infiniteCicle();
            }
            catch (IOException e) {
                System.err.println("Communication error");
                e.printStackTrace();
            }
        }
        inSocket.close();
	
        recLine = null;
    }

    private boolean stopped = false;

    /**
     * Insert the method's description here.
     * Creation date: (03.08.2001 18:42:36)
     * @param state boolean
     */
    public void setStopped(boolean state) {
        stopped = state;
    }
}
