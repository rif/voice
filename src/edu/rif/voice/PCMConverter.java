package edu.rif.voice;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

class PCMConverter implements Converter {
	private AudioFormat streamFormat = null;
	private AudioFormat.Encoding targetEncoding = null;

	public PCMConverter() {
		int nBitsPerSample = 8;
		streamFormat = new AudioFormat(AudioFormat.Encoding.ALAW,
				DefaultLine.FRATE, nBitsPerSample, DefaultLine.CHANNELS,
				DefaultLine.FRAME_SIZE, DefaultLine.FRATE,
				DefaultLine.BIG_ENDIAN);
		targetEncoding = AudioFormat.Encoding.PCM_SIGNED;
	}

	public byte[] convertReceivedBytes(byte[] array) {
		ByteArrayInputStream byteArray = new ByteArrayInputStream(array);
		AudioInputStream inputStream = new AudioInputStream(byteArray,
				streamFormat, byteArray.available());

		inputStream = AudioSystem.getAudioInputStream(targetEncoding,
				inputStream);
		byte[] tmp = new byte[DefaultLine.BUFFER * 2];

		try {
			inputStream.read(tmp, 0, tmp.length);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return tmp;
	}
}
