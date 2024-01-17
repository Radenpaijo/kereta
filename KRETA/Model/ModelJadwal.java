 package Model;

 import java.util.ArrayList;
 import java.util.Objects;

 import ModelJSON.ModelJSON;
 import Node.Jadwal;
 import com.google.gson.reflect.TypeToken;

 public class ModelJadwal {
     ArrayList<Jadwal> ListJadwal;
      ModelJSON<Jadwal> modelJSONJadwal;

      public ModelJadwal(){
          ListJadwal = new ArrayList<Jadwal>();
          modelJSONJadwal = new ModelJSON<Jadwal>("Database/DatabaseJadwal.json");
          loadData();
      }

      public void addJadwal(Jadwal jadwal){
          ListJadwal.add(jadwal);
          commitData();
      }

      public Jadwal searchKodeJadwal(int kode){
          Jadwal jadwal = null;
          for (Jadwal schedule : ListJadwal){
              if (Objects.equals(schedule.kodeJadwal, kode)){
                  return schedule;
              }
          }
          return jadwal;
      }
      public Jadwal searchKodeAwalTujuan(String kotaAwal, String kotaTujuan, int kode){
        Jadwal jadwal = null;
        for (Jadwal schedule : ListJadwal){
            if (schedule.kotaAwal.equalsIgnoreCase(kotaAwal)){
                return schedule;
            }
        }
        return jadwal;
    }

     public Jadwal searchKotaAwalJadwal(String kotaAwal){
         Jadwal jadwal = null;
         for (Jadwal schedule : ListJadwal){
             if (schedule.kotaAwal.contains(kotaAwal)){
                 return schedule;
             }
         }
         return jadwal;
     }
     public Jadwal searchKotaTujuanJadwal(String kotaTujuan){
         Jadwal jadwal = null;
         for (Jadwal schedule : ListJadwal){
             if (Objects.equals(schedule.kotaTujuan, kotaTujuan)){
                 return schedule;
             }
         }
         return jadwal;
     }
      public ArrayList<Jadwal> getAllListJadwal(){
          return ListJadwal;
      }

//      public void updateJadwal(int kode, Jadwal jadwal){
//          ListJadwal.contains(jadwal);
//      }

      public void deleteJadwal(Jadwal jadwal){
          ListJadwal.remove(jadwal);
          commitData();
      }

      private void loadData(){
          ListJadwal = modelJSONJadwal.readFromFile(new TypeToken<ArrayList<Jadwal>>(){}.getType());
      }

      public void commitData(){
          modelJSONJadwal.writeToFile(ListJadwal);
      }
 }
