package Veritabani;

import Modeller.Calisanlar.Calisan;
import Modeller.Departmanlar.Departman;

import java.util.ArrayList;

public class Calisanlar {

    private static ArrayList<Calisan> calisanList = new ArrayList<>();

    public static ArrayList<Calisan> getCalisanList() {
        return calisanList;
    }

    public static void addACalisan(Calisan calisan) {
        Calisanlar.calisanList.add(calisan);
    }

    public static void deleteACalisanWithId(String calisanId) {
        for (int i = 0; i < calisanList.size(); i++) {
            if (calisanList.get(i).getCalisanId().equals(calisanId))
                calisanList.remove(calisanList.get(i));
        }

    }

    public static void printDepartmandakiCalisanlar(String departmanKodu) {
        Departman d = null;
        for (Departman departman : Departmanlar.getDepartmanList()) {
            if (departman.getDepartmanKodu().equals(departmanKodu))
                d = departman;
        }
        for (Calisan calisan : calisanList) {
            if (calisan.getDepartman() == d)
                System.out.println(calisan);
        }


    }

    public static void printCalisanlar() {
        for (Calisan calisan : calisanList) {
            System.out.println(calisan.toString());
        }

    }


}
