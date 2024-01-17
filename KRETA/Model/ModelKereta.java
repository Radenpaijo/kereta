package Model;

import java.util.ArrayList;

import ModelJSON.ModelJSON;
import com.google.gson.reflect.TypeToken;

import Node.Kereta;

public class ModelKereta {
    ArrayList<Kereta> ListKereta;
    ModelJSON<Kereta> modelJSONKereta;

    public ModelKereta(){
        ListKereta = new ArrayList<Kereta>();
        modelJSONKereta = new ModelJSON<Kereta>("Database/DatabaseKereta.json");
        loadData();
    }

    public void addKereta(Kereta train){
        ListKereta.add(train);
        commitData();
    }

    public Kereta searchKereta(String nama){
        Kereta kereta = null;
        for (Kereta train : ListKereta){
            if (train.nama.contains(nama)){
                return train;
            }
        }
        return kereta;
    }

    public ArrayList<Kereta> getAllListKereta(){
        return ListKereta;
    }

    public void updateKereta(String nama, Kereta kereta){
        ListKereta.contains(kereta);
        commitData();
    }

    public void deleteKereta(Kereta kereta){
        ListKereta.remove(kereta);
        commitData();
    }

    public void loadData(){
        ListKereta = modelJSONKereta.readFromFile(new TypeToken<ArrayList<Kereta>>(){}.getType());
    }

    public void commitData(){
        modelJSONKereta.writeToFile(ListKereta);
    }
}
