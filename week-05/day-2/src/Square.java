/**
 * Created by Rita on 2016-11-15.
 *
 * Create a Square class which inherits from the Rectangle class.

 It should have a constructor with the length of the sides
 Override the getArea method
 Override the toString method which should return the following: "Square[{side length}]"
 */
public class Square extends Rectangle {
    public Square(double width) {
        this.setHeight(width);
        this.setWidth(width);
    }

    public double getArea() {
        return Math.pow(this.getWidth(), 2);
    }

    public String toString() {
        return "Square[{" +this.getWidth() + "}]";
    }
}
