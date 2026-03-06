public class Restaurant {

    // ===== Attribute (Encapsulation) =====
    private String[] nama_makanan;
    private double[] harga_makanan;
    private int[] stok;
    private static byte id = 0;

    // ===== Constructor =====
    public Restaurant() {
        nama_makanan = new String[10];
        harga_makanan = new double[10];
        stok = new int[10];
    }

    // ===== Method Tambah Menu =====
    public void tambahMenuMakanan(String nama, double harga, int stok) {

        if (stok < 0) {
            System.out.println("Stok tidak boleh negatif!");
            return;
        }

        this.nama_makanan[id] = nama;
        this.harga_makanan[id] = harga;
        this.stok[id] = stok;
    }

    // ===== Tampilkan Menu =====
    public void tampilMenuMakanan() {
        for (int i = 0; i <= id; i++) {
            if (!isOutOfStock(i)) {
                System.out.println(
                        nama_makanan[i] + "[" + stok[i] + "]" +
                                "\tRp. " + harga_makanan[i]
                );
            }
        }
    }

    // ===== Cek Stok =====
    public boolean isOutOfStock(int id) {
        return stok[id] == 0;
    }

    // ===== Next ID =====
    public static void nextId() {
        id++;
    }

    // ===== Fitur Pemesanan =====
    public void pesanMakanan(int index, int jumlah) {

        if (jumlah <= 0) {
            System.out.println("Jumlah pesanan tidak valid!");
            return;
        }

        if (stok[index] >= jumlah) {
            stok[index] -= jumlah;
            System.out.println("Pesanan berhasil! Sisa stok: " + stok[index]);
        } else {
            System.out.println("Stok tidak mencukupi!");
        }
    }

    // ===== Getter & Setter =====
    public String[] getNama_makanan() {
        return nama_makanan;
    }

    public void setNama_makanan(String[] nama_makanan) {
        this.nama_makanan = nama_makanan;
    }

    public double[] getHarga_makanan() {
        return harga_makanan;
    }

    public void setHarga_makanan(double[] harga_makanan) {
        this.harga_makanan = harga_makanan;
    }

    public int[] getStok() {
        return stok;
    }

    public void setStok(int[] stok) {
        this.stok = stok;
    }

    public static byte getId() {
        return id;
    }

    public static void setId(byte id) {
        Restaurant.id = id;
    }
}
