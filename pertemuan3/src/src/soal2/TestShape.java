package soal2;

public class TestShape {
    public static void main(String[] args) {
        Shape s1 = new Shape();
        System.out.println("Default Shape:");
        System.out.println("Color: " + s1.getColor());
        System.out.println("Filled: " + s1.isFilled());
        System.out.println("String: " + s1.toString());

        Shape s2 = new Shape("blue", false);
        System.out.println("\nParameterized Shape:");
        System.out.println("Color: " + s2.getColor());
        System.out.println("Filled: " + s2.isFilled());
        System.out.println("String: " + s2.toString());

        s1.setColor("yellow");
        s1.setFilled(false);
        System.out.println("\nModified Shape:");
        System.out.println("Color: " + s1.getColor());
        System.out.println("Filled: " + s1.isFilled());
        System.out.println("String: " + s1.toString());
    }
}