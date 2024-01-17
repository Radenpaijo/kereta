 package View;

 import java.util.Scanner;
 import Node.Admin;
 import Controller.ControllerAdmin;

 public class ViewAdmin {

     private ControllerAdmin kontrolAdmin;
     private ViewJadwal viewJadwal;
     private ViewKereta viewKereta;
     private ViewUser viewUser;

     public ViewAdmin(ControllerAdmin kontrolAdmin, ViewUser viewUser, ViewKereta viewKereta, ViewJadwal viewJadwal) {
         this.kontrolAdmin = kontrolAdmin;
         this.viewUser = viewUser;
         this.viewKereta = viewKereta;
         this.viewJadwal = viewJadwal;
     }

     public void utamaAdminView(){
        Scanner input = new Scanner(System.in);
        int pilih;
        x: while (true){
            String tabel = "| %-20s |%n";
            System.out.format("+----------------------+%n");
            System.out.format(tabel, "Menu Admin");
            System.out.format("+----------------------+%n");
            System.out.format(tabel, "1. Insert Admin");
            System.out.format(tabel, "2. View Admin");
            System.out.format(tabel, "3. Menu Kereta");
            System.out.format(tabel, "4. Menu Jadwal");
            System.out.format(tabel, "5. Menu User");
            System.out.format(tabel, "6. Kembali");
            System.out.format("+----------------------+%n");
            System.out.print("| Pilih : ");
            pilih = input.nextInt();
            input.nextLine();
            System.out.println("+----------------------+");
            switch (pilih) {
                 case 1:
                     insertAdmin();
                     break;
                 case 2:
                     viewAdmin();
                     break;
                 case 3:
                     viewKereta.keretaView();
                     break;
                 case 4:
                     viewJadwal.jadwalView();
                     break ;
                 case 5:
                     viewUser.userView();
                     break ;
                 case 6:
                     System.out.println("Keluar");
                     break x;
                 default:
                     System.out.println("INVALID INPUT!");
                     break;
             }
         }
     }

     public void adminView() {
         Scanner input = new Scanner(System.in);
         int pilih;
         x: while (true){
             String tabel = "| %-20s |%n";
             System.out.format("+----------------------+%n");
             System.out.format(tabel, "Menu Admin");
             System.out.format("+----------------------+%n");
             System.out.format(tabel, "1. Insert Admin");
             System.out.format(tabel, "2. View Admin");
             System.out.format(tabel, "3. Update Admin");
             System.out.format(tabel, "4. Delete Admin");
             System.out.format(tabel, "5. Kembali");
             System.out.format("+----------------------+%n");
             System.out.print("| Pilih : ");
             pilih = input.nextInt();
             input.nextLine();
             System.out.println("+----------------------+");
             switch (pilih) {
                 case 1:
                     insertAdmin();;
                     break;
                 case 2:
                     viewAdmin();;
                     break;
                 case 3:
                     updateAdmin();
                     break;
                 case 4:
                     deleteAdmin();
                     break ;
                 case 5:
                     System.out.println("Keluar");
                     break x;
                 default:
                     System.out.println("INVALID INPUT!");
                     break;
             }
         }
     }

     public void viewAdmin(){
         System.out.println("- Menampilkan Data User -");
         System.out.println("==============================");
         for(Admin admin : kontrolAdmin.viewAllAdmin()){
             System.out.println("Username : "+admin.username);
             System.out.println("Password : "+admin.password);
             System.out.println("==============================");
         }
     }

     public void insertAdmin(){
         Scanner input = new Scanner(System.in);
         System.out.println("- Tambah Admin -");
         System.out.print("Masukkan Username : ");
         String username = input.nextLine();
         System.out.print("Masukkan Password : ");
         String password = input.nextLine();
         System.out.println("Admin Berhasil Di Tambahkan");
         kontrolAdmin.insertAdmin(username, password);
     }
     public void updateAdmin(){
         Scanner input = new Scanner(System.in);
         System.out.println("- Update Admin -");
         System.out.print("Masukkan Username : ");
         String username = input.nextLine();
         Admin admin = kontrolAdmin.searchAdmin(username);
         if(admin == null){
             System.out.println("PENGGUNA TIDAK DITEMUKAN!");
         }else{
             System.out.print("Masukkan Password Baru : ");
             String newPass = input.nextLine();
             System.out.println("- Admin Berhasil Di Update -");
             kontrolAdmin.updateUser(username, newPass);
         }
     }
     public void deleteAdmin(){
         Scanner input = new Scanner(System.in);
         System.out.println("- Hapus Admin -");
         System.out.print("Masukkan Username : ");
         String username = input.nextLine();
         Admin admin = kontrolAdmin.searchAdmin(username);
         if(admin == null){
             System.out.println("PENGGUNA TIDAK DITEMUKAN!");
         }else{
             System.out.println("- Admin Berhasil Di Hapus -");
             kontrolAdmin.deleteAdmin(username);
         }
     }

     public void searchAdmin(){
         Scanner input = new Scanner(System.in);
         System.out.println("- Pencarian Admin -");
         System.out.print("Masukkan Username : ");
         String username = input.nextLine();
         Admin admin = kontrolAdmin.searchAdmin(username);
         if (admin == null) {
             System.out.println("PENGGUNA TIDAK DITEMUKAN!");
         }else{
             System.out.println("- Admin Ditemukan -");
             System.out.println("Username : "+admin.username);
             System.out.println("Password : "+admin.password);
         }
     }


     //     public void adminView(){
     //     Scanner input = new Scanner(System.in);
     //     int pilih;
     //     x: while (true){
     //         String tabel = "| %-20s |%n";
     //         System.out.format("+----------------------+%n");
     //         System.out.format(tabel, "Menu User");
     //         System.out.format("+----------------------+%n");
     //         System.out.format(tabel, "1. Menu User");
     //         System.out.format(tabel, "2. Menu Kereta");
     //         System.out.format(tabel, "3. Kembali");
     //         System.out.format("+----------------------+%n");
     //         System.out.print("| Pilih : ");
     //         pilih = input.nextInt();
     //         input.nextLine();
     //         System.out.println("+----------------------+");
     //         switch (pilih) {
     //             case 1:
     //                 userView();
     //                 break;
     //             case 2:
     //                 keretaView();
     //                 break;
     //             case 3:
     //                 System.out.println("Keluar");
     //                 break x;
     //             default:
     //                 System.out.println("INVALID INPUT!");
     //                 break;
     //         }
     //     }
     // }
 }
