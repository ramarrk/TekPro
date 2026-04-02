package JavaProblems;

import java.util.Arrays;

public class ProblemThree {
    public static void main(String[] args) {
        int arr[] = {12, 4, 3, 1, 9, 657};
        int n = 3; // Mencari elemen terbesar ke-3

        int ans = Arrays.stream(arr)        // [1] Ubah array jadi IntStream
                .boxed()                    // [2] IntStream → Stream<Integer>
                .sorted((a, b) -> Integer.compare(b, a))  // Descending: 657, 12, 9, 4, 3, 1
                .skip(n - 1)               // [3] Lewati 2 elemen (657, 12) → sisa: 9, 4, 3, 1
                .findFirst()               // [4] Ambil elemen pertama → 9 (Optional)
                .orElse(0);                // [5] Jika kosong, return 0

        System.out.println("Elemen terbesar ke-3 adalah: " + ans);
    }
}



//        **Visualisasi alur Stream:**
//        ```
//        {12, 4, 3, 1, 9, 657}
//        ↓ Arrays.stream()
//IntStream: [12, 4, 3, 1, 9, 657]
//        ↓ boxed()
//Stream<Integer>: [12, 4, 3, 1, 9, 657]
//        ↓ sorted() descending
//Stream<Integer>: [657, 12, 9, 4, 3, 1]
//        ↓ skip(2)
//Stream<Integer>: [9, 4, 3, 1]
//        ↓ findFirst()
//Optional<Integer>: 9
//        ↓ orElse(0)
//int: 9 ✅
//        ```
//
//        **Output:**
//        ```
//Elemen terbesar ke-3 adalah: 9