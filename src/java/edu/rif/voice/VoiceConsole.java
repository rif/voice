package edu.rif.voice;

public class VoiceConsole {

	public static void main(String[] args) {
		ClientThread client = new ClientThread(args[0]);
		ServerThread server = new ServerThread();
	}
}