package Tubes;

import java.util.ArrayList;
import java.util.Scanner;

import sebelasokt.bank;

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
        String pil;
        do {

            System.out.println("A.\tLogin");
            System.out.println("B.\tregister");
            System.out.println("X.\tKeluar");
            pil = inp.nextLine();

            switch (pil) {
                case "a":
                case "A":
                    login();
                    break;

                case "b":
                case "B":
                    registrasi();
                    break;

                default:
                    break;
            }

        } while (!pil.equalsIgnoreCase("X"));

    }

    static void login() {
        System.out.print("Masukkan username: ");
        String USname = inp.nextLine();
        System.out.print("Masukkan Password: ");
        String Pass = inp.nextLine();

        

        if ((USname.equals(nameadmin)) && (Pass.equals(pwadmin))) {
            menuAdmin();

        } else {
            boolean temp = true;
            for (User cari : users) {
                if (cari.getusername().equals(USname)) {
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

    static void registrasi(){
        System.out.println("masukkan username: ");
        String USname = inp.nextLine();
        System.out.println("masukkan password: ");
        String Pass = inp.nextLine();

        boolean temp= true;

        for (User cari : users) {
                if ((cari.getusername().equals(USname))||nameadmin.equals(USname)) {
                   System.out.println("username anda telah digunakan");
                    temp = false;
                    break;
                }
            }
        if (temp) {
            User users = new User(USname, Pass);
            // users.add(new User(USname, Pass));
        }

    }

    static void menuAdmin() {
        System.out.println("Welcome, Admin!");
        System.out.println("Tambah Stock");
        System.out.println("view Stock");
        System.out.println("Ganti Password");
        System.out.println("View Username Terdaftar");
        System.out.println("Report Penjualan");
        System.out.println("Logout");
        System.out.print("Pilihan: ");
        String Pil = inp.nextLine();

        switch (Pil) {
            case value:
                
                break;
        
            default:
                break;
        }
//add stock
// -view stok
// -ganti password
// -view username terdaftar
// -reporting penjualan perkategori (harga dan jumlah item)
// -logout
// -regist admin baru
// // 
    }

    static void menuCustomer() {
        System.out.println("Welcome, Customer!");
        // Add customer-specific functionality here
    }
}

class User {
    String username;
    String password;
    

    User(String username, String password) {
        this.username = username;
        this.password = password;
        
    }

    // static void setusername(username){
    //     this.username=username;
    // }

    // static void setpassword(password){
    //     this.password=password;
    // }

    String getusername() {
        return username;
    }

    String getpassword() {
        return password;
    }

   
}

class Item {
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
