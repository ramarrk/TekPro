// ini cara kalau pake ReentransLock

package soal3;

import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

public class ParallelSum2 {

    private static long totalSum = 0;
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah thread: ");
        int jumlahThread = scanner.nextInt();

        System.out.print("Masukkan angka akhir: ");
        int angkaAkhir = scanner.nextInt();

        scanner.close();

        int rangePerThread = angkaAkhir / jumlahThread;
        Thread[] threads = new Thread[jumlahThread];

        for (int i = 0; i < jumlahThread; i++) {
            int start = (i * rangePerThread) + 1;
            int end = (i == jumlahThread - 1) ? angkaAkhir : (i + 1) * rangePerThread;
            int threadIndex = i + 1;

            threads[i] = new Thread(() -> {
                System.out.println("Thread " + threadIndex + ": Menjumlahkan " + start + " - " + end);

                long partialSum = 0;
                for (int j = start; j <= end; j++) {
                    partialSum += j;
                }

                System.out.println("Thread " + threadIndex + ": Hasil parsial = " + partialSum);

                lock.lock();
                try {
                    totalSum += partialSum;
                } finally {
                    lock.unlock();
                }
            });

            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("--- HASIL AKHIR ---");
        System.out.println("Total penjumlahan 1 sampai " + angkaAkhir + " = " + totalSum);
    }
}