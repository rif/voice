package edu.rif.voice;

/**
 * Insert the type's description here.
 * Creation date: (02.08.2001 17:49:12)
 * @author: Radu Fericean
 */
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
/**
 * FrontPanel constructor comment.
 */
public FrontPanel() {
	super();
	initialize();
}
/**
 * FrontPanel constructor comment.
 */
public FrontPanel(VoiceFrame main) {
	super();
	initialize();
	mainFrame = main;
}
/**
 * FrontPanel constructor comment.
 * @param layout java.awt.LayoutManager
 */
public FrontPanel(java.awt.LayoutManager layout) {
	super(layout);
}
/**
 * FrontPanel constructor comment.
 * @param layout java.awt.LayoutManager
 * @param isDoubleBuffered boolean
 */
public FrontPanel(java.awt.LayoutManager layout, boolean isDoubleBuffered) {
	super(layout, isDoubleBuffered);
}
/**
 * FrontPanel constructor comment.
 * @param isDoubleBuffered boolean
 */
public FrontPanel(boolean isDoubleBuffered) {
	super(isDoubleBuffered);
}
/**
 * connEtoC1:  (StartButton.action.actionPerformed(java.awt.event.ActionEvent) --> FrontPanel.startButton_ActionPerformed(Ljava.awt.event.ActionEvent;)V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC1(java.awt.event.ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.startButton_ActionPerformed(arg1);
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * Return the JLabel1 property value.
 * @return javax.swing.JLabel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JLabel getJLabel1() {
	if (ivjJLabel1 == null) {
		try {
			ivjJLabel1 = new javax.swing.JLabel();
			ivjJLabel1.setName("JLabel1");
			ivjJLabel1.setText("Interlocutor Address");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJLabel1;
}
/**
 * Return the JTextField1 property value.
 * @return javax.swing.JTextField
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JTextField getJTextField1() {
	if (ivjJTextField1 == null) {
		try {
			ivjJTextField1 = new javax.swing.JTextField();
			ivjJTextField1.setName("JTextField1");
			ivjJTextField1.setColumns(20);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJTextField1;
}
/**
 * Return the StartButton property value.
 * @return javax.swing.JButton
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JButton getStartButton() {
	if (ivjStartButton == null) {
		try {
			ivjStartButton = new javax.swing.JButton();
			ivjStartButton.setName("StartButton");
			ivjStartButton.setText("Start");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjStartButton;
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
 * Initializes connections
 * @exception java.lang.Exception The exception description.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initConnections() throws java.lang.Exception {
	// user code begin {1}
	// user code end
	getStartButton().addActionListener(ivjEventHandler);
}
/**
 * Initialize the class.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initialize() {
	try {
		// user code begin {1}
		// user code end
		setName("FrontPanel");
		setLayout(new java.awt.GridBagLayout());
		setSize(576, 257);

		java.awt.GridBagConstraints constraintsJLabel1 = new java.awt.GridBagConstraints();
		constraintsJLabel1.gridx = 0; constraintsJLabel1.gridy = 0;
		constraintsJLabel1.insets = new java.awt.Insets(4, 4, 4, 4);
		add(getJLabel1(), constraintsJLabel1);

		java.awt.GridBagConstraints constraintsJTextField1 = new java.awt.GridBagConstraints();
		constraintsJTextField1.gridx = 0; constraintsJTextField1.gridy = 1;
		constraintsJTextField1.weightx = 1.0;
		constraintsJTextField1.insets = new java.awt.Insets(4, 4, 4, 4);
		add(getJTextField1(), constraintsJTextField1);

		java.awt.GridBagConstraints constraintsStartButton = new java.awt.GridBagConstraints();
		constraintsStartButton.gridx = 0; constraintsStartButton.gridy = 2;
		constraintsStartButton.insets = new java.awt.Insets(4, 4, 4, 4);
		add(getStartButton(), constraintsStartButton);
		initConnections();
	} catch (java.lang.Throwable ivjExc) {
		handleException(ivjExc);
	}
	// user code begin {2}
	// user code end
}
/**
 * main entrypoint - starts the part when it is run as an application
 * @param args java.lang.String[]
 */
public static void main(java.lang.String[] args) {
	try {
		javax.swing.JFrame frame = new javax.swing.JFrame();
		FrontPanel aFrontPanel;
		aFrontPanel = new FrontPanel();
		frame.setContentPane(aFrontPanel);
		frame.setSize(aFrontPanel.getSize());
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.exit(0);
			};
		});
		frame.show();
		java.awt.Insets insets = frame.getInsets();
		frame.setSize(frame.getWidth() + insets.left + insets.right, frame.getHeight() + insets.top + insets.bottom);
		frame.setVisible(true);
	} catch (Throwable exception) {
		System.err.println("Exception occurred in main() of javax.swing.JPanel");
		exception.printStackTrace(System.out);
	}
}
/**
 * Comment
 */
public void startButton_ActionPerformed(
	java.awt.event.ActionEvent actionEvent) {
	mainFrame.getClient().setStopped(true);
	mainFrame.getServer().setStopped(true);
	mainFrame.setClient(new ClientThread(getJTextField1().getText()));
	mainFrame.setServer(new ServerThread());
	return;
}
}
