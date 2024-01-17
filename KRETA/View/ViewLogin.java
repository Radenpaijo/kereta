package View;

import Controller.ControllerLogin;
import Controller.ControllerUser;
import Node.User;

import java.util.Scanner;

import Controller.ControllerLogin;
import Controller.ControllerAdmin;
import View.ViewUser.*;

import javax.swing.text.View;

public class ViewLogin {

    private ControllerLogin controllerLogin;
    private ControllerAdmin controllerAdmin;
    private ControllerUser controllerUser;
//    private ViewUser viewUser;

    public ViewLogin(ControllerLogin controllerLogin, ControllerAdmin controllerAdmin, ControllerUser controllerUser) {
        this.controllerLogin = controllerLogin;
        this.controllerAdmin = controllerAdmin;
        this.controllerUser = controllerUser;
    }

    // public void awalLogin() {
    //     Scanner input = new Scanner(System.in);
    //     System.out.print("Masukkan username: ");
    //     String username = input.nextLine();
    //     System.out.print("Masukkan password: ");
    //     String password = input.nextLine();
    // }

    public void insertLogin() {
        Scanner input = new Scanner(System.in);
        System.out.println(" - LOGIN -");
        System.out.print("Masukkan username: ");
        String username = input.nextLine();
        System.out.print("Masukkan password: ");
        String password = input.nextLine();
        controllerLogin.validasiLogin(username, password);
    }
}