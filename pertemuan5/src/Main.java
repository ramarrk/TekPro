// bikin interface pake batasan (bounded type parameter). 
// <T> nya wajib punya sifat 'Comparable' biar isinya nanti bisa dibanding-bandingin nilainya.
interface MinMax<T extends Comparable<T>> {
    // deklarasi method buat nyari nilai paling gede
    T max();
}

// class ini ngikutin aturan interface di atas, batasannya juga tetep sama wajib Comparable
class MyClass<T extends Comparable<T>> implements MinMax<T> {
    // nyimpen array yang tipenya dinamis ngikutin T
    T[] vals;

    // constructor buat masukin data array ke dalem class
    MyClass(T[] o) {
        vals = o;
    }

    // jalanin method pencarian nilai max
    public T max() {
        // anggap aja data indeks pertama itu yang paling gede (buat perbandingan awal)
        T v = vals[0];

        // ngecek sisa isi array satu-satu pake looping
        for (int i = 1; i < vals.length; i++) {
            // pake method compareTo bawaan dari interface Comparable. 
            // kalau hasilnya > 0, artinya data yang lagi dicek lebih gede dari v.
            if (vals[i].compareTo(v) > 0) {
                // update nilai v pake data yang lebih gede tadi
                v = vals[i];
            }
        }
        return v;
    }
}

public class Main {
    public static void main(String[] args) {
        // ngetes pake array Integer (angka) dan Character (huruf). 
        // dua-duanya aman karena udah otomatis punya sifat Comparable dari bawaan Java.
        Integer[] inums = {3, 6, 2, 8, 6};
        Character[] chs = {'b', 'r', 'p', 'w'};

        // bikin objek 'a' dan ngunci tipenya jadi <Integer> buat ngurus array angka
        MyClass<Integer> a = new MyClass<>(inums);

        // bikin objek 'b' dan ngunci tipenya jadi <Character> buat ngurus array huruf
        MyClass<Character> b = new MyClass<>(chs);

        System.out.println("Nilai Integer Terbesar: " + a.max());
        System.out.println("Karakter Terbesar: " + b.max());
    }
}