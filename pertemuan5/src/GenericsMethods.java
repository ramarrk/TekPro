public class GenericsMethods {

    // ini contoh Generic Method.
    // pake <T> sebelum tipe balikan (boolean) biar method ini bisa nerima parameter objek dengan tipe apa aja secara dinamis.
    public static <T> boolean isEqual(GenericsType<T> g1, GenericsType<T> g2) {
        // ngambil nilai asli dari dalem objek g1 sama g2, terus dibandingin pake method bawaan equals().
        return g1.get().equals(g2.get());
    }

    public static void main(String args[]) {
        // bikin objek g1 dan ngunci tipenya jadi String, terus diisi "Java"
        GenericsType<String> g1 = new GenericsType<>();
        g1.set("Java");

        // bikin objek g2, tipenya String juga, isinya "Java"
        GenericsType<String> g2 = new GenericsType<>();
        g2.set("Java");

        // manggil method generic pake cara lengkap/eksplisit (nulis <String> secara manual sebelum nama method).
        boolean isEqual = GenericsMethods.<String>isEqual(g1, g2);

        // nah, baris di atas sebenernya bisa disingkat jadi gini aja:
        isEqual = GenericsMethods.isEqual(g1, g2);

        /*
         * Fitur ngebaca otomatis ini namanya TYPE INFERENCE.
         * Java tuh udah pinter, kompilatornya bisa otomatis nebak kalau tipe yang dibutuhin itu <String>
         * dengan cara ngeliat argumen g1 sama g2 yang dimasukin.
         * Jadi kita gausah repot-repot nulis <String> lagi di pemanggilan methodnya.
         */
    }
}