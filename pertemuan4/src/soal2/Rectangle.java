package soal2;

public class Rectangle extends Shape
{
    private final double length;
    private final double width;

    public Rectangle(double length, double width) {
        super("Rectangle");
        this.length = length;
        this.width = width;
    }

    public double area()
    {
        return length*width;
    }

    public String toString() {
        return super.toString() + " of length " + length + " and width " + width;
    }
}
