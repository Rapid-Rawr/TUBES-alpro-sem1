package Tubes;

// package Tubes.v1.v2;

import java.util.ArrayList;
import java.util.Scanner;

public class kel7 {
    static kel7 rawr = new kel7();
    static Scanner inp = new Scanner(System.in);
    static ArrayList<User> users = new ArrayList<>();
    static ArrayList<Item> items = new ArrayList<>();
    static ArrayList<Pembayaran> bayaran = new ArrayList<>();
    static ArrayList<String> adminhistori = new ArrayList<>();
    static ArrayList<Pembayaran> history = new ArrayList<>();
    static String nameadmin = "admin";
    static String pwadmin = "admin";

    public static void main(String[] args) {
        Item monitor = new Item("monitor", 1000000, 5);
        items.add(monitor);
        Item mouse = new Item("mouse", 100000, 5);
        items.add(mouse);
        Item speaker = new Item("speaker", 500000, 5);
        items.add(speaker);
        Item headphone = new Item("headphone", 300000, 5);
        items.add(headphone);
        Item keyboard = new Item("keyboard", 400000, 5);
        items.add(keyboard);
        Item webcam = new Item("webcam", 200000, 5);
        items.add(webcam);
        Item cpu = new Item("cpu", 2000000, 5);
        items.add(cpu);
        runthis();

    }

    static void runthis() {
        mainmenu();

    }

