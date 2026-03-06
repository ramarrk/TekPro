package soal2;

public class TestAllShape {
    public static void main(String[] args) {
        Shape s = new Shape("blue", false);
        System.out.println(s.toString());

        Circle c = new Circle(5.5, "red", true);
        System.out.println(c.toString());

        Rectangle r = new Rectangle(3.0, 4.0, "yellow", true);
        System.out.println(r.toString());

        Square sq = new Square(4.0, "purple", false);
        System.out.println(sq.toString());

        sq.setSide(10.0);
        System.out.println("Modified Square: " + sq.toString());
    }
}