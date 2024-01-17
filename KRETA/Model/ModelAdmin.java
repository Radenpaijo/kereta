 package Model;

 import java.util.ArrayList;

 import ModelJSON.ModelJSON;
 import com.google.gson.reflect.TypeToken;

 import Node.Admin;
 public class ModelAdmin {
     ArrayList<Admin> ListAdmin;
     ModelJSON<Admin> modelJSONAdmin;

     public ModelAdmin(){
         ListAdmin = new ArrayList<Admin>();
         modelJSONAdmin = new ModelJSON<Admin>("Database/DatabaseAdmin.json");
         loadData();
     }

     public void addAdmin(Admin admin) {
         ListAdmin.add(admin);
     }

     public Admin searchAdmin(String username){
         Admin admin = null;
         for (Admin mimin : ListAdmin){
             if (mimin.username.contains(username)){
                 return mimin;
             }
         }
         return admin;
     }

     public ArrayList<Admin> getAllAdmin(){
         return ListAdmin;
     }

     public void updateAdmin(String username, Admin admin){
         ListAdmin.contains(admin);
     }

     public void deleteAdmin(Admin admin){
         ListAdmin.remove(admin);
     }

     private void loadData(){
         ListAdmin = modelJSONAdmin.readFromFile(new TypeToken<ArrayList<Admin>>() {}.getType());
     }

     public void commitData(){
         modelJSONAdmin.writeToFile(ListAdmin);
     }
 }
