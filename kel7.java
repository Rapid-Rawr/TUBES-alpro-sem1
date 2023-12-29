package Tubes;

import java.util.ArrayList;
import java.util.Scanner;

public class kel7 {

    static kel7 rawr = new kel7();
    static Scanner inp = new Scanner(System.in);
    static ArrayList<User> users = new ArrayList<>();
    static ArrayList<Item> items = new ArrayList<>();
    static ArrayList<Pembayaran> bayaran = new ArrayList<>();
    static ArrayList<Transaksi> transaksi = new ArrayList<>();
    static String nameadmin = "ADMIN";
    static String pwadmin = "admin123";

    public static void main(String[] args) {
        runthis();
    }

    static void runthis() {
        Item monitor = new Item("monitor", 1000.000, 5);
        items.add(monitor);
        Item mouse = new Item("mouse", 100.000, 5);
        items.add(mouse);
        Item speaker = new Item("speaker", 500.000, 5);
        items.add(speaker);
        Item headphone = new Item("headphone", 300.000, 5);
        items.add(headphone);
        Item keyboard = new Item("keyboard", 400.000, 5);
        items.add(keyboard);
        Item webcam = new Item("webcam", 200.000, 5);
        items.add(webcam);
        Item cpu = new Item("cpu", 2000.000, 5);
        items.add(cpu);

        mainmenu();

    }

    static void mainmenu() {
        int pil;
        do {
            System.out.println("---------------------");
            System.out.println("1.Login");
            System.out.println("2.Register");
            System.out.println("3.Keluar");
            System.out.print("Pilihan: ");
            pil = inp.nextInt();

            clearConsole();
            switch (pil) {
                case 1:
                    login();
                    break;

                case 2:
                    registrasi();
                    break;

                default:
                    break;
            }

        } while (pil < 3);
    }

    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    static void login() {
        System.out.println("---------------------");
        System.out.print("Masukkan Username : ");
        String USname = inp.next();
        System.out.print("Masukkan Password : ");
        String Pass = inp.next();

        if ((USname.equals(nameadmin)) && (Pass.equals(pwadmin))) {
            menuAdmin();

        } else {
            boolean temp = true;
            for (User cari : users) {
                if (cari.getusername().equals(USname) && cari.getpassword().equals(Pass)) {
                    rawr.menuCustomer();
                    temp = false;
                    break;
                }
            }
            if (temp) {
                System.out.println("akun anda belum terdaftar, silahkan registrasi terlebih dahuluan");

            }
        }
    }

    static void registrasi() {
        System.out.println("---------------------");
        System.out.print("Masukkan Username : ");
        String USname = inp.next();
        System.out.print("Masukkan Password : ");
        String Pass = inp.next();

        boolean temp = true;

        for (User cari : users) {
            if ((cari.getusername().equals(USname)) || nameadmin.equals(USname)) {
                System.out.println("username anda tidak ditemukan atau telah digunakan");
                temp = false;
                break;
            }
        }
        if (temp) {
            String nick = USname, Pwrd = Pass;
            users.add(new User(nick, Pwrd));
        }

    }

    static void menuAdmin() {
        System.out.println("---------------------");
        System.out.println("Welcome, Admin!");
        System.out.println("1.Tambah Stock");
        System.out.println("2.Kurang Stock");
        System.out.println("3.view Stock");
        System.out.println("4.Ganti Password");
        System.out.println("5.View Username Terdaftar");
        System.out.println("6.Report Penjualan");
        System.out.println("7.Logout");
        System.out.print("Pilihan: ");
        int Pil = inp.nextInt();

        switch (Pil) {
            case 1:
                addStock();
                break;
            case 2:
                KurangStok();
                break;
            case 3:
                addStock();
                break;
            case 4:
                addStock();
                break;
            default:
                break;
        }
        // add stock
        // -view stok
        // -ganti password
        // -view username terdaftar
        // -reporting penjualan perkategori (harga dan jumlah item)
        // -logout
        // -regist admin baru
        // //
    }

