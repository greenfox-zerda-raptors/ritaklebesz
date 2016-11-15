/**
 * Created by Rita on 2016-11-15.
 *
 * Create a Rectangle class which has a getArea function.

 It should have a default constructor (without any parameter) which sets width and height to 1.
 It should have a constructor with width and height parameters
 Implement getters and setters
 */
public class Rectangle {
    private double width;
    private double height;

    public Rectangle() {
        this.width = 1;
        this.height = 1;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
