package edu.rif.voice;

/**
 * Insert the type's description here.
 * Creation date: (02.08.2001 17:49:39)
 * @author: Radu Fericean
 */
import javax.sound.sampled.*;
public class SettingsPanel extends javax.swing.JPanel {
	private javax.swing.JSlider ivjBufferSlider = null;
	private javax.swing.JLabel ivjJLabel1 = null;
	private javax.swing.JLabel ivjJLabel2 = null;
	private javax.swing.JSlider ivjVolumeSlider = null;
	private javax.swing.JComboBox ivjJComboBox1 = null;
	private javax.swing.JLabel ivjJLabel3 = null;
	private javax.swing.JFrame mainFrame = null;
	private javax.swing.JLabel ivjJLabel4 = null;
	private javax.swing.JSlider ivjMicSlider = null;
	private FloatControl control = null;

class IvjEventHandler implements javax.swing.event.ChangeListener {
		public void stateChanged(javax.swing.event.ChangeEvent e) {
			if (e.getSource() == SettingsPanel.this.getVolumeSlider()) 
				connEtoC1(e);
		};
	};
	IvjEventHandler ivjEventHandler = new IvjEventHandler();
/**
 * SettingsPanel constructor comment.
 */
public SettingsPanel() {
	super();
	initialize();
	
}
/**
 * SettingsPanel constructor comment.
 * @param layout java.awt.LayoutManager
 */
public SettingsPanel(java.awt.LayoutManager layout) {
	super(layout);
}
/**
 * SettingsPanel constructor comment.
 * @param layout java.awt.LayoutManager
 * @param isDoubleBuffered boolean
 */
public SettingsPanel(java.awt.LayoutManager layout, boolean isDoubleBuffered) {
	super(layout, isDoubleBuffered);
}
/**
 * SettingsPanel constructor comment.
 */
public SettingsPanel(javax.swing.JFrame main) {
	super();
	initialize();
	mainFrame = main;
}
/**
 * SettingsPanel constructor comment.
 * @param isDoubleBuffered boolean
 */
public SettingsPanel(boolean isDoubleBuffered) {
	super(isDoubleBuffered);
}
/**
 * connEtoC1:  (VolumeSlider.change.stateChanged(javax.swing.event.ChangeEvent) --> SettingsPanel.volumeSlider_StateChanged(Ljavax.swing.event.ChangeEvent;)V)
 * @param arg1 javax.swing.event.ChangeEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC1(javax.swing.event.ChangeEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.volumeSlider_StateChanged(arg1);
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * Return the BufferSlider property value.
 * @return javax.swing.JSlider
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JSlider getBufferSlider() {
	if (ivjBufferSlider == null) {
		try {
			ivjBufferSlider = new javax.swing.JSlider();
			ivjBufferSlider.setName("BufferSlider");
			ivjBufferSlider.setOrientation(javax.swing.JSlider.VERTICAL);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjBufferSlider;
}
/**
 * Return the JComboBox1 property value.
 * @return javax.swing.JComboBox
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JComboBox getJComboBox1() {
	if (ivjJComboBox1 == null) {
		try {
			ivjJComboBox1 = new javax.swing.JComboBox();
			ivjJComboBox1.setName("JComboBox1");
			// user code begin {1}
			Mixer.Info[] aInfos = AudioSystem.getMixerInfo();
			for (int i = 0; i < aInfos.length; i++) {
				ivjJComboBox1.addItem(aInfos[i].getName());
			}
			if (aInfos.length == 0) {
				System.out.println("[No mixers available]");
			}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJComboBox1;
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
			ivjJLabel1.setText("Sound Volume");
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
 * Return the JLabel2 property value.
 * @return javax.swing.JLabel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JLabel getJLabel2() {
	if (ivjJLabel2 == null) {
		try {
			ivjJLabel2 = new javax.swing.JLabel();
			ivjJLabel2.setName("JLabel2");
			ivjJLabel2.setText("Mic Volume");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJLabel2;
}
/**
 * Return the JLabel3 property value.
 * @return javax.swing.JLabel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JLabel getJLabel3() {
	if (ivjJLabel3 == null) {
		try {
			ivjJLabel3 = new javax.swing.JLabel();
			ivjJLabel3.setName("JLabel3");
			ivjJLabel3.setText("Available Filters");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJLabel3;
}
/**
 * Return the JLabel4 property value.
 * @return javax.swing.JLabel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JLabel getJLabel4() {
	if (ivjJLabel4 == null) {
		try {
			ivjJLabel4 = new javax.swing.JLabel();
			ivjJLabel4.setName("JLabel4");
			ivjJLabel4.setText("Buffer");
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJLabel4;
}
/**
 * Return the BufferSlider property value.
 * @return javax.swing.JSlider
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JSlider getMicSlider() {
	if (ivjMicSlider == null) {
		try {
			ivjMicSlider = new javax.swing.JSlider();
			ivjMicSlider.setName("MicSlider");
			ivjMicSlider.setPaintLabels(true);
			ivjMicSlider.setPaintTicks(true);
			ivjMicSlider.setOrientation(javax.swing.JSlider.VERTICAL);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjMicSlider;
}
/**
 * Return the VolumeSlider property value.
 * @return javax.swing.JSlider
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JSlider getVolumeSlider() {
	if (ivjVolumeSlider == null) {
		try {
			ivjVolumeSlider = new javax.swing.JSlider();
			ivjVolumeSlider.setName("VolumeSlider");
			ivjVolumeSlider.setOrientation(javax.swing.JSlider.VERTICAL);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjVolumeSlider;
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
 * Insert the method's description here.
 * Creation date: (03.08.2001 19:30:15)
 * @param control javax.sound.sampled.FloatControl
 */
public void init(FloatControl control) {
	getVolumeSlider().setMinimum((int)control.getMinimum());
	getVolumeSlider().setMaximum((int)control.getMaximum());
	getVolumeSlider().setValue((int)control.getValue());
}
/**
 * Initializes connections
 * @exception java.lang.Exception The exception description.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initConnections() throws java.lang.Exception {
	// user code begin {1}
	// user code end
	getVolumeSlider().addChangeListener(ivjEventHandler);
}
/**
 * Initialize the class.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initialize() {
	try {
		// user code begin {1}
		// user code end
		setName("SettingsPanel");
		setLayout(new java.awt.GridBagLayout());
		setSize(441, 264);

		java.awt.GridBagConstraints constraintsVolumeSlider = new java.awt.GridBagConstraints();
		constraintsVolumeSlider.gridx = 0; constraintsVolumeSlider.gridy = 0;
constraintsVolumeSlider.gridheight = 2;
		constraintsVolumeSlider.weightx = 1.0;
		constraintsVolumeSlider.insets = new java.awt.Insets(4, 4, 4, 4);
		add(getVolumeSlider(), constraintsVolumeSlider);

		java.awt.GridBagConstraints constraintsJLabel1 = new java.awt.GridBagConstraints();
		constraintsJLabel1.gridx = 0; constraintsJLabel1.gridy = 2;
		constraintsJLabel1.insets = new java.awt.Insets(4, 4, 4, 4);
		add(getJLabel1(), constraintsJLabel1);

		java.awt.GridBagConstraints constraintsMicSlider = new java.awt.GridBagConstraints();
		constraintsMicSlider.gridx = 1; constraintsMicSlider.gridy = 0;
constraintsMicSlider.gridheight = 2;
		constraintsMicSlider.weightx = 1.0;
		constraintsMicSlider.insets = new java.awt.Insets(4, 4, 4, 4);
		add(getMicSlider(), constraintsMicSlider);

		java.awt.GridBagConstraints constraintsJLabel2 = new java.awt.GridBagConstraints();
		constraintsJLabel2.gridx = 1; constraintsJLabel2.gridy = 2;
		constraintsJLabel2.insets = new java.awt.Insets(4, 4, 4, 4);
		add(getJLabel2(), constraintsJLabel2);

		java.awt.GridBagConstraints constraintsJComboBox1 = new java.awt.GridBagConstraints();
		constraintsJComboBox1.gridx = 3; constraintsJComboBox1.gridy = 1;
		constraintsJComboBox1.fill = java.awt.GridBagConstraints.HORIZONTAL;
		constraintsJComboBox1.anchor = java.awt.GridBagConstraints.NORTH;
		constraintsJComboBox1.weightx = 1.0;
		constraintsJComboBox1.insets = new java.awt.Insets(4, 4, 4, 4);
		add(getJComboBox1(), constraintsJComboBox1);

		java.awt.GridBagConstraints constraintsJLabel3 = new java.awt.GridBagConstraints();
		constraintsJLabel3.gridx = 3; constraintsJLabel3.gridy = 0;
		constraintsJLabel3.insets = new java.awt.Insets(4, 4, 4, 4);
		add(getJLabel3(), constraintsJLabel3);

		java.awt.GridBagConstraints constraintsBufferSlider = new java.awt.GridBagConstraints();
		constraintsBufferSlider.gridx = 2; constraintsBufferSlider.gridy = 0;
constraintsBufferSlider.gridheight = 2;
		constraintsBufferSlider.weightx = 1.0;
		constraintsBufferSlider.insets = new java.awt.Insets(4, 4, 4, 4);
		add(getBufferSlider(), constraintsBufferSlider);

		java.awt.GridBagConstraints constraintsJLabel4 = new java.awt.GridBagConstraints();
		constraintsJLabel4.gridx = 2; constraintsJLabel4.gridy = 2;
		constraintsJLabel4.insets = new java.awt.Insets(4, 4, 4, 4);
		add(getJLabel4(), constraintsJLabel4);
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
		SettingsPanel aSettingsPanel;
		aSettingsPanel = new SettingsPanel();
		frame.setContentPane(aSettingsPanel);
		frame.setSize(aSettingsPanel.getSize());
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
public void volumeSlider_StateChanged(javax.swing.event.ChangeEvent stateChangeEvent) {
	System.out.println (control);
	control.setValue((float)getVolumeSlider().getValue());
	return;
}
}
