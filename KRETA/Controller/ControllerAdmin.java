 package Controller;

 import java.util.ArrayList;

 import Model.ModelAdmin;
 import Node.Admin;

 public class ControllerAdmin {
     private ModelAdmin admin;

     public ControllerAdmin(ModelAdmin admin) {
         this.admin = admin;
     }

     public ArrayList<Admin> viewAllAdmin() {
         return admin.getAllAdmin();
     }

     public void insertAdmin(String username, String password) {
         admin.addAdmin(new Admin(username, password));
     }

      public void updateUser (String username, String newPass){
          Admin pengguna = admin.searchAdmin(username);
          if (pengguna == null){
              System.out.println("Pengguna tidak ditemukan");
          }else{
              pengguna.password = newPass;
              admin.updateAdmin(username, pengguna);
          }
      }

     public void deleteAdmin (String username){
         Admin pengguna = admin.searchAdmin(username);
         if (pengguna == null) {
             System.out.println("Pengguna tidak ditemukan");
         }else{
             admin.deleteAdmin(pengguna);
         }
     }

     public Admin searchAdmin(String username){
         return admin.searchAdmin(username);
     }
 }
