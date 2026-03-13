import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Wildcard Arguments With An Unknown Type
 * @author javaguides.net
 **/
public class WildCardSimpleExample {

    // Method ini pake parameter Collection bawaan Java.
    // Nah, tanda tanya <?> ini namanya Unbounded Wildcard.
    // Artinya, method ini "bodo amat" dan siap nerima tipe Collection apa aja (mau itu <String>, <Integer>, dll).
    public static void printCollection(Collection<?> c) {

        // Pake looping for-each buat ngebaca isi dari collection 'c'.
        // Karena kita dari awal gak tau tipe pasti isinya apa (gara-gara <?>),
        // cara paling aman adalah ngebaca tiap elemennya sebagai 'Object'.
        // Kenapa Object? Karena semua class di Java pasti keturunan Object.
        for (Object e : c) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        // 1. Ngetes pake ArrayList
        // Bikin collection tipe ArrayList dan ngunci tipenya cuma buat <String>
        Collection<String> collection = new ArrayList<>();
        collection.add("ArrayList Collection");

        // Manggil method printCollection. Aman dan valid!
        printCollection(collection);

        // 2. Ngetes pake LinkedList
        // Bikin collection tipe LinkedList, isinya <String> juga
        Collection<String> collection2 = new LinkedList<>();
        collection2.add("LinkedList Collection");

        // Manggil method yang sama persis. Tetep jalan dengan lancar!
        printCollection(collection2);

        // 3. Ngetes pake HashSet
        // Bikin collection tipe HashSet, isinya <String>
        Collection<String> collection3 = new HashSet<>();
        collection3.add("HashSet Collection");

        // Method printCollection tetep bisa nerima padahal struktur datanya beda-beda.
        // Ini bukti kalau pakai <?> bikin method kita jadi super fleksibel (reusable).
        printCollection(collection3);
    }
}