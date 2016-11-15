/**
 * Created by Rita on 2016-11-15.
 *
 First create a Point class which is a single point in a Cartesian system. The Point consists of 2 fields:

 x:int = 0
 y:int = 0
 It has constructors:-

 The default constructor (without any parameter) which sets x and y to 0 (the origin).
 An alternative that takes x and y parameters.
 There are getters and setters:-

 getX() : int
 setX(x:int):void
 getY():int
 setY(y:int):void
 toString():String // "(x,y)"
 getXY(): int[2] - returns a 2 element int array of {x,y}
 setXY(x:int, y:int):void
 An there are some other Methods:-

 distance(x:int, y:int):double - returns the distance from this to the given(x,y)
 distance(another:Point):double - returns the distance from this to another instance of Point
 distance():double - returns the distance of this from the origin (e.g. Point(0,0);
 */
public class Point {
    private int x;
    private int y;

    public Point() {
        x = 0;
        y = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public int[] getXY() {
        int[] array = {getX(), getY()};
        return array;
    }

    public void setXY(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public double distance(int otherX, int otherY) {
        return Math.sqrt(Math.pow((this.getX()-otherX),2) + Math.pow((this.getY()-otherY),2));
    }

    public double distance() {
        return Math.sqrt(Math.pow(this.getX(),2) + Math.pow(this.getY(), 2));
    }

    public double distance(Point otherPoint) {
        return Math.sqrt(Math.pow((this.getX()-otherPoint.getX()),2) + Math.pow((this.getY()-otherPoint.getY()),2));
    }
}
