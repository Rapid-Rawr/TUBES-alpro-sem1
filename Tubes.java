package Tubes;

import java.util.ArrayList;
import java.util.Scanner;

public class Tubes {
    static Tubes rawr = new Tubes();
    static Scanner inp = new Scanner(System.in);
    static ArrayList<User> users = new ArrayList<>();
    static ArrayList<Item> items = new ArrayList<>();
    static ArrayList<Pembayaran> bayaran = new ArrayList<>();
    static ArrayList<String> adminhistori = new ArrayList<>();
    static ArrayList<Pembayaran> history = new ArrayList<>();
    static String nameadmin = "admin";
    static String pwadmin = "admin";
    static String nameuser = "null";

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
            System.out.println("Selamat Datang Di Toko RAWRRR!");
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

                case 3:
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
        System.out.println("Silahkan Masukkan Akun Anda");
        System.out.println("---------------------");
        System.out.print("Masukkan Username : ");
        String USname = inp.next();
        System.out.println("---------------------");
        System.out.print("Masukkan Password : ");
        String Pass = inp.next();

        nameuser = USname;

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
        System.out.println("===Daftarkan Akun Anda!===");
        System.out.print("Masukkan Username : ");
        String USname = inp.next();
        System.out.println("--------------------------");
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
        System.out.println("=====================");
        System.out.println("Welcome, Admin!");
        System.out.println("=====================");
        System.out.println("1.Tambah Stock");
        System.out.println("2.Tambah Barang");
        System.out.println("3.Kurang Stock");
        System.out.println("4.view Stock");
        System.out.println("5.View Username Terdaftar");
        System.out.println("6.Report Penjualan");
        System.out.println("7.Ganti Password dan Username");
        System.out.println("8.Logout");
        System.out.println("---------------------");
        System.out.print("Pilihan: ");
        int Pil = inp.nextInt();
        // clearConsole();

