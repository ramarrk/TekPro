public class GenericsTypeOld {

    // deklarasi variable pake tipe Object biar bisa nampung tipe data apa aja
    private Object t;

    // ngambil data yang udah disimpen, tapi balikan nilainya masih berformat Object
    public Object get() {
        return t;
    }

    // nyimpen data baru tanpa peduli tipe data aslinya (karena otomatis dianggep Object)
    public void set(Object t) {
        this.t = t;
    }

    public static void main(String args[]) {
        GenericsTypeOld type = new GenericsTypeOld();

        // masukin data String "Java", di dalemnya otomatis disimpen sebagai Object
        type.set("Java");

        // pas diambil wujudnya masih Object, jadi harus dipaksa (casting) balik ke String pake (String)
        // cara manual ini rawan error (ClassCastException) kalau ternyata isi datanya ga cocok
        String str = (String) type.get();
    }
}