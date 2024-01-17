package ModelJSON;

import com.google.gson.JsonArray;

import java.lang.reflect.Type;
import java.util.ArrayList;

public interface GSON<T>{
    public boolean cekFile();
    public void setupFile();
    public JsonArray convertListToJsonArray(ArrayList<T> list);
    public ArrayList<T> convertJsonArrayToList(JsonArray jsonArray, Type type);
    public void writeToFile(ArrayList<T> list);
    public ArrayList<T> readFromFile(Type type);
}
