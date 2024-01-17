package View;

import java.util.Scanner;

import Controller.ControllerUser;
import Node.User;
import View.ViewPemesanan;

public class ViewUser {
    private ControllerUser kontrolUser;
    private ViewPemesanan viewPemesanan;

    public ViewUser(ControllerUser kontrolUser){
        this.kontrolUser = kontrolUser;
    }

    // public void adminView(){
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

    public void utamaViewUser(){
        Scanner input = new Scanner(System.in);
        int pilih;
        x: while (true){
            String tabel = "| %-20s |%n";
            System.out.format("+----------------------+%n");
            System.out.format(tabel, "Menu User");
            System.out.format("+----------------------+%n");
            System.out.format(tabel, "1. Pesan Tiket");
            System.out.format(tabel, "2. Lihat Pesanan");
            System.out.format(tabel, "3. Kembali");
            System.out.format("+----------------------+%n");
        System.out.print("| Pilih : ");
        pilih = input.nextInt();
        input.nextLine();
        System.out.println("+----------------------+");
            switch (pilih) {
                case 1:
                    // viewPemesanan.pemesananView();
                    break;
                case 2:

                    break;
                case 6:
                    System.out.println("Kembali");
                    break x;
                default:
                    System.out.println("INVALID INPUT!");
                    break;
            }
        }
    }

    public void userView(){
        Scanner input = new Scanner(System.in);
        int pilih;
        x: while (true){
            String tabel = "| %-20s |%n";
            System.out.format("+----------------------+%n");
            System.out.format(tabel, "Menu User");
            System.out.format("+----------------------+%n");
            System.out.format(tabel, "1. Tambah User");
            System.out.format(tabel, "2. Lihat User");
            System.out.format(tabel, "3. Update User");
            System.out.format(tabel, "4. Hapus User");
            System.out.format(tabel, "5. Cari User");
            System.out.format(tabel, "6. Kembali");
            System.out.format("+----------------------+%n");
        System.out.print("| Pilih : ");
        pilih = input.nextInt();
        input.nextLine();
        System.out.println("+----------------------+");
            switch (pilih) {
                case 1:
                    insertUser();
                    break;
                case 2:
                    viewUser();
                    break;
                case 3:
                    updateUser();
                    break;
                case 4:
                    deleteUser();
                    break;
                case 5:
                    searchUser();
                    break;
                case 6:
                    System.out.println("Kembali");
                    break x;
                default:
                    System.out.println("INVALID INPUT!");
                    break;
            }
        }
    }

    public void viewUser(){
    System.out.println("- Menampilkan Data User -");
    System.out.println("==============================");
    for(User user : kontrolUser.viewAllUser()){
        System.out.println("Username : "+user.username);
        System.out.println("Password : "+user.password);
        System.out.println("Nama : "+user.nama);
        System.out.println("NIK  : "+user.nik);
        System.out.println("Telp : "+user.telp);
        System.out.println("==============================");
    }
}

    public void insertUser(){
        Scanner input = new Scanner(System.in);
        System.out.println("- Tambah User -");
        System.out.print("Masukkan Username : ");
        String username = input.nextLine();
        System.out.print("Masukkan Password : ");
        String password = input.nextLine();
        System.out.print("Masukkan Nama : ");
        String nama = input.nextLine();
        System.out.print("Masukkan NIK : ");
        String nik = input.nextLine();
        System.out.print("Masukkan Telp : ");
        String telp = input.nextLine();
        System.out.println("User Berhasil Di Tambahkan");
        kontrolUser.insertUser(username, password, nama, nik, telp);
    }

    public void updateUser(){
        Scanner input = new Scanner(System.in);
        System.out.println("- Update User -");
        System.out.print("Masukkan Username : ");
        String username = input.nextLine();
        User user = kontrolUser.searchUser(username);
        if(user == null){
            System.out.println("PENGGUNA TIDAK DITEMUKAN!");
        }else{
            System.out.println("Ubah No Telp : ");
            String newTelp = input.nextLine();
            System.out.println("User Berhasil Di Update");
            kontrolUser.updateUser(username, newTelp);
        }
    }

    public void deleteUser(){
        Scanner input = new Scanner(System.in);
        System.out.println("- Hapus User -");
        System.out.print("Masukkan Username : ");
        String username = input.nextLine();
        User user = kontrolUser.searchUser(username);
        if(user == null){
            System.out.println("PENGGUNA TIDAK DITEMUKAN!");
        }else{
            System.out.println("- User Berhasil Di Hapus -");
            kontrolUser.deleteUser(username);;
        }
    }

    public void searchUser(){
        Scanner input = new Scanner(System.in);
        System.out.println("- Pencarian User -");
        System.out.print("Masukkan Username : ");
        String username = input.nextLine();
        User user = kontrolUser.searchUser(username);
        if (user == null) {
            System.out.println("PENGGUNA TIDAK DITEMUKAN!");
        }else{
            System.out.println("- User Ditemukan -");
            System.out.println("Username : "+user.username);
            System.out.println("Password : "+user.password);
            System.out.println("Nama : "+user.nama);
            System.out.println("NIK  : "+user.nik);
            System.out.println("Telp : "+user.telp);
        }
    }
}
