/**
 * Created by Rita on 2016-11-15.
 *
 * Create a Block class which inherits from the Rectangle.

 It should have two different constructors
 default constructor without any parameter which sets the length to 1
 with a length parameter
 It should have a getLength and a getVolume methods.
 Implement getters and setters
 */
public class Block extends Rectangle {
    private double length;
    public Block() {
        this.length = 1;
    }

    public Block(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getVolume() {
        return length*this.getHeight()*this.getHeight();
    }
}
