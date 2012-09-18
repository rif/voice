package edu.rif.voice;

/**
 * Insert the type's description here.
 * Creation date: (02.08.2001 17:35:40)
 * @author: Radu Fericean
 */
public class VoiceFrame extends javax.swing.JFrame {
	private javax.swing.JButton ivjJButton1 = null;
	private javax.swing.JPanel ivjJFrameContentPane = null;
	private javax.swing.JPanel ivjJPanel1 = null;
	private javax.swing.JTabbedPane ivjJTabbedPane = null;
	private FrontPanel frontPanel = new FrontPanel(this);
	private SettingsPanel settingsPanel = new SettingsPanel(this);
	private javax.swing.JTextArea ivjJTextArea1 = null;
	private ClientThread client = null;
	private ServerThread server = null;
/**
 * VoiceFrame constructor comment.
 */
public VoiceFrame() {
	super();
	initialize();
}
/**
 * VoiceFrame constructor comment.
 * @param title java.lang.String
 */
public VoiceFrame(String title) {
	super(title);
}
/**
 * Insert the method's description here.
 * Creation date: (03.08.2001 18:48:44)
 * @return edu.rif.voice.ClientThread
 */
public ClientThread getClient() {
	return client;
}
/**
 * Return the JButton1 property value.
 * @return javax.swing.JButton
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JButton getJButton1() {
	if (ivjJButton1 == null) {
		try {
			ivjJButton1 = new javax.swing.JButton();
			ivjJButton1.setName("JButton1");
			ivjJButton1.setText("JButton1");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);			
		}
	}
	return ivjJButton1;
}
/**
 * Return the JFrameContentPane property value.
 * @return javax.swing.JPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPanel getJFrameContentPane() {
	if (ivjJFrameContentPane == null) {
		try {
			ivjJFrameContentPane = new javax.swing.JPanel();
			ivjJFrameContentPane.setName("JFrameContentPane");
			ivjJFrameContentPane.setLayout(new java.awt.GridBagLayout());			

			java.awt.GridBagConstraints constraintsJPanel1 = new java.awt.GridBagConstraints();
			constraintsJPanel1.gridx = 1; constraintsJPanel1.gridy = 2;
constraintsJPanel1.gridheight = 0;
			constraintsJPanel1.fill = java.awt.GridBagConstraints.BOTH;
			constraintsJPanel1.weightx = 1.0;
			constraintsJPanel1.weighty = 1.0;
			constraintsJPanel1.ipadx = 525;
			getJFrameContentPane().add(getJPanel1(), constraintsJPanel1);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJFrameContentPane;
}
/**
 * Return the JPanel1 property value.
 * @return javax.swing.JPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPanel getJPanel1() {
	if (ivjJPanel1 == null) {
		try {
			ivjJPanel1 = new javax.swing.JPanel();
			ivjJPanel1.setName("JPanel1");
			ivjJPanel1.setLayout(new java.awt.GridBagLayout());

			java.awt.GridBagConstraints constraintsJButton1 = new java.awt.GridBagConstraints();
			constraintsJButton1.gridx = 1; constraintsJButton1.gridy = 1;
			constraintsJButton1.insets = new java.awt.Insets(4, 4, 4, 4);
			getJPanel1().add(getJButton1(), constraintsJButton1);

			java.awt.GridBagConstraints constraintsJTextArea1 = new java.awt.GridBagConstraints();
			constraintsJTextArea1.gridx = 0; constraintsJTextArea1.gridy = 1;
			constraintsJTextArea1.fill = java.awt.GridBagConstraints.BOTH;
			constraintsJTextArea1.weightx = 1.0;
			constraintsJTextArea1.weighty = 0.3;
			constraintsJTextArea1.insets = new java.awt.Insets(4, 4, 4, 4);
			getJPanel1().add(getJTextArea1(), constraintsJTextArea1);

			java.awt.GridBagConstraints constraintsJTabbedPane = new java.awt.GridBagConstraints();
			constraintsJTabbedPane.gridx = 0; constraintsJTabbedPane.gridy = 0;
			constraintsJTabbedPane.gridwidth = 2;
			constraintsJTabbedPane.fill = java.awt.GridBagConstraints.BOTH;
			constraintsJTabbedPane.weightx = 1.0;
			constraintsJTabbedPane.weighty = 1.0;
			constraintsJTabbedPane.insets = new java.awt.Insets(4, 4, 4, 4);
			getJPanel1().add(getJTabbedPane(), constraintsJTabbedPane);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJPanel1;
}
/**
 * Return the JTabbedPane1 property value.
 * @return javax.swing.JTabbedPane
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JTabbedPane getJTabbedPane() {
	if (ivjJTabbedPane == null) {
		try {
			ivjJTabbedPane = new javax.swing.JTabbedPane();
			ivjJTabbedPane.setName("JTabbedPane");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJTabbedPane;
}
/**
 * Return the JTextArea1 property value.
 * @return javax.swing.JTextArea
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JTextArea getJTextArea1() {
	if (ivjJTextArea1 == null) {
		try {
			ivjJTextArea1 = new javax.swing.JTextArea();
			ivjJTextArea1.setName("JTextArea1");
			ivjJTextArea1.setEditable(false);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJTextArea1;
}
/**
 * Insert the method's description here.
 * Creation date: (03.08.2001 18:48:44)
 * @return edu.rif.voice.ServerThread
 */
public ServerThread getServer() {
	return server;
}
/**
 * Called whenever the part throws an exception.
 * @param exception java.lang.Throwable
 */
private void handleException(java.lang.Throwable exception) {

	/* Uncomment the following lines to print uncaught exceptions to stdout */
	// System.out.println("--------- UNCAUGHT EXCEPTION ---------");
	// exception.printStackTrace(System.out);
}
/**
 * Initialize the class.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initialize() {
	try {
		// user code begin {1}
		// user code end
		setName("VoiceFrame");
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setSize(525, 325);
		setTitle("Voice IP");
		setContentPane(getJFrameContentPane());
	} catch (java.lang.Throwable ivjExc) {
		handleException(ivjExc);
	}
	// user code begin {2}
	getJTabbedPane().addTab("Front Panel",frontPanel);
	getJTabbedPane().addTab("Settings Panel",settingsPanel);
	client = new ClientThread(null);
	server = new ServerThread();
	settingsPanel.init(server.getVolCtrl());
	// user code end
}
/**
 * main entrypoint - starts the part when it is run as an application
 * @param args java.lang.String[]
 */
public static void main(java.lang.String[] args) {
	try {
		VoiceFrame aVoiceFrame;
		aVoiceFrame = new VoiceFrame();
		aVoiceFrame.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.exit(0);
			};
		});
		aVoiceFrame.show();
		java.awt.Insets insets = aVoiceFrame.getInsets();
		aVoiceFrame.setSize(aVoiceFrame.getWidth() + insets.left + insets.right, aVoiceFrame.getHeight() + insets.top + insets.bottom);
		aVoiceFrame.setVisible(true);
	} catch (Throwable exception) {
		System.err.println("Exception occurred in main() of javax.swing.JFrame");
		exception.printStackTrace(System.out);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (03.08.2001 18:48:44)
 * @param newClient edu.rif.voice.ClientThread
 */
public void setClient(ClientThread newClient) {
	client = newClient;
}
/**
 * Insert the method's description here.
 * Creation date: (03.08.2001 18:48:44)
 * @param newServer edu.rif.voice.ServerThread
 */
public void setServer(ServerThread newServer) {
	server = newServer;
}
}
