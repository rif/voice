package edu.rif.voice.gui;

import edu.rif.voice.ClientThread;
import edu.rif.voice.ServerThread;

public class FrontPanel extends javax.swing.JPanel {
	private javax.swing.JLabel ivjJLabel1 = null;
	private javax.swing.JTextField ivjJTextField1 = null;
	private VoiceFrame mainFrame = null;

	class IvjEventHandler implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent e) {
			if (e.getSource() == FrontPanel.this.getStartButton())
				connEtoC1(e);
		};
	};

	IvjEventHandler ivjEventHandler = new IvjEventHandler();
	private javax.swing.JButton ivjStartButton = null;

	public FrontPanel() {
		super();
		initialize();
	}

	public FrontPanel(VoiceFrame main) {
		super();
		initialize();
		mainFrame = main;
	}

	public FrontPanel(java.awt.LayoutManager layout) {
		super(layout);
	}

	public FrontPanel(java.awt.LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

	public FrontPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	private void connEtoC1(java.awt.event.ActionEvent arg1) {
		this.startButton_ActionPerformed(arg1);
	}

	private javax.swing.JLabel getJLabel1() {
		if (ivjJLabel1 == null) {
			ivjJLabel1 = new javax.swing.JLabel();
			ivjJLabel1.setName("JLabel1");
			ivjJLabel1.setText("Interlocutor Address");
		}
		return ivjJLabel1;
	}

	javax.swing.JTextField getJTextField1() {
		if (ivjJTextField1 == null) {
			ivjJTextField1 = new javax.swing.JTextField();
			ivjJTextField1.setName("JTextField1");
			ivjJTextField1.setColumns(20);
		}
		return ivjJTextField1;
	}

	private javax.swing.JButton getStartButton() {
		if (ivjStartButton == null) {
			ivjStartButton = new javax.swing.JButton();
			ivjStartButton.setName("StartButton");
			ivjStartButton.setText("Start");
		}
		return ivjStartButton;
	}

	private void initConnections() {
		getStartButton().addActionListener(ivjEventHandler);
	}

	private void initialize() {
		setName("FrontPanel");
		setLayout(new java.awt.GridBagLayout());
		setSize(576, 257);

		java.awt.GridBagConstraints constraintsJLabel1 = new java.awt.GridBagConstraints();
		constraintsJLabel1.gridx = 0;
		constraintsJLabel1.gridy = 0;
		constraintsJLabel1.insets = new java.awt.Insets(4, 4, 4, 4);
		add(getJLabel1(), constraintsJLabel1);

		java.awt.GridBagConstraints constraintsJTextField1 = new java.awt.GridBagConstraints();
		constraintsJTextField1.gridx = 0;
		constraintsJTextField1.gridy = 1;
		constraintsJTextField1.weightx = 1.0;
		constraintsJTextField1.insets = new java.awt.Insets(4, 4, 4, 4);
		add(getJTextField1(), constraintsJTextField1);

		java.awt.GridBagConstraints constraintsStartButton = new java.awt.GridBagConstraints();
		constraintsStartButton.gridx = 0;
		constraintsStartButton.gridy = 2;
		constraintsStartButton.insets = new java.awt.Insets(4, 4, 4, 4);
		add(getStartButton(), constraintsStartButton);
		initConnections();
	}

	public void startButton_ActionPerformed(
			java.awt.event.ActionEvent actionEvent) {
		mainFrame.getClient().setStopped(true);
		mainFrame.getServer().setStopped(true);
		mainFrame.setClient(new ClientThread(getJTextField1().getText()));
		mainFrame.setServer(new ServerThread());
		return;
	}
}
