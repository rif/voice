package edu.rif.voice;

import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;

class RecordLine extends DefaultLine {
	private TargetDataLine line = null;
	private AudioInputStream encodedStream = null;
	public RecordLine(){
		super();
		try {
	  		soundConfig();
	  	} catch (LineUnavailableException ex) {
			System.out.println ("Rec line is not available!");
			System.exit(1);
		}
	}
	
	void soundConfig() throws LineUnavailableException {
		DataLine.Info targetInfo = new DataLine.Info(TargetDataLine.class, audioFormat, nInternalBufferSize);
   		line = (TargetDataLine) AudioSystem.getLine(targetInfo);
		line.open(audioFormat, nInternalBufferSize);
		AudioInputStream stream = new AudioInputStream(line);
   		//AudioFormat format = line.getFormat();
		AudioFormat.Encoding targetEncoding = AudioFormat.Encoding.ALAW;
		encodedStream = AudioSystem.getAudioInputStream(targetEncoding, stream);
	  	line.start();
	}
	
	int read(byte[] buf,int pos, int cant) {
		try{
			//return line.read(buf,0,cant);
			return encodedStream.read(buf,0,cant);
		}catch(IOException ioe){
			System.out.println("Cannot read from input line!");
			System.exit(1);
		}
		return 0;	
	}
	public FloatControl getVolumeControl() {
		return (FloatControl) line.getControl(FloatControl.Type.VOLUME);
	}
}