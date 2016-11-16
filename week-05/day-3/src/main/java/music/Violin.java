package main.java.music;

/**
 * Created by Rita on 2016-11-16.
 */
public class Violin extends StringedInstrument {
    private String sound;

    public Violin() {
        this(4);
    }

    public Violin(int numberOfStrings) {
        super.numberOfStrings = numberOfStrings;
        this.sound = "screeches";
        super.name = "Violin";
    }

    public void play() {
        System.out.printf(formatForPlay, name, numberOfStrings, sound);
    }
}
