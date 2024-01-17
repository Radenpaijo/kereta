import Controller.*;
import Model.*;
// import Controller.ControllerAdmin;
import Controller.ControllerKereta;
import Node.Jadwal;
import Node.Kereta;
import Node.Pemesanaan;
import Node.User;
import View.*;

import java.util.ArrayList;
import java.util.Scanner;
// import View.ViewAdmin;

public class Main {
    public static void main(String[] args) {
        ModelUser modelUser = new ModelUser();
        ModelKereta modelKereta = new ModelKereta();
        ModelAdmin modelAdmin = new ModelAdmin();
        ModelJadwal modelJadwal = new ModelJadwal();
        ModelPemesanan modelPemesanan = new ModelPemesanan();

        ControllerUser controllerUser = new ControllerUser(modelUser);
        ControllerKereta controllerKereta = new ControllerKereta(modelKereta);
        ControllerAdmin controllerAdmin = new ControllerAdmin(modelAdmin);
        ControllerJadwal controllerJadwal = new ControllerJadwal(modelJadwal, modelKereta);
        ControllerPemesanan controllerPemesanan = new ControllerPemesanan(modelPemesanan, modelJadwal, modelUser);

        ViewKereta viewKereta = new ViewKereta(controllerKereta);
        ViewUser viewUser = new ViewUser(controllerUser);
        ViewJadwal viewJadwal = new ViewJadwal(controllerJadwal);
        ViewAdmin viewAdmin = new ViewAdmin(controllerAdmin,viewUser,viewKereta,viewJadwal);
        ViewPemesanan viewPemesanan = new ViewPemesanan(controllerPemesanan);

        ControllerLogin controllerLogin = new ControllerLogin(viewAdmin, viewUser);

        ViewLogin viewLogin = new ViewLogin(controllerLogin, controllerAdmin, controllerUser);


//        User user = new User("bret", "bret", "12345678", "Loss Brett", "09876543");
//        Kereta kereta = new Kereta("Masinis", 5);
//        Jadwal jadwal = new Jadwal("Surabaya", "Malang", "12.20", kereta, 2, 150000);
//        Pemesanaan pesan = new Pemesanaan(user, jadwal, 2);
//        pesan.Display();

//        controllerPemesanan.insertPemesanan("adit", "Surabaya", "Malang", 2, 2);
//        viewKereta.keretaView();
//        viewUser.userView();
//        viewAdmin.adminView();
//        viewJadwal.jadwalView()
//        viewLogin.menuAwalan();
//        viewPemesanan.viewPemesanan();


        Scanner input = new Scanner(System.in);
        int pilih;
        x : while (true){
            System.out.println("1. Daftar");
            System.out.println("2. Login");
            System.out.println("3. Keluar");
            System.out.print("Masukkan Pilih : ");
            pilih = input.nextInt();
            switch (pilih){
                case 1:
                    viewUser.insertUser();
                    break ;
                case 2:
                    viewLogin.insertLogin();
                    break ;
                case 3:
                    System.out.println("Keluar Program");
                    break x;
                default:
                    System.out.println("INVALID INPUT");
                    break ;
            }
        }
    }
}