package View;

import Controller.ControllerPemesanan;
import Model.ModelJadwal;
import Model.ModelPemesanan;
import Node.Jadwal;
import Node.Pemesanaan;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewPemesanan {

    private ControllerPemesanan controllerPemesanan;
    private ModelJadwal modelJadwal;

    public ViewPemesanan(ControllerPemesanan controllerPemesanan){
        this.controllerPemesanan = controllerPemesanan;
    }

    public void insertPemesanan(){
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan Kode Kereta : ");
        int kode = input.nextInt();
  //      ArrayList<Jadwal> listJadwal = modelJadwal.searchKodeJadwal(kode);
        System.out.print("Masukkan kota awal\t: ");
        String kotaAwal = input.nextLine();
        System.out.println("Masukkan kota Tujuan : ");
        String  kotaTujuan = input.nextLine();
    }
    public void viewPemesanan(){
        System.out.println("- Menampilkan Pemesanan -");
        System.out.println("========================================");
        for (Pemesanaan pemesanaan : controllerPemesanan.viewAllPemesanan()){
            System.out.println("Nama : "+pemesanaan.user.nama);
            System.out.println(pemesanaan.jadwal.kereta.nama);
            System.out.println("Kota Awal Kereta : "+pemesanaan.jadwal.kotaAwal);
            System.out.println("Kota Tujuan : "+pemesanaan.jadwal.kotaTujuan);
            System.out.println("Jumlah Tiket : "+pemesanaan.jumlah +" Orang");
            System.out.println("Total Harga : "+pemesanaan.total);
            System.out.println("========================================");
        }
    }
}
