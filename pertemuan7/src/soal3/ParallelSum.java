package soal3;

import java.util.Scanner;

// Class SumTask merepresentasikan tugas penjumlahan yang dikerjakan satu thread
// Implements Runnable agar bisa dijalankan sebagai thread
class SumTask implements Runnable {
    private final int start;
    private final int end;
    private final int threadIndex;
    private long partialSum = 0;

    public SumTask(int start, int end, int threadIndex) {
        this.start = start;
        this.end = end;
        this.threadIndex = threadIndex;
    }

    @Override
    public void run() {
        System.out.println("Thread " + threadIndex + ": Menjumlahkan " + start + " - " + end);

        // Penjumlahan dilakukan di variabel lokal partialSum milik masing-masing thread
        // Tidak perlu synchronized karena tidak ada thread lain yang mengakses variabel ini
        for (int i = start; i <= end; i++) {
            partialSum += i;
        }

        System.out.println("Thread " + threadIndex + ": Hasil parsial = " + partialSum);
    }

    // Getter untuk mengambil hasil parsial setelah thread selesai
    public long getPartialSum() {
        return partialSum;
    }
}

public class ParallelSum {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah thread: ");
        int jumlahThread = scanner.nextInt();

        System.out.print("Masukkan angka akhir: ");
        int angkaAkhir = scanner.nextInt();

        scanner.close();

        // Menghitung range yang dikerjakan tiap thread
        int rangePerThread = angkaAkhir / jumlahThread;

        SumTask[] tasks = new SumTask[jumlahThread];
        Thread[] threads = new Thread[jumlahThread];

        // Membuat dan menjalankan setiap thread
        for (int i = 0; i < jumlahThread; i++) {
            int start = (i * rangePerThread) + 1;
            int end = (i == jumlahThread - 1) ? angkaAkhir : (i + 1) * rangePerThread;
            // Thread terakhir mengerjakan sampai angkaAkhir
            // untuk menangani sisa pembagian yang tidak habis

            tasks[i] = new SumTask(start, end, i + 1);
            threads[i] = new Thread(tasks[i]);
            threads[i].start();
        }

        // Menunggu semua thread selesai sebelum mengakumulasi hasil
        for (Thread thread : threads) {
            thread.join();
        }

        // Akumulasi hasil parsial dilakukan di main thread setelah semua thread selesai
        // Tidak perlu synchronized karena dilakukan secara sequential, bukan paralel
        long totalSum = 0;
        for (SumTask task : tasks) {
            totalSum += task.getPartialSum();
        }

        System.out.println("--- HASIL AKHIR ---");
        System.out.println("Total penjumlahan 1 sampai " + angkaAkhir + " = " + totalSum);
    }
}