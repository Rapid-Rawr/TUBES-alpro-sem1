package Tubes;

import java.util.ArrayList;
import java.util.Scanner;

public class kel7 {

    static Scanner inp = new Scanner(System.in);
    static ArrayList<User> users = new ArrayList<>();
    static ArrayList<Item> items = new ArrayList<>();
    static ArrayList<Transaksi> transaksi = new ArrayList<>();
    ArrayList<Integer> Keranjang = new ArrayList<>();
    static String nameadmin = "ADMIN";
    static String pwadmin = "admin123";

    public static void main(String[] args) {
        runthis();
    }

    static void runthis() {
        // Adding sample users
        int pil;
        do {
            System.out.println("---------------------");
            System.out.println("1.Login");
            System.out.println("2.Register");
            System.out.println("3.Keluar");
            pil = inp.nextInt();

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
                    menuCustomer();
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
                System.out.println("username anda telah digunakan");
                temp = false;
                break;
            }
        }
        if (temp) {
            String nick = USname, Pwrd = Pass;
            users.add(new User(nick, Pwrd));
            // User users = new User(USname, Pass);
            // users.add(new User(USname, Pass));
        }

    }

    static void menuAdmin() {
        System.out.println("---------------------");
        System.out.println("Welcome, Admin!");
        System.out.println("1.Tambah Stock");
        System.out.println("2.view Stock");
        System.out.println("3.Ganti Password");
        System.out.println("4.View Username Terdaftar");
        System.out.println("5.Report Penjualan");
        System.out.println("6.Logout");
        System.out.print("Pilihan: ");
        String Pil = inp.nextLine();

        switch (Pil) {
            // case :

            // break;

            // default:
            // break;
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

    static void menuCustomer() {
        CustomerMenus sp = new CustomerMenus();
        // cek stok
        // keranjang
        // histori pembelian
        // ganti pw
        // logot
        int pil;
        do {
            System.out.println("---------------------");
            System.out.println("Welcome, Customer!");
            System.out.println("1.Lihat Stock");
            System.out.println("2.Keranjang");
            System.out.println("3.Histori Pembelian");
            System.out.println("4.Ganti Password");
            System.out.println("5.Logout");
            System.out.print("Pilihan: ");
            pil = inp.nextInt();

            switch (pil) {
                case 1:
                    sp.lihatStok();
                    break;
                case 2:
                    sp.keranjang();
                    break;
                case 3:
                    sp.histori();
                    break;
                case 4:
                    sp.gantiPass();
                    break;
                case 5:
                    sp.logout();
                    break;
                default:
                    break;
            }

        } while (pil < 6 && pil != 5);
    }
}

class AdminMenus {
    public void addStock() {

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

class CustomerMenus {
    public void lihatStok() {

    }

    public void keranjang() {

    }

    public void histori() {

    }

    public void gantiPass() {

    }

    public void logout() {

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
    ArrayList<Item> items;
    String nama;
    String kategori;
    double harga;
    int stok;

    Item(String nama, String kategori, double harga, int stok) {
        this.nama = nama;
        this.kategori = kategori;
        this.harga = harga;
        this.stok = stok;
    }

    void setNama(String nama) {
        this.nama = nama;
    }

    void setKategori(String kategori) {
        this.kategori = kategori;
    }

    void setHarga(double harga) {
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public String getKategori() {
        return kategori;
    }

    public double getHarga() {
        return harga;
    }

}

class Transaksi {
    ArrayList<Item> items;
    String tanggal;
    double totalBayar;
    String status;

    Transaksi(ArrayList<Item> items, String tanggal, double totalBayar, String status) {
        this.items = items;
        this.tanggal = tanggal;
        this.totalBayar = totalBayar;
        this.status = status;
    }
}
