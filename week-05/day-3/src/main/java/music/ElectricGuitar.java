package main.java.music;

/**
 * Created by Rita on 2016-11-16.
 */
public class ElectricGuitar extends StringedInstrument {
    private String sound;

    public ElectricGuitar() {
        this(6);
    }

    public ElectricGuitar(int numberOfStrings) {
        super.numberOfStrings = numberOfStrings;
        this.sound = "twangs";
        super.name = "Electric Guitar";
    }

    public void play() {
        System.out.printf(formatForPlay, name, numberOfStrings, sound);
    }
}
