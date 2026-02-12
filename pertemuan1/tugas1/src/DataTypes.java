import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {

            //cek apakah input berikutnya adalah angka Long yang valid?
            if (sc.hasNextLong()) {

                long n = sc.nextLong(); //'n' (number)

                System.out.println(n + " can be fitted in:");

                //cek Byte
                if(n >= -128 && n <= 127) {
                    System.out.println("* byte");
                }

                //cek Short
                if(n >= -32768 && n <= 32767) {
                    System.out.println("* short");
                }

                //cek Int
                if(n >= -2147483648 && n <= 2147483647) {
                    System.out.println("* int");
                }

                //cek Long
                System.out.println("* long");

            } else {

                //kalau tidak valid (karena terlalu besar), baca sebagai String biasa
                String input = sc.next();
                System.out.println(input + " can't be fitted anywhere.");

            }
        }
    }
}