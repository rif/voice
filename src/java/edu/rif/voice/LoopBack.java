package edu.rif.voice;
import javax.sound.sampled.*;

public class LoopBack {
    private float fRate = 8000.0F; // frecventa de esantionare
    private int nBitsPerSample = 16; // numarul de biti pe esantion
    private int nChannels = 1; // un singur canal: mono
    private boolean bBigEndian = true; // intai MSB
    private int nInternalBufferSize = 888192; // buferul intern
    private int nFrameSize = (nBitsPerSample / 8) * nChannels; //cam 2 esantioane pe cadru
    private AudioFormat audioFormat = null;
    private AudioFormat.Encoding encoding = null;
    private TargetDataLine inLine = null;
    private AudioInputStream encodedStream = null;
    private SourceDataLine outLine = null;
    
    public LoopBack() {
     //definesc formatul canalului de citire
        encoding = AudioFormat.Encoding.PCM_SIGNED;
        audioFormat = new AudioFormat(encoding, fRate, nBitsPerSample, nChannels, nFrameSize, fRate, bBigEndian);        
        configIn(); //configurez linia de input (microfonului)
        configOut(); //configurez linia de output (boxelor)
   }
    
    private void configIn() {
        try {
            DataLine.Info targetInfo = new DataLine.Info(TargetDataLine.class, audioFormat, nInternalBufferSize);

            inLine = (TargetDataLine) AudioSystem.getLine(targetInfo);
            inLine.open(audioFormat, nInternalBufferSize);
            AudioInputStream stream = new AudioInputStream(inLine);
            AudioFormat format = inLine.getFormat();
            AudioFormat.Encoding targetEncoding = AudioFormat.Encoding.ALAW;

            encodedStream = AudioSystem.getAudioInputStream(targetEncoding, stream);
            inLine.start();
        }catch (LineUnavailableException lue) {
            lue.printStackTrace();
        }
    }

    private void configOut() {
        try {
            DataLine.Info sourceInfo = new DataLine.Info(SourceDataLine.class, audioFormat, nInternalBufferSize);

            outLine = (SourceDataLine) AudioSystem.getLine(sourceInfo);
            outLine.open(audioFormat, nInternalBufferSize);
            outLine.start();
        }catch (LineUnavailableException lue) {
            lue.printStackTrace();
        }
    }
 
    public void start() {
        byte[] buf = new byte[512]; //bufferul de citire/scriere este de 512 ko

        while (true) { //ciclu infinit de citire de la microfon si scriere la boxe
            inLine.read(buf, 0, buf.length);
            outLine.write(buf, 0, buf.length);
        }
    }

    public static void main(String[] args) {
        LoopBack loop = new LoopBack();

        loop.start();
    }
}
