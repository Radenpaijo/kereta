package Controller;

import java.util.ArrayList;

import com.google.gson.reflect.TypeToken;

import ModelJSON.ModelJSON;
import Node.Admin;
import Node.User;
import View.ViewAdmin;
import View.ViewUser;
public class ControllerLogin {
    private ViewAdmin viewAdmin;
    private ViewUser viewUser;

    public ControllerLogin(ViewAdmin viewAdmin, ViewUser viewUser) {
        this.viewAdmin = viewAdmin;
        this.viewUser = viewUser;
    }

    public void validasiLogin(String username, String password) {
        ArrayList<User> listUser = new ModelJSON<User>("Database/DatabaseUser.json").readFromFile(new TypeToken<ArrayList<User>>() {}.getType());
        if(listUser != null) {
            for(User user : listUser) {
                if(user.username.equalsIgnoreCase(username) && user.password.equals(password)) {
                    viewUser.userView();
                }
            }
        }

        ArrayList<Admin> listAdmin = new ModelJSON<Admin>("Database/DatabaseAdmin.json").readFromFile(new TypeToken<ArrayList<Admin>>() {}.getType());
        if(listAdmin != null) {
            for(Admin admin : listAdmin) {
                if(admin.username.equalsIgnoreCase(username) && admin.password.equals(password)) {
                    viewAdmin.utamaAdminView();
                }
            }
        }
    }
}


