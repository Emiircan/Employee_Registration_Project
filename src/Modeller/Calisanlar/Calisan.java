package Modeller.Calisanlar;

import Modeller.Departmanlar.Departman;
import Veritabani.Calisanlar;
import Veritabani.Departmanlar;

import java.util.ArrayList;

public class Calisan {

    private String calisanId;
    private String adSoyad;
    private int maas;
    private Departman Departman;
    private String isimKodu = "";

    public Calisan(String adSoyad, int maas, String departmanKodu) {
        this.adSoyad = adSoyad;
        this.maas = maas;
        setDepartman(departmanKodu);
        this.setCalisanId();
        Calisanlar.addACalisan(this);
    }

    private void setDepartman(String departman) {
      for (Departman d: Departmanlar.getDepartmanList()){
          if (d.getDepartmanKodu().equals(departman))
              this.Departman=d;
      }
    }


    private void setCalisanId() {
        this.calisanId=this.Departman.getDepartmanKodu()+(Calisanlar.getCalisanList().size()+1)+this.getCalisanIsimKodu();
    }

    private String getCalisanIsimKodu() {
      this.isimKodu +=this.adSoyad.charAt(0);

        for (int i = 0; i < this.adSoyad.length(); i++) {
            if (adSoyad.charAt(i)==' '){
                this.isimKodu+=adSoyad.charAt(i+1);
            }
        }
        return this.isimKodu.toUpperCase();
    }

    public String getCalisanId() {
        return this.calisanId;
    }

    public Departman getDepartman() {
        return this.Departman;
    }

    public String getDepartmanAdi() {
        String departman="";
        if (this.Departman.getDepartmanKodu().equals("YD")){
            departman="Yönetim Departmanı";
        }else if (this.Departman.getDepartmanKodu().equals("BTD")){
            departman="Bilişim Teklonojileri Departmanı";
        } else if (this.Departman.getDepartmanKodu().equals("IKD")) {
            departman="Insan Kaynakları Departmanı";
        }
        return departman;
    }

    public static void zamYap(String calisanId) {
        ArrayList<Calisan> calisanList=Calisanlar.getCalisanList();
        for (int i = 0; i < calisanList.size(); i++) {
            if (calisanList.get(i).getCalisanId().equals(calisanId)){
                calisanList.get(i).maas+=(calisanList.get(i).maas*calisanList.get(i).Departman.getZamOrani())/100;
            }
        }

    }

    @Override
    public String toString() {
        return  "Calisan ID : '" + calisanId + '\'' +
                ", Isim Soyisim : '" + adSoyad + '\'' +
                ", Maas : '" + maas + '\'' +
                ", Departman : '" + getDepartmanAdi() + '\'';
    }
}