    static void mainmenu() {
        int pil;
        while (true) {
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

                case 3 : 
                System.out.println("Terima kasih!");
                System.exit(0);
                break;

                default:
                    System.out.println("Pilihan Tidak Tersedia");
                    break;
            }

        } 
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
            adminhistori.add(USname);
            boolean temp = true;
            for (User cari : users) {
                if (cari.getusername().equals(USname) && cari.getpassword().equals(Pass)) {
                    rawr.menuCustomer();
                    temp = false;
                    break;
                }
            }
            if (temp) {
                System.out.println("akun anda belum terdaftar, silahkan registrasi terlebih dahulu");

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
            System.out.println("Selamat, Anda Telah Terdaftar!");
        }

    }

    static void menuAdmin() {
        System.out.println("---------------------");
        System.out.println("Welcome, Admin!");
        System.out.println("1.Tambah Stock");
        System.out.println("2.Kurang Stock");
        System.out.println("3.view Stock");
        System.out.println("4.View Username Terdaftar");
        System.out.println("5.Report Penjualan");
        System.out.println("6.Logout");
        System.out.print("Pilihan: ");
        int Pil = inp.nextInt();
        clearConsole();

        switch (Pil) {
            case 1:
                addStock();
                break;
            case 2:
                KurangStok();
                break;
            case 3:
                viewStok();
                break;
            case 4:
                viewAllUser();
                break;
            case 5:
                sellReport();
                break;
            case 6:
                mainmenu();
                break;
            default:
                break;
        }
    }

    static void addStock() {
        int pil;
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
        if (pil == 8) {
            menuAdmin();
        } else {
            pil = pil - 1;
            // System.out.println("Tambah Stok");
            System.out.print("Jumlah Tambah = ");
            int jumlah = inp.nextInt();
            clearConsole();
            items.get(pil).setstok(items.get(pil).getstok() + jumlah);
            System.out.println("List Stok Terbaru");
            for (Item cari : items) {
                System.out.println(cari.getNama() + " Stok : " + cari.getstok() + " Harga Rp." + cari.getHarga());
            }
            addStock();
        }
    }

    static void KurangStok() {
        int pil;
        System.out.println("---------------------");
        System.out.println("Menu Kurang Stok");
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
        if (pil == 8) {
            menuAdmin();
        } else {
            pil = pil - 1;
            // System.out.println("Kurang Stok");
            System.out.print("Jumlah Kurang = ");
            int jumlah = inp.nextInt();
            clearConsole();
            System.out.println("List Stok Terbaru");
            items.get(pil).setstok(items.get(pil).getstok() - jumlah);
            for (Item cari : items) {
                System.out.println(cari.getNama() + " Stok : " + cari.getstok() + " Harga Rp." + cari.getHarga());
            }
            KurangStok();
        }
    }

    static void viewStok() {
        System.out.println("---------------------");
        System.out.println("Stok Barang Saat Ini : ");
        for (Item cari : items) {
            System.out.println(cari.getNama() + " Stok  : " + cari.getstok() + " Harga : " + cari.getHarga());
        }
        menuAdmin();
    }

    static void viewAllUser() {
        System.out.println("---------------------");
        if (!users.isEmpty()) {
            System.out.println("User Yang Terdaftar : ");
            int temp = 0;
            for (User cari : users) {
                temp+=1;
                System.out.println(temp+cari.getusername());
            }

        }
        if (users.isEmpty()) {
            System.out.println("Belum Ada User");
        }

        menuAdmin();
    }

    static void sellReport() {
        long total = 0;
        System.out.println("---------------------");
        System.out.println("List Customer : ");
        for (int i = 0; i < adminhistori.size(); i++) {
            System.out.println("User : " + adminhistori.get(i));
        }
        System.out.println("List Barang Terjual : ");
        for (int i = 0; i < history.size(); i++) {
            total += history.get(i).getharga() * history.get(i).getjumlah();
            System.out.println(
                    history.get(i).getnama() + " " + history.get(i).getjumlah() + " Rp." + history.get(i).getharga());
        }
        System.out.println("Total Pendapatan : Rp." + total);
        menuAdmin();
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
            System.out.println("---------------------");

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

        System.out.println("---------------------");
        System.out.println("1.Tambah Keranjang");
        System.out.println("2.Kurangi keranjang");
        System.out.println("3.Kembali");
        System.out.print("Pilihan: ");
        int Pilihan = inp.nextInt();
        clearConsole();

        switch (Pilihan) {
            case 1:
                System.out.println("List Barang Toko Rawr");
                System.out.println("---------------------");
                for (Item cari : items) {
                    System.out.println(cari.getNama() + "\nStok : " + cari.getstok() + " Rp." + cari.getHarga());
                }
                System.out.print("Barang yang ingin di beli: ");
                String brg = inp.next();
                System.out.print("Jumlah Barang: ");
                int jmlbrg = inp.nextInt();
                boolean cek = true;
                clearConsole();

                for (Pembayaran carikategori : bayaran) {
                    if (carikategori.getnama().equals(brg)) {
                        cek = false;
                        for (Item cari : items) {
                            if (cari.getNama().equals(brg)) {
                                if (cari.getstok() < jmlbrg + carikategori.getjumlah()) {
                                    System.out.println("stok tidak cukup");
                                } else {
                                    int temp = carikategori.getjumlah() + jmlbrg;
                                    carikategori.setjumlah(temp);
                                    System.out.println("Barang Ditambahkan ke Keranjang");
                                }
                            }
                        }
                    }
                }
                if (cek) {
                    for (Item cari : items) {
                        if (cari.getNama().equalsIgnoreCase(brg)) {
                            if (cari.getstok() >= jmlbrg) {
                                Pembayaran barubayar = new Pembayaran(brg, jmlbrg, cari.getHarga());
                                bayaran.add(barubayar);
                                System.out.println("Ditambahkan ke keranjang");
                                break;
                            } else if (cari.getstok() < jmlbrg) {
                                System.out.println("stok tidak cukup");
                            } else {
                                System.out.println("Barang Tidak Ada");
                            }
                        }
                    }
                }
                break;

            case 2:
                System.out.println("List Barang Di Keranjang");
                System.out.println("---------------------");
                for (Pembayaran cari : bayaran) {
                    System.out.println(cari.getnama() + " " + cari.getjumlah());
                }
                if (bayaran.isEmpty()) {
                    System.out.println("Belum Ada Barang Yang Di Masukkan Ke Keranjang");
                }
                System.out.println("---------------------");
                System.out.print("Barang yang ingin di kurangi: ");
                String namakrg = inp.next();
                System.out.print("Jumlah Pengurangan: ");
                int jmlkrg = inp.nextInt();
                System.out.println("---------------------");
                clearConsole();
                hapus(namakrg, jmlkrg);
                break;

            case 3:
                menuCustomer();
            default:
                System.out.println("pilihan tidak tersedia");
                break;
        }
    }

    static void hapus(String barang, int jumlah) {

        boolean tr = true;
        for (Pembayaran cari : bayaran) {
            if (cari.getnama().equals(barang)) {
                tr = false;
                for (Item carijml : items) {
                    if (carijml.getNama().equals(cari.getnama())) {
                        if ((carijml.getstok() < cari.getjumlah() - jumlah) && (carijml.getstok() >= 0)) {
                            System.out.println("stok tidak cukup");
                        } else {
                            int temp = cari.getjumlah() - jumlah;
                            cari.setjumlah(temp);
                            System.out.println("Barang Telah Di Kurangi ");
                        }
                    }
                }
                System.out.println("Barang anda sekarang: ");
                for (Pembayaran krnj : bayaran) {
                    System.out.println(krnj.getnama() + " " + krnj.getjumlah());
                }
            }
        }
        if (tr) {
            System.out.println("barang tidak di temukan");
        }
    }

    public void pembayaran() {

        if (bayaran.isEmpty()) {
            System.out.println("Belum ada barang yang di masukkan ke keranjang");
        } else {
            int total = 0;
            for (Pembayaran cari : bayaran) {
                System.out.println(cari.getnama() + " " + cari.getjumlah());
                System.out.println("Harga Satuan: " + cari.getharga());
                total += cari.getharga() * cari.getjumlah();
            }
            System.out.println("Total Harga: Rp." + total);
            System.out.println("---------------------");
            System.out.println("Konfirmasi Pembelian : " + "\n 1.Ya" + "\n 2.Tidak");
            System.out.println("---------------------");
            System.out.print("Pilihan: ");
            int confirm = inp.nextInt();
            if (confirm == 1) {
                for (Pembayaran cari : bayaran) {
                    int jumlah = cari.getjumlah();
                    String xnamaitemk = cari.getnama();
                    for (Item dataitems : items) {
                        if (xnamaitemk.equals(dataitems.getNama())) {
                            int jumlahitem = dataitems.getstok() - jumlah;
                            dataitems.setstok(jumlahitem);
                        }
                    }
                }
                history.addAll(bayaran);
                bayaran.removeAll(bayaran);
                System.out.println("Terimakasih Telah Berbelanja Di Toko Rawr");
            } else if (confirm == 2) {
                menuCustomer();
            }
        }
    }

    public void histori() {
        int total = 0;
        System.out.println("---------------------");
        System.out.println("History Pembelian");
        for (Pembayaran cari : history) {
            System.out.println(cari.getnama() + "\nStok : " + cari.getjumlah() + " Rp." + cari.getharga());
            total += cari.getharga() * cari.getjumlah();
        }
        System.out.println("Total Harga: Rp." + total);
    }

    public void gantiPass() {
        System.out.print("Masukan Username: ");
        String username = inp.next();
        System.out.print("Masukkan Katasandi yang lama : ");
        String katasandi = inp.next();
        System.out.print("Masukan katasandi yang baru : ");
        String newkatasandi = inp.next();

        boolean cek = true;

        for (User cari : users) {
            if (cari.getusername().equals(username)) {
                cek = false;
                if (cari.getpassword().equals(katasandi)) {
                    cari.setpassword(newkatasandi);
                } else {
                    System.out.println("password anda salah");
                }
            }
        }
        if (cek) {
            System.out.println("Username Not Found!");
        }
    }

    public void logout() {
        mainmenu();
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

    public Item(String nama, double harga, int stok) {
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

    public void setjumlah(int tambahan) {
        jumlah = tambahan;
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
}