    static void addStock() {
        int pil;
        do {
            System.out.println("---------------------");
            System.out.println("Menu Tambah Stok");
            System.out.println("1.Monitor");
            System.out.println("2.Mouse");
            System.out.println("3.Speaker");
            System.out.println("4.Headphone");
            System.out.println("5.Keyboard");
            System.out.println("6.Webcam");
            System.out.println("7.CPU");
            System.out.println("8.Kembali");
            System.out.print("Pilihan: ");
            pil = inp.nextInt();

            switch (pil) {
                case 1:
                    System.out.println("Tambah Stok Monitor");
                    System.out.println("Pilih Jumlah : ");
                    int jumlah = inp.nextInt();
                    asd.tambahStok(jumlah);
                    break;
                // case 2:
                // keranjang();
                // break;
                // case 3:
                // histori();
                // break;
                // case 4:
                // gantiPass();
                // break;
                // case 5:
                // logout();
                // break;
                // default:
                // break;
            }

        } while (pil < 6 && pil != 5);
    }

    static void KurangStok() {
        int pil;
        do {
            System.out.println("---------------------");
            System.out.println("Menu Kurangi Stok");
            System.out.println("1.Monitor");
            System.out.println("2.Mouse");
            System.out.println("3.Speaker");
            System.out.println("4.Headphone");
            System.out.println("5.Keyboard");
            System.out.println("6.Webcam");
            System.out.println("7.CPU");
            System.out.println("8.Kembali");
            System.out.print("Pilihan: ");
            pil = inp.nextInt();

            switch (pil) {
                case 1:
                    System.out.println("Kurang Stok Monitor");
                    System.out.println("Pilih Jumlah : ");
                    int jumlah = inp.nextInt();
                    asd.kurangStok(jumlah);
                    break;
                // case 2:
                // keranjang();
                // break;
                // case 3:
                // histori();
                // break;
                // case 4:
                // gantiPass();
                // break;
                // case 5:
                // logout();
                // break;
                // default:
                // break;
            }

        } while (pil < 6 && pil != 5);
    }

    void menuCustomer() {
        int pil;
        do {
            System.out.println("---------------------");
            System.out.println("Welcome, Customer!");
            System.out.println("1.Keranjang");
            System.out.println("2.Pembayaran");
            System.out.println("3.Histori Pembelian");
            System.out.println("4.Ganti Password");
            System.out.println("5.Logout");
            System.out.print("Pilihan: ");
            pil = inp.nextInt();

            clearConsole();

            switch (pil) {
                case 1:
                    keranjang();
                    break;
                case 2:
                    pembayaran();
                    break;
                case 3:
                    histori();
                    break;
                case 4:
                    gantiPass();
                    break;
                case 5:
                    logout();
                    break;
                default:
                    break;
            }

        } while (pil < 6 && pil != 5);
    }

    public void keranjang() {

        System.out.println("1.Tambah Keranjang");
        System.out.println("2.Kurangi keranjang");
        System.out.print("Pilihan: ");
        String Pilihan = inp.nextLine();

        switch (Pilihan) {
            case "1":
                System.out.println("List Barang Toko Rawr");
                for (Item cari : items) {
                    System.out.println(cari.getNama() + " " + cari.getstok() + " " + cari.getHarga());
                }
                System.out.print("Barang yang ingin di beli: ");
                String brg = inp.next();
                System.out.print("Jumlah Barang: ");
                int jmlbrg = inp.nextInt();

                for (Item cari : items) {
                    if (cari.getNama().equals(brg)) {
                        if (cari.getstok() >= jmlbrg) {
                            Pembayaran barubayar = new Pembayaran(brg, jmlbrg, cari.getHarga());
                            bayaran.add(barubayar);
                            System.out.println("Ditambahkan ke Pembayaran");
                        } else {
                            System.out.println("stok tidak cukup");
                        }
                    }
                }
                break;

            case "2":
                System.out.println("List Barang Toko Rawr");
                for (Item cari : items) {
                    System.out.println(cari.getNama() );
                }
                System.out.print("Barang yang ingin di kurangi: ");
                String krg = inp.next();

                for (Pembayaran cari : bayaran) {
                    if (cari.getNama().equals(krg)) {
                        cari.remove();
                        System.out.println("Pesanan Telah Dihapus");
                    }
                }
                break;

            default:
            System.out.println("pilihan tidak tersedia");
                break;
        }

    }

