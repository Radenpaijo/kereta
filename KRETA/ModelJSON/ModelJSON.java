package ModelJSON;

import java.io.*;
import java.util.ArrayList;
import java.lang.reflect.Type;

import com.google.gson.*;

public class ModelJSON<T> implements GSON<T>{
    public String fname;

    public ModelJSON(String fname){
        this.fname = fname;
        setupFile();
    }

    @Override
    public boolean cekFile(){
        boolean status = false;
        if (new java.io.File(fname).exists()){
            status = true;
        }
        return status;
    }

    @Override
    public void setupFile(){
        try{
            if (cekFile() == false){
                File file = new File(fname);
                if (file.createNewFile()){
                    try(FileWriter fileWriter = new FileWriter(file, true);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
                        bufferedWriter.write("[]");
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                }
            }
        }catch(IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    @Override
    public JsonArray convertListToJsonArray(ArrayList<T> list) {
        return new Gson().toJsonTree(list).getAsJsonArray();
    }
    @Override
    public ArrayList<T> convertJsonArrayToList(JsonArray jsonArray, Type type){
        Gson gson = new Gson();
        return gson.fromJson(jsonArray, type);
    }

    @Override
    public void writeToFile(ArrayList<T> list){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(list);
        try(FileWriter file = new FileWriter(fname)){
            file.write(json);
        }catch (IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<T> readFromFile(Type type) {
        ArrayList<T> list = new ArrayList<>();
        try (Reader reader = new FileReader(fname)) {
            JsonArray jsonArray = new JsonParser().parse(reader).getAsJsonArray();
            list = convertJsonArrayToList(jsonArray, type);
        } catch (Exception e) {
            System.out.println("Error.wer");
            e.printStackTrace();
        }
        return list;
    }
}
