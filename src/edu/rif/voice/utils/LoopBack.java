package edu.rif.voice.utils;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;

import edu.rif.voice.DefaultLine;

public class LoopBack {
	private AudioFormat audioFormat = null;
	private TargetDataLine inLine = null;
	private SourceDataLine outLine = null;

	public LoopBack() {
		// definesc formatul canalului de citire
		audioFormat = new AudioFormat(DefaultLine.ENCODING, DefaultLine.FRATE,
				DefaultLine.BITS_PER_SAMPLE, DefaultLine.CHANNELS,
				DefaultLine.FRAME_SIZE, DefaultLine.FRATE,
				DefaultLine.BIG_ENDIAN);
		configIn(); // configurez linia de input (microfonului)
		configOut(); // configurez linia de output (boxelor)
	}

	private void configIn() {
		try {
			DataLine.Info targetInfo = new DataLine.Info(TargetDataLine.class,
					audioFormat);

			inLine = (TargetDataLine) AudioSystem.getLine(targetInfo);
			inLine.open(audioFormat);
			AudioInputStream stream = new AudioInputStream(inLine);			

			AudioSystem.getAudioInputStream(DefaultLine.ENCODING, stream);
			inLine.start();
		} catch (LineUnavailableException lue) {
			lue.printStackTrace();
		}
	}

	private void configOut() {
		try {
			DataLine.Info sourceInfo = new DataLine.Info(SourceDataLine.class,
					audioFormat);

			outLine = (SourceDataLine) AudioSystem.getLine(sourceInfo);
			outLine.open(audioFormat);
			outLine.start();
		} catch (LineUnavailableException lue) {
			lue.printStackTrace();
		}
	}

	public void start() {
		byte[] buf = new byte[DefaultLine.BUFFER]; // bufferul de citire/scriere este de 512 ko

		while (true) { // ciclu infinit de citire de la microfon si scriere la
			// boxe
			inLine.read(buf, 0, buf.length);
			outLine.write(buf, 0, buf.length);
		}
	}

	public static void main(String[] args) {
		LoopBack loop = new LoopBack();

		loop.start();
	}
}
