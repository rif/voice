package edu.rif.voice;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Control;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

class EchoLine extends DefaultLine {
	SourceDataLine line = null;

	public EchoLine() {
		super();
		try {
			soundConfig();
		} catch (LineUnavailableException ex) {
			System.out.println("Echo line is not available!");
			System.exit(1);
		}
	}

	void soundConfig() throws LineUnavailableException {
		DataLine.Info sourceInfo = new DataLine.Info(SourceDataLine.class,
				audioFormat);
		line = (SourceDataLine) AudioSystem.getLine(sourceInfo);
		line.open(audioFormat);
		line.start();
		System.out.println(line.getFormat());
	}

	void write(byte[] buf, int pos, int cant) {
		line.write(buf, 0, cant);
	}

	public FloatControl getVolumeControl() {
		return (FloatControl) line.getControl(FloatControl.Type.MASTER_GAIN);
	}

	void getInfo() {
		Control[] controls = line.getControls();
		for (int i = 0; i < controls.length; i++) {
			System.out.println(controls[i]);
		}
	}

	@Override
	public void close() {
		line.close();
		line.stop();
	}

}