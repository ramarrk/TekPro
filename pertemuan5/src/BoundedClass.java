// bikin class A sebagai super class
class A {
    public void displayClass() {
        System.out.println("Inside super class A");
    }
}

// bikin class B turunan dari A
class B extends A {
    public void displayClass() {
        System.out.println("Inside sub class B");
    }
}

// bikin class C turunan dari A juga
class C extends A {
    public void displayClass() {
        System.out.println("Inside sub class C");
    }
}

// deklarasi class Bound, tapi tipe T dibatesin (extends) cuma buat nampung class A atau anak-anaknya
class Bound<T extends A> {

    // nyimpen referensi objek, tipenya bakal ngikutin apa yang dimasukin nanti
    private T objRef;

    // constructor buat naruh objek ke dalem objRef
    public Bound(T obj) {
        this.objRef = obj;
    }

    public void doRunTest() {
        // manggil displayClass(). karena T di atas udah dipastiin keturunan A, compiler yakin method ini pasti ada
        this.objRef.displayClass();
    }
}

public class BoundedClass {
    public static void main(String a[]) {

        // bikin objek Bound yang dikunci khusus buat nampung class C
        Bound<C> bec = new Bound<C>(new C());
        // pas dijalanin, otomatis jalanin displayClass() versi class C
        bec.doRunTest();

        // bikin objek Bound tapi sekarang dikunci buat nampung class B
        Bound<B> beb = new Bound<B>(new B());
        // otomatis jalanin displayClass() versi class B
        beb.doRunTest();

        // sama aja, tapi ini buat masukin super class A langsung
        Bound<A> bea = new Bound<A>(new A());
        bea.doRunTest();
    }
}