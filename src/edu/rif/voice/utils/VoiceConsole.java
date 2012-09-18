package edu.rif.voice.utils;

import edu.rif.voice.ClientThread;
import edu.rif.voice.ServerThread;

public class VoiceConsole {

	public static void main(String[] args) {
		new ClientThread(args[0]);
		new ServerThread();
	}
}