        switch (Pil) {
            case 1:
                addStock();
                break;
            case 2:
                addbarang();
                break;
            case 3:
                KurangStok();
                break;
            case 4:
                viewStok();
                break;
            case 5:
                viewAllUser();
                break;
            case 6:
                sellReport();
                break;
            case 7:
                gantipassadm();
                break;
            case 8:
                mainmenu();
                break;
            default:
                break;
        }
    }

    static void addbarang() {
        System.out.println("Menu Tambah Barang Baru");
        System.out.print("Nama Barang : ");
        String brgBaru = inp.next();
        System.out.print("Input Stok : ");
        int stokBaru = inp.nextInt();
        System.out.print("Input Harga : ");
        double hargaBrgBaru = inp.nextInt();
        items.add(new Item(brgBaru, hargaBrgBaru, stokBaru));
        menuAdmin();
    }

    static void gantipassadm() {
        System.out.print("Username Baru: ");
        String newusname = inp.next();
        System.out.print("Password Baru: ");
        String newpass = inp.next();
        System.out.println("Password Berhasil Diganti");

        nameadmin = newusname;
        pwadmin = newpass;
        menuAdmin();
    }

    static void addStock() {
        int pil;
        int i = 0;
        System.out.println("---------------------");
        System.out.println("Menu Tambah Stok : ");
        for (Item cari : items) {
            i++;
            System.out
                    .println(i + "." + cari.getNama() + " Stok  : " + cari.getstok() + " | Harga : " + cari.getHarga());
        }
        System.out.println("Exit [0]");
        System.out.print("Pilihan: ");
        pil = inp.nextInt();
        if (pil == 0) {
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
                addStock();
            }
        }
    }

    static void KurangStok() {
        int pil;
        int i = 0;
        System.out.println("---------------------");
        System.out.println("Menu Kurang Stok : ");
        for (Item cari : items) {
            i++;
            System.out
                    .println(i + "." + cari.getNama() + " Stok  : " + cari.getstok() + " | Harga : " + cari.getHarga());
        }
        System.out.println("Exit [0]");
        System.out.print("Pilihan: ");
        pil = inp.nextInt();
        if (pil == 0) {
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
                temp += 1;
                System.out.println(temp + ". " + cari.getusername());
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
        for (int i = 0; i < adminhistori.size(); i++) {
            System.out.println(adminhistori.get(i));
            for (Pembayaran cari : history) {
                if (adminhistori.get(i).equals(cari.getuser())) {
                    System.out.println( cari.getnama() + " " + cari.getjumlah() + " Rp." + cari.getharga());
                }
            }
        }
    }

    void menuCustomer() {
        int pil;
        do {
            System.out.println("=====================");
            System.out.println("Welcome, Customer!");
            System.out.println("=====================");
            System.out.println("1.Keranjang");
            System.out.println("2.Pembayaran");
            System.out.println("3.Histori Pembelian");
            System.out.println("4.Ganti Password");
            System.out.println("5.Logout");
            System.out.println("---------------------");
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

        System.out.println("---------------------");
        System.out.println("1.Tambah Keranjang");
        System.out.println("2.Kurangi keranjang");
        System.out.println("3.Kembali");
        System.out.print("Pilihan: ");
        int Pilihan = inp.nextInt();
        clearConsole();

        switch (Pilihan) {
            case 1:
                tambahcstm();
                break;

            case 2:
                kurangcstm();
                break;

            case 3:
                menuCustomer();
            default:
                System.out.println("pilihan tidak tersedia");
                break;
        }
    }

    public void tambahcstm() {
        System.out.println("List Barang Toko Rawr");
        System.out.println("---------------------");
        int temp = 0;
        for (Item cari : items) {
            temp += 1;
            System.out.println(temp + ". " + cari.getNama() + "\nStok : " + cari.getstok() + " Rp." + cari.getHarga());
        }
        System.out.print("Barang yang ingin di beli: ");
        int brg = inp.nextInt();
        System.out.print("Jumlah Barang: ");
        int jmlbrg = inp.nextInt();
        boolean cek = true;
        clearConsole();

        if (cek) {
            for (Item cari : items) {
                if (items.get(brg - 1).getNama().equals(cari.getNama()))
                    ;
                {
                    if (items.get(brg - 1).getstok() >= jmlbrg) {
                        Pembayaran barubayar = new Pembayaran(nameuser, items.get(brg - 1).getNama(), jmlbrg,
                                cari.getHarga());
                        bayaran.add(barubayar);
                        System.out.println("Ditambahkan ke keranjang");
                        break;
                    } else if (items.get(brg - 1).getstok() < jmlbrg) {
                        System.out.println("stok tidak cukup");
                        break;
                    } else {
                        System.out.println("Barang Tidak Ada");
                        break;
                    }
                }
            }
        }
    }

    public void kurangcstm() {
        System.out.println("List Barang Di Keranjang");
        System.out.println("---------------------");
        int temp = 0;
        for (Pembayaran cari : bayaran) {
            temp += 1;
            System.out.println(temp + ". " + cari.getnama() + " " + cari.getjumlah());
        }
        if (bayaran.isEmpty()) {
            System.out.println("Belum Ada Barang Yang Di Masukkan Ke Keranjang");
        }
        System.out.println("---------------------");
        System.out.print("Barang yang ingin di kurangi: ");
        int namakrg = inp.nextInt();
        System.out.print("Jumlah Pengurangan: ");
        int jmlkrg = inp.nextInt();
        System.out.println("---------------------");
        clearConsole();
        hapus(namakrg, jmlkrg);
    }

    static void hapus(int barang, int jumlah) {

        boolean tr = true;
        for (Pembayaran cari : bayaran) {
            if (cari.getnama().equals(bayaran.get(barang - 1).getnama())) {
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
        System.out.println("ppp");

        if (bayaran.isEmpty()) {
            System.out.println("Belum ada barang yang di masukkan ke keranjang");
        } else {
            int total = 0;
            for (Pembayaran cari : bayaran) {
                System.out.println(cari.getuser() + " " + cari.getnama() + " " + cari.getjumlah());
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
            System.out.println(
                    cari.getuser() + " " + cari.getnama() + "\nStok : " + cari.getjumlah() + " Rp." + cari.getharga());
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

    String IDuser;
    String nama;
    int jumlah;
    double harga;

    Pembayaran(String IDuser, String nama, int jumlah, double harga) {

        this.IDuser = IDuser;
        this.nama = nama;
        this.jumlah = jumlah;
        this.harga = harga;
    }

    public void setjumlah(int tambahan) {
        jumlah = tambahan;
    }

    public String getuser() {
        return IDuser;
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
