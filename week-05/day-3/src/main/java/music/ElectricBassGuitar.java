package main.java.music;

/**
 * Created by Rita on 2016-11-16.
 */
public class ElectricBassGuitar extends StringedInstrument {
    private String sound;

    public ElectricBassGuitar() {
        this(4);
    }

    public ElectricBassGuitar(int numberOfStrings) {
        super.numberOfStrings = numberOfStrings;
        this.sound = "Duum-duum-duum";
        super.name = "Bass Guitar";
    }

    public void play() {
        System.out.printf(formatForPlay, name, numberOfStrings, sound);
    }
}
