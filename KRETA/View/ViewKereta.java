package View;

import java.util.Scanner;
import Controller.ControllerKereta;

import Node.Kereta;

public class ViewKereta {

    private ControllerKereta kontrolKereta;

    public ViewKereta(ControllerKereta kontrolKereta) {
        this.kontrolKereta = kontrolKereta;
    }
    public void keretaView(){
        Scanner input = new Scanner(System.in);
        int pilih;
        x: while (true){
            String tabel = "| %-20s |%n";
            System.out.format("+----------------------+%n");
            System.out.format(tabel, "Menu Kereta");
            System.out.format("+----------------------+%n");
            System.out.format(tabel, "1. Tambah Kereta");
            System.out.format(tabel, "2. Lihat Kereta");
            System.out.format(tabel, "3. Update Kereta");
            System.out.format(tabel, "4. Hapus Kereta");
            System.out.format(tabel, "5. Cari Kereta");
            System.out.format(tabel, "6. Kembali");
            System.out.format("+----------------------+%n");
        System.out.print("| Pilih : ");
        pilih = input.nextInt();
        input.nextLine();
        System.out.println("+----------------------+");
            switch (pilih) {
                case 1:
                    insertKereta();
                    break;
                case 2:
                    viewKereta();
                    break;
                case 3:
                    updateKereta();
                    break;
                case 4:
                    deleteKereta();
                    break;
                case 5:
                    searchKereta();
                    break;
                case 6:
                    System.out.println("Kembali");
                    break x;
                default:
                    System.out.println("INVALID INPUT!");
                    break;
            }
        }
    }

    public void viewKereta(){
        System.out.println("- Menampilkan Data Kereta -");
        System.out.println("========================================");
        for(Kereta kereta : kontrolKereta.viewAllKereta()){
            System.out.println("Nama \t\t: "+kereta.nama);
            System.out.println("Jumlah Gerbong \t: "+kereta.jumlahGerbong);
            System.out.println("Kapasitas\t: "+kereta.kapasitas+" Orang");
            System.out.println("Jumlah Tempat Duduk : "+kereta.duduk+" / Gerbong");
            System.out.println("========================================");
        }
    }

    public void insertKereta(){
        Scanner input = new Scanner(System.in);
        System.out.println("- Tambah Kereta -");
        System.out.print("Masukkan Nama Kereta\t : ");
        String nama = input.nextLine();
        System.out.print("Masukkan Kode Kereta\t : ");
        int kode = input.nextInt();
        System.out.print("Masukkan Jumlah Gerbong\t : ");
        int jumlahGerbong = input.nextInt();
        System.out.println("Kereta Berhasil Di Tambahkan");
        kontrolKereta.insertKereta(nama, jumlahGerbong);
    }

    public void updateKereta(){
        Scanner input = new Scanner(System.in);
        System.out.println("- Update Kereta -");
        System.out.print("Masukkan Nama Kereta : ");
        String nama = input.nextLine();
        Kereta kereta = kontrolKereta.searchKereta(nama);
        if(kereta == null){
            System.out.println("KERETA TIDAK DITEMUKAN!");
        }else{
            System.out.println("Ubah Jumlah Gerbong : ");
            int newGerbong = input.nextInt();
            System.out.println("Kereta Berhasil Di Update");
            kontrolKereta.updateKereta(nama, newGerbong);
        }
    }

    public void deleteKereta(){
        Scanner input = new Scanner(System.in);
        System.out.println("- Hapus Kereta -");
        System.out.print("Masukkan Nama Kereta : ");
        String nama = input.nextLine();
        Kereta kereta = kontrolKereta.searchKereta(nama);
        if(kereta == null){
            System.out.println("KERETA TIDAK DITEMUKAN!");
        }else{
            System.out.println("- Kereta Berhasil Di Hapus -");
            kontrolKereta.deleteKereta(kereta.nama);
        }
    }

    public void searchKereta(){
        Scanner input = new Scanner(System.in);
        System.out.println("- Pencarian Kereta -");
        System.out.print("Masukkan Nama Kereta : ");
        String nama = input.nextLine();
        Kereta kereta = kontrolKereta.searchKereta(nama);
        if (kereta == null) {
            System.out.println("Kereta TIDAK DITEMUKAN!");
        }else{
            System.out.println("- Kereta Ditemukan -");
            System.out.println("Nama \t\t: "+kereta.nama);
            System.out.println("Jumlah Gerbong \t: "+kereta.jumlahGerbong);
            System.out.println("Kapasitas\t: "+kereta.kapasitas+" Orang");
            System.out.println("Jumlah Tempat Duduk : "+kereta.duduk+" / Gerbong");
        }
    }
}
