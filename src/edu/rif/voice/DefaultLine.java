package edu.rif.voice;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.FloatControl;

public abstract class DefaultLine {
	public static final int BUFFER = 512;
	public static final float FRATE = 8000.0F;
	public static final int BITS_PER_SAMPLE = 16;
	public static final int CHANNELS = 1;
	public static final boolean BIG_ENDIAN = true;
	public static final int FRAME_SIZE = (BITS_PER_SAMPLE / 8) * CHANNELS;
	AudioFormat audioFormat = null;
	public static final AudioFormat.Encoding ENCODING = AudioFormat.Encoding.PCM_SIGNED;

	protected DefaultLine() {
		// audioFormat = new AudioFormat(encoding, 44100.0F, 16, 2, 4, 44100.0F,
		// false);
		audioFormat = new AudioFormat(ENCODING, FRATE, BITS_PER_SAMPLE,
				CHANNELS, FRAME_SIZE, FRATE, BIG_ENDIAN);
		System.out.println("Sound config...");
	}

	void write(byte[] buf, int pos, int cant) {
	}

	int read(byte[] buf, int pos, int cant) {
		return 0;
	}

	public abstract FloatControl getVolumeControl();

	public abstract void close();
}
