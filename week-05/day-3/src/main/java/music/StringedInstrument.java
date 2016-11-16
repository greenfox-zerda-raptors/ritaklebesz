package main.java.music;

/**
 * Created by Rita on 2016-11-16.
 */
public abstract class StringedInstrument extends Instrument {
    protected int numberOfStrings;
    protected final String formatForPlay ="%s, a %d-stringed instrument that %s\n";

    public abstract void play();
}
