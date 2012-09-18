package edu.rif.voice.applet;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.channels.DatagramChannel;

import javax.swing.JButton;
import javax.swing.JTextField;

import edu.rif.voice.ClientThread;
import edu.rif.voice.ServerThread;

public class SimpleApplet extends Applet {
	private static final String START_STRING = "Start Talking!";
	private static final String STOP_STRING = "Stop Talking!";
	private JTextField ipTextField = null;
	private JButton startButton = null;

	public SimpleApplet() {

		guiInitialize();
	}

	private void guiInitialize() {
		ipTextField = new JTextField();
		startButton = new JButton(START_STRING);
		startButton.addActionListener(new ActionListener() {
			private ClientThread clientThread = null;
			private ServerThread serverThread = null;

			public void actionPerformed(ActionEvent e) {
				DatagramChannel channel = null;
				if (startButton.getText().equals(START_STRING)) {
					startButton.setText(STOP_STRING);
					try {
						channel = DatagramChannel.open();
						clientThread = new ClientThread(channel, ipTextField
								.getText());
						serverThread = new ServerThread(channel);
					} catch (IOException ioe) {
						ioe.printStackTrace();
					}
				} else {
					startButton.setText(START_STRING);
					clientThread.setStopped(true);
					serverThread.setStopped(true);
					try {
						channel.disconnect();
					} catch (IOException ioe) {
						ioe.printStackTrace();
					}
				}
			}
		});

		setLayout(new BorderLayout());
		add(ipTextField, BorderLayout.CENTER);
		add(startButton, BorderLayout.SOUTH);
		setSize(100, 40);
	}

	@Override
	public void destroy() {
		System.out.println("Destroying applet...");
	}

	@Override
	public void init() {
		System.out.println("Initializing applet...");
	}

	@Override
	public void stop() {
		System.out.println("Stopping applet...");
	}

}
