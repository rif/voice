package edu.rif.voice;

import java.io.IOException;

public abstract class DefaultThread extends Thread {
	static final int INPORT = 1711;
	private boolean stopped = false;

	public void setStopped(boolean state) {
		stopped = state;
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
		cleanup();
	}

	abstract protected void infiniteCicle() throws IOException;

	abstract protected void cleanup();
}
