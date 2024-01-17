package Node;

public class Kereta {
    public String kelas;
    public String nama;

    public int duduk;
    public int jumlahGerbong;
    public int kapasitas;

    public Kereta(String nama,int jumlahGerbong) {
        this.nama = nama;

        this.jumlahGerbong = jumlahGerbong;
        this.duduk = 30;
        this.kapasitas = duduk*jumlahGerbong;
    }

    public void viewKereta(){
        System.out.println(nama +" - ");
        System.out.println(jumlahGerbong + " Gerbong");
        System.out.println("Kuota : "+kapasitas);
    }
}
