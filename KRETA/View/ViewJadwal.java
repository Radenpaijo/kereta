package View;

import Controller.ControllerJadwal;
import Node.Jadwal;
import Node.Kereta;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewJadwal {
    private ControllerJadwal kontrolJadwal;

    public ViewJadwal(ControllerJadwal kontrolJadwal) {
        this.kontrolJadwal = kontrolJadwal;
    }

    public void jadwalView() {
        Scanner input = new Scanner(System.in);
        int pilih;
        x:
        while (true) {
            String tabel = "| %-20s |%n";
            System.out.format("+----------------------+%n");
            System.out.format(tabel, "Menu Jadwal");
            System.out.format("+----------------------+%n");
            System.out.format(tabel, "1. Tambah Jadwal");
            System.out.format(tabel, "2. Lihat Jadwal");
            System.out.format(tabel, "3. Hapus Jadwal");
            System.out.format(tabel, "4. Cari Jadwal");
            System.out.format(tabel, "5. Kembali");
            System.out.format("+----------------------+%n");
            System.out.print("| Pilih : ");
            pilih = input.nextInt();
            input.nextLine();
            System.out.println("+----------------------+");
            switch (pilih) {
                case 1:
                    insertJadwal();
                    break;
                case 2:
                    viewJadwal();
                    break;
                case 3:
                    deleteKereta();
                    break;
                case 4:
                    searchJadwal();
                    break;
                case 5:
                    System.out.println("Kembali");
                    break x;
                default:
                    System.out.println("INVALID INPUT!");
                    break;
            }
        }
    }

    public void viewJadwal() {
        System.out.println("- Menampilkan Jadwal -");
        System.out.println("========================================");
        for (Jadwal jadwal : kontrolJadwal.viewAllJadwal()) {
            jadwal.setTanggal(jadwal.kodeJadwal);
            System.out.println("Kereta " + jadwal.kereta.nama);
            System.out.println("Kota Awal : " + jadwal.kotaAwal);
            System.out.println("Kota Tujuan : " + jadwal.kotaTujuan);
            System.out.println("Jam : " + jadwal.jam);
            System.out.println("Harga : " + jadwal.harga);
            System.out.println("========================================");
        }
    }

    public void insertJadwal() {
        Scanner input = new Scanner(System.in);
        System.out.println("- Tambah Jadwal -");
        System.out.print("Masukkan Kode Jadwal\t : ");
        int kode = input.nextInt();
        input.nextLine();
        System.out.print("Masukkan Nama Lokomotif\t : ");
        String nama = input.nextLine();
        System.out.print("Masukkan Kota Awal\t : ");
        String kotaAwal = input.nextLine();
        System.out.print("Masukkan Kota tujuan\t : ");
        String kotaTujuan = input.nextLine();
        System.out.print("Masukkan Jam keberangkatan\t : ");
        String jam = input.nextLine();
        System.out.print("Masukkan Harga Tiket\t :");
        int harga = input.nextInt();
        kontrolJadwal.insertJadwal(kode, nama, kotaAwal, kotaTujuan, jam, harga);
    }

    public void searchJadwal() {
        Scanner input = new Scanner(System.in);
        System.out.println("- Pencarian Jadwal -");
        System.out.print("Masukkan Kota Awal : ");
        String kotaAwal = input.nextLine();
        System.out.print("Masukkan Kota Tujuan : ");
        String kotaTujuan = input.nextLine();
        ArrayList<Jadwal> listJadwal = kontrolJadwal.searchJadwal(kotaAwal, kotaTujuan);
        if (listJadwal == null) {
            System.out.println("jadwal TIDAK DITEMUKAN!");
        } else {
            System.out.println("- Jadwal Ditemukan -");
            for (Jadwal jadwal : listJadwal){
                jadwal.setTanggal(jadwal.kodeJadwal);
                System.out.println("Kereta " + jadwal.kereta.nama);
                System.out.println("Kota Awal : " + jadwal.kotaAwal);
                System.out.println("Kota Tujuan : " + jadwal.kotaTujuan);
                System.out.println("Jam : " + jadwal.jam);
                System.out.println("Harga : " + jadwal.harga);
                System.out.println("========================================");
            }
        }
    }
    public void deleteKereta(){
        Scanner input = new Scanner(System.in);
        System.out.println("- Tambah Jadwal -");
        System.out.print("Masukkan Kode Jadwal\t : ");
        int kode = input.nextInt();
        System.out.print("Masukkan Nama Lokomotif\t : ");
        String nama = input.nextLine();
        System.out.print("Masukkan Kota Awal\t : ");
        String kotaAwal = input.nextLine();
        System.out.print("Masukkan Kota tujuan\t : ");
        String kotaTujuan = input.nextLine();
        kontrolJadwal.deleteJadwal(kode, nama, kotaAwal, kotaTujuan);
    }
}

