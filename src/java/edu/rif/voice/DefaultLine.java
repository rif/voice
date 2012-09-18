package edu.rif.voice;


import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.FloatControl;


public abstract class DefaultLine {
    static final int BUFFER = 16384;
    float fRate = 8000.0F;
    int nBitsPerSample = 16;
    int nChannels = 1;
    boolean bBigEndian = true;
    int nInternalBufferSize = BUFFER;
    int	nFrameSize = (nBitsPerSample / 8) * nChannels;
    AudioFormat audioFormat = null;
    AudioFormat.Encoding encoding = null;

    protected DefaultLine() {
        encoding = AudioFormat.Encoding.PCM_SIGNED;
        audioFormat = new AudioFormat(encoding, fRate, nBitsPerSample, nChannels, nFrameSize, fRate, bBigEndian);
        System.out.println ("Sound config...");	
    }

    void write(byte[] buf, int pos, int cant) {
    }	


    int read(byte[] buf, int pos, int cant) {
        return 0;
    }	


    public abstract FloatControl getVolumeControl();
}
