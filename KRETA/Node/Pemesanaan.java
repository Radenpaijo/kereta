package Node;

public class Pemesanaan {
    public String idPemesanan;
    public User user;
    public Jadwal jadwal;
    public int jumlah;
    public int total;

    public Pemesanaan(User user, Jadwal jadwal, int jumlah){
        this.user = user;
        this.jadwal = jadwal;
        this.jumlah = jumlah;
        this.total = jumlah*setHarga();
    }
    public void Display(){
        System.out.println("Nama : "+user.nama);
        System.out.println("Kota Awal : "+jadwal.kotaAwal);
        System.out.println("Kota Tujuan : "+ jadwal.kotaTujuan);
        System.out.println("Jumlah : "+jumlah + " Orang");
        System.out.println("Total Harga : "+total);
    }
    public int setHarga(){
        return jadwal.harga;
    }

    public String setNamaUser() {
        return user.nama;
    }
}