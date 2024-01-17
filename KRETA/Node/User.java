package Node;

public class User extends Admin {
    public String nik;
    public String nama;
    public String telp;

    public User(String username, String password, String nik, String nama, String telp) {
        super(username, password);
        this.nik = nik;
        this.nama = nama;
        this.telp = telp;
    }

    public void viewUser(){
        System.out.println("Username : " + this.username);
        System.out.println("Password : " + this.password);
        System.out.println("NIK  : " + this.nik);
        System.out.println("Nama : " + this.nama);
        System.out.println("Telp : " + this.telp);
    }
}
