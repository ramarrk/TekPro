public class RestaurantMain {

    public static void main(String[] args) {

        Restaurant menu = new Restaurant();

        // inisialisasi menu
        menu.tambahMenuMakanan("Pizza", 250000, 20);
        Restaurant.nextId();

        menu.tambahMenuMakanan("Spaghetti", 80000, 20);
        Restaurant.nextId();

        menu.tambahMenuMakanan("Tenderloin Steak", 60000, 30);
        Restaurant.nextId();

        menu.tambahMenuMakanan("Chicken Steak", 45000, 30);

        System.out.println("=== MENU AWAL ===");
        menu.tampilMenuMakanan();

        System.out.println("\n=== PENGUJIAN SKENARIO PEMESANAN ===");

        // valid (normal)
        System.out.println("\n[Skenario 1 - Normal] Memesan 5 Pizza (Stok awal 20):");
        menu.pesanMakanan(0, 5); // Harusnya berhasil, sisa 15

        // >stok
        System.out.println("\n[Skenario 2 - Over] Memesan 50 Spaghetti (Stok awal 20):");
        menu.pesanMakanan(1, 50); // Harusnya gagal

        // input negatif
        System.out.println("\n[Skenario 3 - Negatif] Memesan -2 Tenderloin Steak:");
        menu.pesanMakanan(2, -2); // Harusnya ditolak pesanan tidak valid

        // input pesanan = 0
        System.out.println("\n[Skenario 4 - Nol] Memesan 0 Tenderloin Steak:");
        menu.pesanMakanan(2, 0); // Harusnya ditolak pesanan tidak valid

        System.out.println("\n[Skenario 5 - Habis] Memesan 30 Chicken Steak (Stok awal 30):");
        menu.pesanMakanan(3, 30); // Harusnya berhasil, sisa 0

        System.out.println("\n[Skenario 6 - Out of Stock] Memesan 1 Chicken Steak lagi:");
        menu.pesanMakanan(3, 1); // Harusnya gagal, stok tidak mencukupi

        System.out.println("\n=== MENU SETELAH PEMESANAN ===");
        menu.tampilMenuMakanan();
    }
}