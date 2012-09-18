package edu.rif.voice;

interface Converter{
	public byte[] convertReceivedBytes(byte[] array);
	public byte[] decode(byte[] array);
}