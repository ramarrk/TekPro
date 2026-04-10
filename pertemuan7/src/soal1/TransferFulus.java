package soal1;

class Account {
    int balance = 150;
}

public class TransferFulus {

    public static void main(String[] args) throws InterruptedException { Account acc1 = new Account();
        Account acc2 = new Account();

        // Thread 1: Transfer fulus dari acc1 ke acc2
        Thread t1 = new Thread(() -> {
            synchronized (acc1) { // Mengunci acc1 agar tidak bisa diakses thread lain

                System.out.println("Thread 1: Berhasil mengunci acc1, menunggu acc2...");

                synchronized (acc2) { // Mengunci acc2 untuk menyelesaikan transfer
                    System.out.println("Thread 1: Berhasil mengunci acc2, melakukan transfer acc1 -> acc2");
                    acc2.balance += acc1.balance;
                }
            }
        });

        // Thread 2: Transfer fulus dari acc2 ke acc1
        Thread t2 = new Thread(() -> {
            synchronized (acc1) { // Mengunci acc1 agar tidak bisa diakses thread lain

                System.out.println("Thread 2: Berhasil mengunci acc1, menunggu acc2...");

                synchronized (acc2) { // Mengunci acc2 untuk menyelesaikan transfer
                    System.out.println("Thread 2: Berhasil mengunci acc2, melakukan transfer acc2 -> acc1");
                    acc1.balance += acc2.balance;
                }
            }
        });
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        System.out.println("--- HASIL AKHIR ---");
        System.out.println("Saldo Akhir acc1: " + acc1.balance);
        System.out.println("Saldo Akhir acc2: " + acc2.balance);
    }
}