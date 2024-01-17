package Node;

import java.time.LocalDate;

public class Jadwal {
    public String kotaAwal;
    public String kotaTujuan;
    public String jam;
    public int kodeJadwal;
    public Kereta kereta;
    public int harga;

    public Jadwal(String kotaAwal, String kotaTujuan, String jam, Kereta kereta, int kodeJadwal, int harga) {
        this.kodeJadwal = kodeJadwal;
        setTanggal(kodeJadwal);
        this.kotaAwal = kotaAwal;
        this.kotaTujuan = kotaTujuan;
        this.jam = jam;
        this.kereta = kereta;
        this.harga = harga;
    }

    public void viewJadwal(){
        System.out.println("Kereta\t\t : "+this.kereta.nama);
        System.out.println("Kota Awal\t : "+this.kotaAwal);
        System.out.println("Kota Tujuan\t : "+this.kotaTujuan);
        System.out.println("Jam\t\t\t : "+this.jam);
        System.out.println("Harga \t\t : "+this.harga);
    }

    public void setTanggal(int kodeJadwal){
        if (kodeJadwal == 0){
            LocalDate tanggal = LocalDate.now();
            System.out.println(tanggal);
        } else{
            LocalDate today = LocalDate.now();
            LocalDate next1 = today.plusDays(kodeJadwal);
            System.out.println(next1);
        }
    }
}
