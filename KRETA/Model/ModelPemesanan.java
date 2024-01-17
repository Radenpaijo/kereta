package Model;

import ModelJSON.ModelJSON;
import Node.Pemesanaan;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class ModelPemesanan {
    ArrayList<Pemesanaan> listPemesanan;
    ModelJSON<Pemesanaan> modelJSONPemesanan;

    public ModelPemesanan(){
        listPemesanan = new ArrayList<>();
        modelJSONPemesanan = new ModelJSON<Pemesanaan>("Database/DatabasePemesanan.json");
        loadData();
    }
    public void addPemesanan(Pemesanaan order){
        listPemesanan.add(order);
        commitData();
    }
    public void deletePemesanan(Pemesanaan order){
        listPemesanan.remove(order);
        commitData();
    }
    public ArrayList<Pemesanaan> getListPemesanan(){
        return listPemesanan;
    }
    public void loadData(){
        listPemesanan = modelJSONPemesanan.readFromFile(new TypeToken<ArrayList<Pemesanaan>>(){}.getType());
    }

    public void commitData(){
        modelJSONPemesanan.writeToFile(listPemesanan);
    }
}