    public void pembayaran() {

        if (bayaran.isEmpty()) {
            System.out.println("Belum ada barang yang di masukkan ke keranjang");
        }else{
            int total = 0;
            for (Pembayaran cari : bayaran) {
                System.out.println(cari.getnama() + " " + cari.getjumlah());
                System.out.println("Harga Satuan: " + cari.getharga());
                total += cari.getharga() * cari.getjumlah();
            }
            System.out.println("Total Harga: Rp." + total);
        }
    }

    public void histori() {

    }

    public void gantiPass() {
        System.out.print("Masukan Username: ");
        String username = inp.next();
        System.out.print("Masukkan Katasandi yang lama: ");
        String katasandi = inp.next();
        System.out.print("Masukan katasandi yang baru: ");
        String newkatasandi = inp.next();

        for (User cari : users) {
            if (cari.getusername().equals(username)) {
                if (cari.getpassword().equals(katasandi)) {
                    cari.setpassword(newkatasandi);
                } else {
                    System.out.println("password anda salah");
                }
            }
        }

    }

    public void logout() {
        mainmenu();
    }

    public void viewStokAdv() {

    }

    public void gantiPassAdm() {

    }

    public void viewAllUser() {

    }

    public void sellReport() {

    }

    public void logoutadm() {

    }
}

class User {
    String username;
    String password;

    User(String username, String password) {
        this.username = username;
        this.password = password;

    }

    void setusername(String username) {
        this.username = username;
    }

    void setpassword(String password) {
        this.password = password;
    }

    String getusername() {
        return username;
    }

    String getpassword() {
        return password;
    }

}

class Item {
    String nama;
    double harga;
    int stok;

    Item(String nama, double harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    void setNama(String nama) {
        this.nama = nama;
    }

    void setHarga(double harga) {
        this.harga = harga;
    }

    void setstok(int stoknw) {
        this.stok = stoknw;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public int getstok() {
        return stok;
    }

    public void tambahStok(int jumlah) {
        if (jumlah >= 0) {
            stok += jumlah;
            System.out.println("Stok " + nama + " ditambahkan sebanyak " + jumlah + ". Stok sekarang: " + stok);
        } else {
            System.out.println("Jumlah tambahan stok harus non-negatif.");
        }
    }

    public void kurangStok(int jumlah) {
        if (jumlah >= 0 && stok >= jumlah) {
            stok -= jumlah;
            System.out.println("Stok " + nama + " dikurangkan sebanyak " + jumlah + ". Stok sekarang: " + stok);
        } else if (jumlah < 0) {
            System.out.println("Jumlah pengurangan stok harus non-negatif.");
        } else {
            System.out.println("Stok tidak mencukupi untuk pengurangan sebanyak " + jumlah + ".");
        }
    }

    public void viewStok() {
        System.out.println("Stok " + nama + ": " + stok);
    }

    public double getTotalharga(int jumlah) {
        return jumlah * harga;
    }

}

class Pembayaran {

    String nama;
    int jumlah;
    double harga;

    Pembayaran(String nama, int jumlah, double harga) {

        this.nama = nama;
        this.jumlah = jumlah;
        this.harga = harga;
    }

    public String getnama() {
        return nama;
    }

    public int getjumlah() {
        return jumlah;
    }

    public double getharga() {
        return harga;
    }

    void pengkosongan() {
        nama = "belum terisi";
        jumlah = 0;
        harga = 0;
    }
}

class Transaksi {

    String tanggal;
    double totalBayar;
    String status;

    Transaksi(String tanggal, double totalBayar, String status) {

        this.tanggal = tanggal;
        this.totalBayar = totalBayar;
        this.status = status;
    }
}
