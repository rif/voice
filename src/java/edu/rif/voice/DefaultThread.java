package edu.rif.voice;


/**
 * Insert the type's description here.
 * Creation date: (03.08.2001 15:25:26)
 * @author: Radu Fericean
 */
public interface DefaultThread {
    static final int INPORT = 1711;
    static final int BUFFER = 512;	

    /**
     * Insert the method's description here.
     * Creation date: (03.08.2001 18:42:30)
     * @param state boolean
     */
    void setStopped(boolean state);
}
