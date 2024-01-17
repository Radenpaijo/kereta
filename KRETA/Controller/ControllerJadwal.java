package Controller;

import Model.ModelJadwal;
import Model.ModelKereta;
import Node.Jadwal;
import Node.Kereta;

import java.util.ArrayList;

public class ControllerJadwal {
    private ModelJadwal modelJadwal;
    public ModelKereta modelKereta;

    public ControllerJadwal(ModelJadwal modelJadwal, ModelKereta modelKereta){
        this.modelJadwal = modelJadwal;
        this.modelKereta = modelKereta;
    }
    public ArrayList<Jadwal> viewAllJadwal(){
        return modelJadwal.getAllListJadwal();
    }
    public void insertJadwal(int kode, String nama, String kotaAwal, String kotaTujuan, String jam, int harga){
        Kereta kereta = modelKereta.searchKereta(nama);
        if(kereta == null){
            System.out.println("Kereta Tidak Ditemukan");
        }else {
            modelJadwal.addJadwal(new Jadwal(kotaAwal, kotaTujuan, jam, modelKereta.searchKereta(nama), kode, harga));
        }
    }
    public void deleteJadwal(int kode, String nama, String kotaAwal, String kotaTujuan){
        Jadwal jadwal = modelJadwal.searchKodeJadwal(kode);
        Kereta kereta = modelKereta.searchKereta(nama);

        if(jadwal == null && kereta == null){
            System.out.println("Jadwal Tidak Ditemukan");
        } else {
            if (jadwal.kotaAwal.equalsIgnoreCase(kotaAwal) && jadwal.kotaTujuan.equalsIgnoreCase(kotaTujuan)) {
                modelJadwal.deleteJadwal(jadwal);
                System.out.println("Jadwal berhasil dihapus");
            } else {
                System.out.println("Jadwal tidak sesuai dengan kriteria yang diberikan");
            }
        }
    }
    public ArrayList<Jadwal> searchJadwal(String kotaAwal, String kotaTujuan){
        ArrayList<Jadwal> jadwalList = new ArrayList<>();

        for (Jadwal jadwal : modelJadwal.getAllListJadwal()) {
            if (jadwal.kotaAwal.equalsIgnoreCase(kotaAwal) && jadwal.kotaTujuan.equalsIgnoreCase(kotaTujuan)) {
                jadwalList.add(jadwal);
            }
        }
        if(jadwalList.isEmpty()){
            System.out.println("Pencarian Jadwal Tidak Ditemukan");
    }
        return jadwalList;
    }


}
