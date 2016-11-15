/**
 * Created by Rita on 2016-11-15.
 */
public class Workshop05 {
    public static void main(String[] args) {
        Rectangle defRect = new Rectangle();
        System.out.println(defRect.getHeight());
        System.out.println(defRect.getWidth());
        Rectangle myRectangle = new Rectangle(12, 2);
        System.out.println(myRectangle.getWidth()*myRectangle.getHeight());
        Block defBlock = new Block();
        System.out.println(defBlock.getVolume());
        System.out.println(defBlock.getWidth());
        Block myBlock = new Block(2);
        myBlock.setHeight(2);
        myBlock.setWidth(2);
        System.out.println(myBlock.getVolume());
        Square mySquare = new Square(5);
        System.out.println(mySquare.toString());
        System.out.println(mySquare.getArea());
    }
}
