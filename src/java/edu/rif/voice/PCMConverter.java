package edu.rif.voice;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import java.io.ByteArrayInputStream;
import java.io.IOException;


class PCMConverter implements Converter {
    private AudioInputStream toPCM(AudioInputStream source) {
        AudioFormat.Encoding targetEncoding = AudioFormat.Encoding.PCM_SIGNED;

        return source = AudioSystem.getAudioInputStream(targetEncoding, source);
    }
	public byte[] decode(byte[] array) {
		byte[] test = new byte[100];
		return test;}
    public byte[] convertReceivedBytes(byte[] array) {
        int buffer = DefaultThread.BUFFER * 2;
        float fRate = 8000.0F; //egal cu sample rate
        int nBitsPerSample = 8;
        int nChannels = 1;
        boolean bBigEndian = true;
        int nInternalBufferSize = buffer;
        int	nFrameSize = (nBitsPerSample / 8) * nChannels;
        AudioFormat.Encoding enc = AudioFormat.Encoding.ALAW;
        AudioFormat streamFormat = new AudioFormat(enc, fRate, nBitsPerSample, nChannels, nFrameSize, fRate, bBigEndian);
        //**************************
        ByteArrayInputStream byteArray = new ByteArrayInputStream(array);
        //		System.out.println ("Available: " + byteArray.available());
        AudioInputStream inputStream = new AudioInputStream(byteArray, streamFormat, byteArray.available());

        inputStream = toPCM(inputStream);
        byte[] tmp = new byte[buffer];

        try {
            int readCant = inputStream.read(tmp, 0, tmp.length);
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return tmp;
    }
}
