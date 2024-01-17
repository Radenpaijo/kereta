package Controller;

import java.util.ArrayList;

import Model.ModelKereta;
import Node.Kereta;

public class ControllerKereta {

    private ModelKereta kereta;

    public ControllerKereta(ModelKereta kereta){
        this.kereta = kereta;
    }
    public ArrayList<Kereta> viewAllKereta(){
        return kereta.getAllListKereta();
    }

    public void insertKereta(String nama, int jumlahGerbong){
        kereta.addKereta(new Kereta(nama, jumlahGerbong));
    }

    public void updateKereta(String nama, int newGerbong){
        Kereta train = kereta.searchKereta(nama);
        if (train == null){
            System.out.println("Kereta tidak ditemukan");
        }else{
            train.jumlahGerbong = newGerbong;
            train.kapasitas = newGerbong*30;

            kereta.updateKereta(train.nama, train);
        }
    }

    public void deleteKereta(String nama){
        Kereta train = kereta.searchKereta(nama);
        if (train == null){
            System.out.println("Kereta tidak ditemukan");
        }else{
            kereta.deleteKereta(train);
        }
    }

    public Kereta searchKereta(String nama){
        return kereta.searchKereta(nama);
    }


}
