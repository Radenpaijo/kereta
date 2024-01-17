package Controller;

import Model.ModelJadwal;
import Model.ModelPemesanan;
import Model.ModelUser;
import Node.Jadwal;
import Node.Pemesanaan;

import java.util.ArrayList;

public class ControllerPemesanan {
    private ModelPemesanan modelPemesanan;
    public ModelJadwal modelJadwal;
    public ModelUser modelUser;

    public ControllerPemesanan(ModelPemesanan modelPemesanan, ModelJadwal modelJadwal, ModelUser modelUser){
        this.modelPemesanan = modelPemesanan;
        this.modelJadwal = modelJadwal;
        this.modelUser = modelUser;
    }
    public ArrayList<Pemesanaan> viewAllPemesanan(){
        return modelPemesanan.getListPemesanan();
    }
    public void insertPemesanan(String username, String kotaAwal, String kotaTujuan, int kode, int jumlah){
        Jadwal jadwal = modelJadwal.searchKodeAwalTujuan(kotaAwal, kotaTujuan, kode);
        if(jadwal == null){
            System.out.println("Jadwal Tidak Ditemukan");
        }else {
            if(jadwal.kotaAwal.equalsIgnoreCase(kotaAwal) && jadwal.kotaTujuan.equalsIgnoreCase(kotaTujuan)){
                modelPemesanan.addPemesanan(new Pemesanaan(modelUser.searchUser(username), modelJadwal.searchKodeAwalTujuan(kotaAwal, kotaTujuan, kode), jumlah));
                System.out.println("Pemesanan Telah DiBuat");
            }else{
                System.out.println("nothing");
            }   
        }
    }
}
