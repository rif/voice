package edu.rif.voice.gui;

import edu.rif.voice.ClientThread;
import edu.rif.voice.ServerThread;

public class VoiceFrame extends javax.swing.JFrame {
	private javax.swing.JButton ivjJButton1 = null;
	private javax.swing.JPanel ivjJFrameContentPane = null;
	private javax.swing.JPanel ivjJPanel1 = null;
	private javax.swing.JTabbedPane ivjJTabbedPane = null;
	private FrontPanel frontPanel = new FrontPanel(this);
	//private SettingsPanel settingsPanel = new SettingsPanel(this);
	private javax.swing.JTextArea ivjJTextArea1 = null;
	private ClientThread client = null;
	private ServerThread server = null;

	public VoiceFrame() {
		super();
		initialize();
	}

	public VoiceFrame(String title) {
		super(title);
	}

	public ClientThread getClient() {
		return client;
	}

	private javax.swing.JButton getJButton1() {
		if (ivjJButton1 == null) {
			ivjJButton1 = new javax.swing.JButton();
			ivjJButton1.setName("JButton1");
			ivjJButton1.setText("JButton1");
		}
		return ivjJButton1;
	}

	private javax.swing.JPanel getJFrameContentPane() {
		if (ivjJFrameContentPane == null) {
			ivjJFrameContentPane = new javax.swing.JPanel();
			ivjJFrameContentPane.setName("JFrameContentPane");
			ivjJFrameContentPane.setLayout(new java.awt.GridBagLayout());

			java.awt.GridBagConstraints constraintsJPanel1 = new java.awt.GridBagConstraints();
			constraintsJPanel1.gridx = 1;
			constraintsJPanel1.gridy = 2;
			constraintsJPanel1.gridheight = 0;
			constraintsJPanel1.fill = java.awt.GridBagConstraints.BOTH;
			constraintsJPanel1.weightx = 1.0;
			constraintsJPanel1.weighty = 1.0;
			constraintsJPanel1.ipadx = 525;
			getJFrameContentPane().add(getJPanel1(), constraintsJPanel1);
		}
		return ivjJFrameContentPane;
	}

	private javax.swing.JPanel getJPanel1() {
		if (ivjJPanel1 == null) {
			ivjJPanel1 = new javax.swing.JPanel();
			ivjJPanel1.setName("JPanel1");
			ivjJPanel1.setLayout(new java.awt.GridBagLayout());

			java.awt.GridBagConstraints constraintsJButton1 = new java.awt.GridBagConstraints();
			constraintsJButton1.gridx = 1;
			constraintsJButton1.gridy = 1;
			constraintsJButton1.insets = new java.awt.Insets(4, 4, 4, 4);
			getJPanel1().add(getJButton1(), constraintsJButton1);

			java.awt.GridBagConstraints constraintsJTextArea1 = new java.awt.GridBagConstraints();
			constraintsJTextArea1.gridx = 0;
			constraintsJTextArea1.gridy = 1;
			constraintsJTextArea1.fill = java.awt.GridBagConstraints.BOTH;
			constraintsJTextArea1.weightx = 1.0;
			constraintsJTextArea1.weighty = 0.3;
			constraintsJTextArea1.insets = new java.awt.Insets(4, 4, 4, 4);
			getJPanel1().add(getJTextArea1(), constraintsJTextArea1);

			java.awt.GridBagConstraints constraintsJTabbedPane = new java.awt.GridBagConstraints();
			constraintsJTabbedPane.gridx = 0;
			constraintsJTabbedPane.gridy = 0;
			constraintsJTabbedPane.gridwidth = 2;
			constraintsJTabbedPane.fill = java.awt.GridBagConstraints.BOTH;
			constraintsJTabbedPane.weightx = 1.0;
			constraintsJTabbedPane.weighty = 1.0;
			constraintsJTabbedPane.insets = new java.awt.Insets(4, 4, 4, 4);
			getJPanel1().add(getJTabbedPane(), constraintsJTabbedPane);
		}
		return ivjJPanel1;
	}

	private javax.swing.JTabbedPane getJTabbedPane() {
		if (ivjJTabbedPane == null) {
			ivjJTabbedPane = new javax.swing.JTabbedPane();
			ivjJTabbedPane.setName("JTabbedPane");
		}
		return ivjJTabbedPane;
	}

	private javax.swing.JTextArea getJTextArea1() {
		if (ivjJTextArea1 == null) {
			ivjJTextArea1 = new javax.swing.JTextArea();
			ivjJTextArea1.setName("JTextArea1");
			ivjJTextArea1.setEditable(false);
		}
		return ivjJTextArea1;
	}

	public ServerThread getServer() {
		return server;
	}

	private void initialize() {
		setName("VoiceFrame");
		setSize(525, 325);
		setTitle("Voice IP");
		setContentPane(getJFrameContentPane());
		getJTabbedPane().addTab("Front Panel", frontPanel);
		//getJTabbedPane().addTab("Settings Panel", settingsPanel);
		client = new ClientThread(frontPanel.getJTextField1().getText());
		server = new ServerThread();
		//settingsPanel.init(server.getVolCtrl());
	}

	public static void main(java.lang.String[] args) {
		VoiceFrame aVoiceFrame;
		aVoiceFrame = new VoiceFrame();
		aVoiceFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		java.awt.Insets insets = aVoiceFrame.getInsets();
		aVoiceFrame.setSize(
				aVoiceFrame.getWidth() + insets.left + insets.right,
				aVoiceFrame.getHeight() + insets.top + insets.bottom);
		aVoiceFrame.setVisible(true);

	}

	public void setClient(ClientThread newClient) {
		client = newClient;
	}

	public void setServer(ServerThread newServer) {
		server = newServer;
	}
}
