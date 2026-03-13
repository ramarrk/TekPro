// pake <T> biar tipe datanya dinamis, wujud aslinya baru ditentuin pas objeknya dibikin
public class GenericsType<T> {

    // deklarasi variable t tipenya ngikutin T, bukan pake Object lagi
    private T t;

    // ngambil data yang udah disimpen, balikan nilainya otomatis ngikutin tipe T
    public T get() {
        return this.t;
    }

    // nyimpen data baru, dia cuma mau nerima data yang tipenya sesuai sama T
    public void set(T t1) {
        this.t = t1;
    }

    public static void main(String args[]) {
        // bikin objek baru dan langsung ngunci tipe <T>-nya jadi <String>
        GenericsType<String> type = new GenericsType<>();

        // aman (valid) masukin teks, soalnya udah dikunci jadi String
        type.set("Java");

        // ini namanya 'raw type' (gak ngisi tipe di dalem <>). 
        // otomatis nurunin tipenya balik jadi Object lagi kayak cara jadul
        GenericsType type1 = new GenericsType();

        // valid, karena wujudnya Object jadi bisa nerima teks String
        type1.set("Java");

        // valid juga. angka 10 (int) otomatis dibungkus jadi objek 'Integer' (autoboxing) biar masuk ke Object.
        // tapi cara raw type gini bikin type safety-nya ilang dan rawan error
        type1.set(10);
    }
}