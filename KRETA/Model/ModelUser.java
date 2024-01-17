package Model;

import java.util.ArrayList;
import ModelJSON.ModelJSON;
import com.google.gson.reflect.TypeToken;

import Node.User;

public class ModelUser {
    ArrayList<User> ListUser;
    ModelJSON<User> modelJSONUser;

    public ModelUser(){
        ListUser = new ArrayList<User>();
        modelJSONUser = new ModelJSON<User>("Database/DatabaseUser.json");
        loadData();
    }

    public void addUser(User pengguna) {
        ListUser.add(pengguna);
        commitData();
    }

    public User searchUser(String username){
        User user = null;
        for (User akun : ListUser){
            if (akun.username.contains(username)){
                return akun;
            }
        }
        return user;
    }

    public ArrayList<User> getAllUser(){
        return ListUser;
    }

    public void updateUser(String username, User pengguna)  {
        ListUser.contains(pengguna);
        commitData();
    }

    public void deleteUser(User user){
        ListUser.remove(user);
        commitData();
    }

    private void loadData(){
        ListUser = modelJSONUser.readFromFile(new TypeToken<ArrayList<User>>()
            {}.getType());
    }

    public void commitData(){
        modelJSONUser.writeToFile(ListUser);
    }
}
